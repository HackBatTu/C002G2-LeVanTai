package controller;


import model.Service;
import service.IServiceService;
import service.impl.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletHome" , urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {

    private IServiceService iServiceService = new ServiceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            default:
                displayListService(request,response);
                break;


        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("service/display_service.jsp").forward(request,response);
                break;
            default:
                displayListService(request,response);
                break;


        }
    }

    private void displayListService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = iServiceService.selectAllService();
        request.setAttribute("serviceList",serviceList);
        try {
            request.getRequestDispatcher("service/display_service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}