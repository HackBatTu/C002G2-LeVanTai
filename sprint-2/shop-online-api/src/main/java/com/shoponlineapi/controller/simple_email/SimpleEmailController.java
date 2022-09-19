package com.shoponlineapi.controller.simple_email;

import com.shoponlineapi.model.account.AppUser;
import com.shoponlineapi.model.jwt.JwtRequest;
import com.shoponlineapi.model.jwt.JwtResponse;
import com.shoponlineapi.service.IAppUserService;
import com.shoponlineapi.security.util.EncrytedPasswordUtils;
import com.shoponlineapi.security.util.JwtTokenUtil;
import com.shoponlineapi.security.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@RestController
@CrossOrigin
public class SimpleEmailController {

    @Value("${FE_URL}")
    private String fe_url;

    @Value("${API_URL}")
    private String api_url;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EncrytedPasswordUtils encrytedPasswordUtils;

    @Value("${spring.mail.username}")
    private String myEmail;

    @Autowired
    private LoginUtil loginUtil;

    private static final List<String> tokenList = new ArrayList<>();

    private static int interval;

    private static Timer timer;

    /**
     * @param jwtRequest
     * @return
     * @date-create 9/8/2022
     */
    @PostMapping("/sendSimpleEmail")
    public ResponseEntity<?> sendSimpleEmail(@RequestBody JwtRequest jwtRequest) throws MessagingException {
        if (jwtRequest.getUsername() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser appUser = this.appUserService.findAppUserByUserName(jwtRequest.getUsername());
        if (appUser != null) {

            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            String token = jwtTokenUtil.generateToken(jwtRequest.getUsername());
            tokenList.add(token);
            String htmlMsg = createHTMLMailForm(token, appUser.getUserName());
            message.setContent(htmlMsg, "text/html; charset=UTF-8");

            helper.setTo(appUser.getCustomer().getEmail());

            helper.setSubject("[Fate-Shop] Lấy lại mật khẩu");

            this.emailSender.send(message);

            timer = new Timer();
            interval = 300;
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    interval--;
                    if (interval == 0) {
                        tokenList.clear();
                        timer.cancel();
                    }
                }
            }, 0, 1000);

            return ResponseEntity.ok(new JwtResponse(token));
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * @param token
     * @param response
     * @return redirect to change password form if true or redirect to login form if false
     * @throws IOException
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    @GetMapping("/forgotPassword/{token}")
    public ResponseEntity<?> getUsernameForChangePassword(@PathVariable String token, HttpServletResponse response) throws IOException {
        if (tokenList.isEmpty()) {
            response.sendRedirect(fe_url + "/login");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        for (String tokenVal : tokenList) {
            if (tokenVal.equals(token)) {
                response.sendRedirect(fe_url + "/forgot/" + token);
                this.loginUtil.getTokenMap().remove(this.jwtTokenUtil.getUsernameFromToken(token));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        response.sendRedirect(fe_url + "/login");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Method change password
     *
     * @param jwtRequest
     * @return status 401 if token null
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    @PostMapping("/findPassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody JwtRequest jwtRequest, BindingResult bindingResult) throws IOException {
        if (tokenList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (checkTokenExists(jwtRequest.getToken())) {
            AppUser appUser = this.appUserService.findAppUserByUserName(jwtTokenUtil.getUsernameFromToken(jwtRequest.getToken()));
            if (appUser != null) {
                if (bindingResult.hasErrors()) {
                    return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
                }
                if (jwtRequest.getPassword().equals(jwtRequest.getConfirmPassword())) {
                    appUser.setPassword(encrytedPasswordUtils.encrytePassword(jwtRequest.getPassword()));
                    Date date = new Date(System.currentTimeMillis());
                    appUser.setCreationDate(date);
                    this.appUserService.updatePassword(appUser);
                    tokenList.remove(jwtRequest.getToken());
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Password Not Same", HttpStatus.OK);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    private boolean checkTokenExists(String token) {
        for (String tokenVal : tokenList) {
            if (token.equals(tokenVal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param token
     * @param username
     * @return
     * @func create html form
     * @date-create 14/8/2022
     */
    private String createHTMLMailForm(String token, String username) {
        return "<!doctype html>\n" +
                "<html lang=\"en-US\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <title>Reset Password Email Template</title>\n" +
                "    <meta name=\"description\" content=\"Reset Password Email Template.\">\n" +
                "    <style type=\"text/css\">\n" +
                "        a:hover {\n" +
                "            text-decoration: underline !important;\n" +
                "        }\n" +
                "        .btn-yellow {\n" +
                "            background-color: #dea704;\n" +
                "            color: white;\n" +
                "        }\n" +
                "        .btn-yellow:hover {\n" +
                "            background-color: #efb403;\n" +
                "            color: white;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">\n" +
                "<table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
                "       style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
                "                   align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                <tr>\n" +
                "                    <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"text-align:center;\">\n" +
                "                        <img width=\"60\"\n" +
                "                             src=\"https://image.similarpng.com/very-thumbnail/2021/09/Coffee-shop-logo-design-template-on-transparent-background-PNG.png\"\n" +
                "                             title=\"logo\"\n" +
                "                             alt=\"logo\" style=\"border-radius: 10px\">\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                               style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
                "                            <tr>\n" +
                "                                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"padding:0 35px;\">\n" +
                "                                    <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:28px;font-family:'Rubik',sans-serif;\">\n" +
                "                                        Chào " + username + "! có vẻ như bạn đã quên mất mật khẩu của mình </h1>\n" +
                "                                    <span\n" +
                "                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
                "                                    <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
                "                                        Chúng tôi không thể gửi mật khẩu cũ cho bạn.\n" +
                "                                        Một liên kết duy nhất để đặt lại mật khẩu của bạn đã được tạo ra.\n" +
                "                                        Để đặt lại mật khẩu, hãy nhấp vào liên kết bên dưới và làm theo hướng dẫn.\n" +
                "                                    </p>\n" +
                "                                    <a href=\"" + api_url + "/forgot/" + token + "\" class=\"btn-yellow\"\n" +
                "                                       style=\" text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:14px;padding:10px 24px;display:inline-block;border-radius:50px;\">Cập\n" +
                "                                        nhật mật khẩu</a>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"height:40px;\">&nbsp;</td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                <tr>\n" +
                "                    <td style=\"height:20px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"text-align:center;\">\n" +
                "                        <p style=\"font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;\">\n" +
                "                            &copy; <strong>C0222G2 - Coffee</strong></p>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"height:80px;\">&nbsp;</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
    }
}
