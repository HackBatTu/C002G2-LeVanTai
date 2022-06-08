package controller;


import model.Employee;
import model.RentType;
import model.Service;
import model.ServiceType;
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

@WebServlet(name = "ServletHome", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {

    private IServiceService iServiceService = new ServiceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                updateService(request, response);
                break;
            default:
                displayService(request, response);
                break;
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPerson = Integer.parseInt(request.getParameter("maxPerson"));
        String roomStandard = request.getParameter("roomStandard");
        String anotherConvenient = request.getParameter("anotherConvenient");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numOfFloors = Integer.parseInt(request.getParameter("numOfFloors"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        String rentTypeName = request.getParameter("rentTypeName");
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String serviceTypeName = request.getParameter("serviceTypeName");

        iServiceService.getUpdateService(new Service(id, name, area, cost, maxPerson, roomStandard, anotherConvenient, poolArea, numOfFloors, new RentType(rentType, rentTypeName), new ServiceType(serviceType, serviceTypeName)));
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPerson = Integer.parseInt(request.getParameter("maxPerson"));
        String roomStandard = request.getParameter("roomStandard");
        String anotherConvenient = request.getParameter("anotherConvenient");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numOfFloors = Integer.parseInt(request.getParameter("numOfFloors"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        String rentTypeName = request.getParameter("rentTypeName");
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String serviceTypeName = request.getParameter("serviceTypeName");

        iServiceService.getCreateService(new Service(name, area, cost, maxPerson, roomStandard, anotherConvenient, poolArea, numOfFloors, new RentType(rentType, rentTypeName), new ServiceType(serviceType, serviceTypeName)));
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void displayService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = iServiceService.getAllService();
        request.setAttribute("serviceList", serviceList);
        try {
            request.getRequestDispatcher("service/display_service.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                select(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                displayService(request, response);
                break;

        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("nameSearch", name);
        request.setAttribute("serviceList", iServiceService.searchByName(name));
        try {
            request.getRequestDispatcher("service/display_service.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iServiceService.delete(id);
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("rentTypeList", iServiceService.getAllRentType());
        request.setAttribute("serviceTypeList", iServiceService.getAllServiceType());
        Service serviceList = iServiceService.findById(idEdit);

        request.setAttribute("id", serviceList.getId());
        request.setAttribute("name", serviceList.getName());
        request.setAttribute("area", serviceList.getArea());
        request.setAttribute("cost", serviceList.getCost());
        request.setAttribute("maxPerson", serviceList.getMaxPerson());
        request.setAttribute("roomStandard", serviceList.getRoomStandard());
        request.setAttribute("anotherConvenient", serviceList.getAnotherConvenient());
        request.setAttribute("poolArea", serviceList.getPoolArea());
        request.setAttribute("numOfFloors", serviceList.getNumOfFloors());
        request.setAttribute("rentTypeId", serviceList.getRentType().getId());
        request.setAttribute("serviceTypeId", serviceList.getServiceType().getId());
        try {
            request.getRequestDispatcher("service/edit_service.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void select(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("rentTypeList", iServiceService.getAllRentType());
        request.setAttribute("serviceTypeList", iServiceService.getAllServiceType());
        try {
            request.getRequestDispatcher("service/create_service.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}