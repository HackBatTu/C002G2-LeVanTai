package controller;

import model.*;
import service.IContractService;
import service.impl.ContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private IContractService iContractService = new ContractService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request,response);
                break;
            case "edit":
                updateContract(request,response);
                break;
            default:
                displayContract(request,response);
                break;
        }
    }

    private void updateContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String dateCheckIn = request.getParameter("dateCheckIn");
        String dateCheckOut = request.getParameter("dateCheckOut");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int employeeId = Integer.parseInt(request.getParameter("employee"));
        String employeeName = request.getParameter("employeeName");
        int customerId = Integer.parseInt(request.getParameter("customer"));
        String customerName = request.getParameter("customerName");
        int serviceId = Integer.parseInt(request.getParameter("service"));
        String serviceName = request.getParameter("serviceName");
        iContractService.getUpdateContract(new Contract(id,dateCheckIn,dateCheckOut,deposit,totalMoney,new Employee(employeeId,employeeName),new Customer(customerId,customerName),new Service(serviceId,serviceName)));
        try {
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String dateCheckIn = request.getParameter("dateCheckIn");
        String dateCheckOut = request.getParameter("dateCheckOut");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int employeeId = Integer.parseInt(request.getParameter("employee"));
        String employeeName = request.getParameter("employeeName");
        int customerId = Integer.parseInt(request.getParameter("customer"));
        String customerName = request.getParameter("customerName");
        int serviceId = Integer.parseInt(request.getParameter("service"));
        String serviceName = request.getParameter("serviceName");
        iContractService.getCreateContract(new Contract(dateCheckIn,dateCheckOut,deposit,totalMoney,new Employee(employeeId,employeeName),new Customer(customerId,customerName),new Service(serviceId,serviceName)));
        try {
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = iContractService.getAllContract();
        request.setAttribute("contractList",contractList);
        try {
            request.getRequestDispatcher("contract/display_contract.jsp").forward(request,response);
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
                select(request,response);
                break;
            case "edit":
                showUpdate(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                searchById(request,response);
                break;
            default:
                displayContract(request,response);
                break;
        }
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("nameSearch",id);
        request.setAttribute("employeeList",iContractService.getAllEmployee());
        request.setAttribute("customerList",iContractService.getAllCustomer());
        request.setAttribute("serviceList",iContractService.getAllService());
        request.setAttribute("contractList",iContractService.findById(id));
        try {
            request.getRequestDispatcher("contract/display_contract.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iContractService.delete(id);
        try {
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("employeeList",iContractService.getAllEmployee());
        request.setAttribute("customerList",iContractService.getAllCustomer());
        request.setAttribute("serviceList",iContractService.getAllService());
        Contract contractList = iContractService.findById(idEdit) ;
            if (contractList.getId() == idEdit) {
                request.setAttribute("id", contractList.getId());
                request.setAttribute("dateCheckIn", contractList.getDateCheckIn());
                request.setAttribute("dateCheckOut", contractList.getDateCheckOut());
                request.setAttribute("deposit", contractList.getDeposit());
                request.setAttribute("totalMoney", contractList.getTotalMoney());
                request.setAttribute("employeeId", contractList.getEmployee().getId());
                request.setAttribute("customerId", contractList.getCustomer().getId());
                request.setAttribute("serviceId", contractList.getService().getId());
                try {
                    request.getRequestDispatcher("contract/edit_contract.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    private void select(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList",iContractService.getAllEmployee());
        request.setAttribute("customerList",iContractService.getAllCustomer());
        request.setAttribute("serviceList",iContractService.getAllService());
        try {
            request.getRequestDispatcher("contract/create_contract.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
