package com.phuong.controller;

import com.phuong.dto.ErrorDto;
import com.phuong.dto.PaymentDto;
import com.phuong.model.Customer;
import com.phuong.model.ProductOrder;
import com.phuong.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductOrderController {

    @Autowired
    private IProductOrderService productOrderService;

    @Autowired
    public JavaMailSender emailSender;

    @Value("${FE_URL}")
    private String apiUrl;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add/cart")
    public ResponseEntity<?> addToCart(@RequestBody ProductOrder productOrder) {
        ErrorDto err = this.productOrderService.saveOrder(productOrder);

        if (err.getMessage() != null) {
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(productOrder, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/minus/quantity")
    public ResponseEntity<?> minusQuantityCart(@RequestBody ProductOrder productOrder) {
        List<ProductOrder> productOrderList = this.productOrderService.getProductInCardByCustomer(productOrder.getCustomer());
        Boolean check = this.productOrderService.minusQuantity(productOrder);
        if (check) {
            return new ResponseEntity<>(productOrderList, HttpStatus.OK);
        }
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("minimum");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/plus/quantity")
    public ResponseEntity<?> plusQuantityCart(@RequestBody ProductOrder productOrder) {
        List<ProductOrder> productOrderList = this.productOrderService.getProductInCardByCustomer(productOrder.getCustomer());
        Boolean check = this.productOrderService.plusQuantity(productOrder);
        if (check) {
            return new ResponseEntity<>(productOrderList, HttpStatus.OK);
        }
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("maximum");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/delete")
    public ResponseEntity<?> deleteProductInCart(@RequestBody ProductOrder productOrder) {
        Boolean check = this.productOrderService.findProductOrder(productOrder);
        if (check) {
            List<ProductOrder> productOrderList = this.productOrderService.getProductInCardByCustomer(productOrder.getCustomer());
            return new ResponseEntity<>(productOrderList, HttpStatus.OK);
        }
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("notfound");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/products")
    public ResponseEntity<?> getProductInCard(@RequestBody Customer customer) {
        List<ProductOrder> productOrderList = this.productOrderService.getProductInCardByCustomer(customer);
        if (productOrderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productOrderList, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/payment")
    public ResponseEntity<?> goPayment(@RequestBody Customer customer) throws MessagingException {
        PaymentDto paymentDto = this.productOrderService.goPayment(customer);

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String htmlMsg = createHTMLMailForm(paymentDto);
        message.setContent(htmlMsg, "text/html; charset=UTF-8");

        helper.setTo(paymentDto.getCustomer().getEmail());

        helper.setSubject("[XIAOMI Store] Hóa đơn thanh toán");

        this.emailSender.send(message);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String createHTMLMailForm(PaymentDto paymentDto) {
        String template = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                "    <title> Order confirmation </title>\n" +
                "    <meta name=\"robots\" content=\"noindex,nofollow\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0;\"/>\n" +
                "    <style type=\"text/css\">\n" +
                "        @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);\n" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background: #e1e1e1;\n" +
                "        }\n" +
                "\n" +
                "        div, p, a, li, td {\n" +
                "            -webkit-text-size-adjust: none;\n" +
                "        }\n" +
                "\n" +
                "        .ReadMsgBody {\n" +
                "            width: 100%;\n" +
                "            background-color: #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        .ExternalClass {\n" +
                "            width: 100%;\n" +
                "            background-color: #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            width: 100%;\n" +
                "            height: 100%;\n" +
                "            background-color: #e1e1e1;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            -webkit-font-smoothing: antialiased;\n" +
                "        }\n" +
                "\n" +
                "        html {\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            padding: 0 !important;\n" +
                "            margin-top: 0 !important;\n" +
                "            margin-right: 0 !important;\n" +
                "            margin-bottom: 0 !important;\n" +
                "            margin-left: 0 !important;\n" +
                "        }\n" +
                "\n" +
                "        .visibleMobile {\n" +
                "            display: none;\n" +
                "        }\n" +
                "\n" +
                "        .hiddenMobile {\n" +
                "            display: block;\n" +
                "        }\n" +
                "\n" +
                "        @media only screen and (max-width: 600px) {\n" +
                "            body {\n" +
                "                width: auto !important;\n" +
                "            }\n" +
                "\n" +
                "            table[class=fullTable] {\n" +
                "                width: 96% !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "\n" +
                "            table[class=fullPadding] {\n" +
                "                width: 85% !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "\n" +
                "            table[class=col] {\n" +
                "                width: 45% !important;\n" +
                "            }\n" +
                "\n" +
                "            .erase {\n" +
                "                display: none;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        @media only screen and (max-width: 420px) {\n" +
                "            table[class=fullTable] {\n" +
                "                width: 100% !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "\n" +
                "            table[class=fullPadding] {\n" +
                "                width: 85% !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "\n" +
                "            table[class=col] {\n" +
                "                width: 100% !important;\n" +
                "                clear: both;\n" +
                "            }\n" +
                "\n" +
                "            table[class=col] td {\n" +
                "                text-align: left !important;\n" +
                "            }\n" +
                "\n" +
                "            .erase {\n" +
                "                display: none;\n" +
                "                font-size: 0;\n" +
                "                max-height: 0;\n" +
                "                line-height: 0;\n" +
                "                padding: 0;\n" +
                "            }\n" +
                "\n" +
                "            .visibleMobile {\n" +
                "                display: block !important;\n" +
                "            }\n" +
                "\n" +
                "            .hiddenMobile {\n" +
                "                display: none !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!-- Header -->\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\" bgcolor=\"#e1e1e1\">\n" +
                "    <tr>\n" +
                "        <td height=\"20\"></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table width=\"600\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\"\n" +
                "                   bgcolor=\"#ffffff\" style=\"border-radius: 10px 10px 0 0;\">\n" +
                "                <tr class=\"hiddenMobile\">\n" +
                "                    <td height=\"40\"></td>\n" +
                "                </tr>\n" +
                "                <tr class=\"visibleMobile\">\n" +
                "                    <td height=\"30\"></td>\n" +
                "                </tr>\n" +
                "\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table width=\"480\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"\n" +
                "                               class=\"fullPadding\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <table width=\"220\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\"\n" +
                "                                           class=\"col\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td align=\"left\"><span style=\"font-size: 26px\"><strong\n" +
                "                                                    style=\"text-transform: uppercase; color: #D19C97\">XIAOMI</strong> Store</span>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        <tr class=\"hiddenMobile\">\n" +
                "                                            <td height=\"40\"></td>\n" +
                "                                        </tr>\n" +
                "                                        <tr class=\"visibleMobile\">\n" +
                "                                            <td height=\"20\"></td>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"font-size: 12px; color: #5b5b5b; font-family: 'Open Sans', sans-serif; line-height: 18px; vertical-align: top; text-align: left;\">\n" +
                "                                                Chào, <strong>" + paymentDto.getCustomer().getName() + "</strong>.\n" +
                "                                                <br> Cảm ơn bạn đã mua sắm từ cửa hàng của chúng tôi.\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "                                    <table width=\"220\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\"\n" +
                "                                           class=\"col\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr class=\"visibleMobile\">\n" +
                "                                            <td height=\"20\"></td>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                            <td height=\"5\"></td>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"font-size: 21px; color: #ff0000; letter-spacing: -1px; font-family: 'Open Sans', sans-serif; line-height: 1; vertical-align: top; text-align: right;\">\n" +
                "                                                Hóa đơn thanh toán\n" +
                "                                             </td>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                        <tr class=\"hiddenMobile\">\n" +
                "                                            <td height=\"50\"></td>\n" +
                "                                        </tr>\n" +
                "                                        <tr class=\"visibleMobile\">\n" +
                "                                            <td height=\"20\"></td>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"font-size: 12px; color: #5b5b5b; font-family: 'Open Sans', sans-serif; line-height: 18px; vertical-align: top; text-align: right;\">\n" +
                "                                                <small>Hóa đơn: </small> #" + paymentDto.getBill().getCode() + "<br/>\n" +
                "                                                <small>Ngày tạo: </small>" + new SimpleDateFormat("dd/MM/yyyy").format(paymentDto.getBill().getCreationDate()) + "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<!-- /Header -->\n" +
                "<!-- Order Details -->\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\" bgcolor=\"#e1e1e1\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table width=\"600\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\"\n" +
                "                   bgcolor=\"#ffffff\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                <tr class=\"hiddenMobile\">\n" +
                "                    <td height=\"60\"></td>\n" +
                "                </tr>\n" +
                "                <tr class=\"visibleMobile\">\n" +
                "                    <td height=\"40\"></td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table width=\"480\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"\n" +
                "                               class=\"fullPadding\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <th style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #5b5b5b; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 10px 7px 0;\"\n" +
                "                                    width=\"52%\" align=\"left\">\n" +
                "                                    Sản phẩm\n" +
                "                                </th>\n" +
                "                                <th style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #5b5b5b; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 10px 7px 0;\"\n" +
                "                                    align=\"center\">\n" +
                "                                    Số lượng\n" +
                "                                </th>\n" +
                "                                <th style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #1e2b33; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 10px 7px 0;\"\n" +
                "                                    align=\"right\">\n" +
                "                                    Thành tiền\n" +
                "                                </th>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td height=\"1\" style=\"background: #bebebe;\" colspan=\"4\"></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td height=\"10\" colspan=\"4\"></td>\n" +
                "                            </tr>\n";
        Double totalMoney = 0d;
        Double shipMoney = 50_000d;
        for (int i = 0; i < paymentDto.getProductOrderList().size(); i++) {
            Double productPrice = paymentDto.getProductOrderList().get(i).getProduct().getPrice();
            Double discountCategory = paymentDto.getProductOrderList().get(i).getProduct().getCategory().getDiscountPercent();
            Double discountProduct = paymentDto.getProductOrderList().get(i).getProduct().getDiscountPercent();
            Double priceDiscountCategory = productPrice - (productPrice * discountCategory / 100);
            Double priceDiscountProduct = priceDiscountCategory - (priceDiscountCategory * discountProduct / 100);
            totalMoney += priceDiscountProduct;
            template += "                            <tr>\n" +
                    "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #ff0000;  line-height: 18px;  vertical-align: top; padding:10px 0;\"\n" +
                    "                                    class=\"article\">\n" +
                    "                                    " + paymentDto.getProductOrderList().get(i).getProduct().getName() + "\n" +
                    "                                </td>\n" +
                    "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e;  line-height: 18px;  vertical-align: top; padding:10px 0;\"\n" +
                    "                                    align=\"center\">" + paymentDto.getProductOrderList().get(i).getQuantity() + "\n" +
                    "                                </td>\n" +
                    "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #1e2b33;  line-height: 18px;  vertical-align: top; padding:10px 0;\"\n" +
                    "                                    align=\"right\">" + new DecimalFormat("###,###,###.##").format(priceDiscountProduct) + "<sup>đ</sup>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n";
        }
        template += "                            <tr>\n" +
                "                                <td height=\"1\" colspan=\"4\" style=\"border-bottom:1px solid #e4e4e4\"></td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td height=\"20\"></td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<!-- /Order Details -->\n" +
                "<!-- Total -->\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\" bgcolor=\"#e1e1e1\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table width=\"600\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\"\n" +
                "                   bgcolor=\"#ffffff\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <!-- Table Total -->\n" +
                "                        <table width=\"480\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"\n" +
                "                               class=\"fullPadding\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 28px; vertical-align: top; text-align:right; \">\n" +
                "                                    Tổng tiền:\n" +
                "                                </td>\n" +
                "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 22px; vertical-align: top; text-align:right;\"width=\"160\">\n" +
                "                                    " + new DecimalFormat("###,###,###.##").format(totalMoney) + "<sup>đ</sup>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 28px; vertical-align: top; text-align:right; \">\n" +
                "                                    Phí vận chuyển:\n" +
                "                                </td>\n" +
                "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 22px; vertical-align: top; text-align:right; \">\n" +
                "                                    " + new DecimalFormat("###,###,###.##").format(shipMoney) + "<sup>đ</sup>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 28px; vertical-align: top; text-align:right; \">\n" +
                "                                    <strong>Tổng thanh toán: </strong>\n" +
                "                                </td>\n" +
                "                                <td style=\"font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 22px; vertical-align: top; text-align:right; \">\n" +
                "                                    <strong>" + new DecimalFormat("###,###,###.##").format(totalMoney + shipMoney) + "<sup>đ</sup> - $" + new DecimalFormat("###,###,###.##").format((totalMoney + shipMoney) / 23000) + "</strong>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <!-- /Table Total -->\n" +
                "\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<!-- /Total -->\n" +
                "<!-- /Information -->\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\" bgcolor=\"#e1e1e1\">\n" +
                "\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table width=\"600\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" class=\"fullTable\"\n" +
                "                   bgcolor=\"#ffffff\" style=\"border-radius: 0 0 10px 10px;\">\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table width=\"480\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"\n" +
                "                               class=\"fullPadding\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td style=\"font-size: 12px; color: #5b5b5b; font-family: 'Open Sans', sans-serif; line-height: 18px; vertical-align: top; text-align: left;\">\n" +
                "                                    Chúc bạn 1 ngày tốt lành.\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td style=\"font-size: 12px; color: #5b5b5b; font-family: 'Open Sans', sans-serif; line-height: 18px; vertical-align: top; text-align: left;\">\n" +
                "                                    Xem thêm các sản phẩm khác <a style=\"font-weight: bold\" target=\"_blank\" href=\"" + apiUrl + "/product/list\">tại đây</a>.\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr class=\"spacer\">\n" +
                "                    <td height=\"50\"></td>\n" +
                "                </tr>\n" +
                "\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td height=\"20\"></td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";

        return template;
    }
}
