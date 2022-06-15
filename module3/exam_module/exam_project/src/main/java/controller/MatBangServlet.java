package controller;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;
import service.IMatBangService;
import service.impl.MatBangService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ExamServlet", value = "/mat_bang")
public class MatBangServlet extends HttpServlet {
    private IMatBangService iMatBangService = new MatBangService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request,response);
                break;
            case "delete" :
                delete(request,response);
                break;
            default:
                displayListMatBang(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        iMatBangService.delete(id);
        try {
            response.sendRedirect("/mat_bang");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<TrangThai> trangThaiList = iMatBangService.getAllTrangThai();
        List<LoaiVanPhong> loaiVanPhongList = iMatBangService.getAllLoaiVanPhong();
        request.setAttribute("trangThaiList", trangThaiList);
        request.setAttribute("loaiVanPhongList", loaiVanPhongList);
        try {
            request.getRequestDispatcher("mat_bang/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayListMatBang(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> contractList = iMatBangService.getAllMatBang();
        List<TrangThai> trangThaiList = iMatBangService.getAllTrangThai();
        List<LoaiVanPhong> loaiVanPhongList = iMatBangService.getAllLoaiVanPhong();

        request.setAttribute("matBangList", contractList);
        try {
            request.getRequestDispatcher("mat_bang/display.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertInto(request,response);
                break;
            default:
                displayListMatBang(request,response);
                break;
        }
    }

    private void insertInto(HttpServletRequest request, HttpServletResponse response) {
        String id =  request.getParameter("id");
        double area = 0;
        double prince= 0;
        String errArea = null;
        String errPrice = null;
        try {
            area = Double.parseDouble(request.getParameter("area"));
            prince = Double.parseDouble(request.getParameter("prince"));

        } catch (NumberFormatException e) {
            errPrice = "Ôi bạn ơi nhập dữ liệu đi nhập kiểu số thực ! ở đó mà f12";
            errArea = "Ôi bạn ơi nhập dữ liệu đi nhập kiểu số thực ! ở đó mà f12";
        }
        int status = 0;
        String errStatus = null;
        int numberOfFloor =0;
        String errNumberOfFloor =null;
        int loaiVanPhong =0;
        String errLoaiVanPhong =null;
        try {
             status = Integer.parseInt(request.getParameter("status"));
             numberOfFloor = Integer.parseInt(request.getParameter("numberOfFloor"));
             loaiVanPhong = Integer.parseInt(request.getParameter("loaiVanPhong"));
        } catch (NumberFormatException e) {
            errStatus = "Ôi bạn ơi nhập dữ liệu đi nhập kiểu số nguyên ! ở đó mà f12";
            errNumberOfFloor = "Ôi bạn ơi nhập dữ liệu đi nhập kiểu số nguyên! ở đó mà f12";
            errLoaiVanPhong = "Ôi bạn ơi nhập dữ liệu đi nhập kiểu số nguyên ! ở đó mà f12";

        }
        String statusName = request.getParameter("statusName");
        String loaiVanPhongName = request.getParameter("loaiVanPhongName");
        String moTa = request.getParameter("moTa");
        String dateCheckIn = request.getParameter("dateCheckIn");
        String dateCheckOut = request.getParameter("dateCheckOut");
        Map<String,String> errors = iMatBangService.getCreateMatBang(new MatBang(id,area,new TrangThai(status, statusName),numberOfFloor, new LoaiVanPhong(loaiVanPhong, loaiVanPhongName),moTa,prince,dateCheckIn, dateCheckOut));
        if (errArea != null) {
            errors.put("area", errArea);
        }
        if (errStatus != null) {
            errors.put("status", errStatus);
        }
        if (errNumberOfFloor != null) {
            errors.put("numberOfFloor", errNumberOfFloor);
        }
        if (errPrice != null) {
            errors.put("prince", errPrice);
        }
        if (errLoaiVanPhong != null) {
            errors.put("loaiVanPhong", errLoaiVanPhong);
        }
        if(errors.isEmpty()){
            try {
                response.sendRedirect("/mat_bang");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("errors", errors);
            request.setAttribute("trangThaiList", iMatBangService.getAllTrangThai());
            request.setAttribute("loaiVanPhongList", iMatBangService.getAllLoaiVanPhong());
            request.setAttribute("id", id);
            request.setAttribute("area", area);
            request.setAttribute("status", status);
            request.setAttribute("numberOfFloor", numberOfFloor);
            request.setAttribute("loaiVanPhong", loaiVanPhong);
            request.setAttribute("moTa", moTa);
            request.setAttribute("prince", prince);
            request.setAttribute("dateCheckIn", dateCheckIn);
            request.setAttribute("dateCheckOut", dateCheckOut);
            try {
                request.getRequestDispatcher("mat_bang/create.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
