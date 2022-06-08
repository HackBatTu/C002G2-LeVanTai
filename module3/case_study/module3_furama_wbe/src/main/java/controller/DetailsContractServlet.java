package controller;

import model.AttachService;
import model.Contract;
import model.DetailsContract;
import model.Service;
import service.IDetailsContractService;
import service.impl.DetailsContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "DetailsContractServlet", urlPatterns = "/details_contract")
public class DetailsContractServlet extends HttpServlet {
    private IDetailsContractService iDetailsContractService = new DetailsContractService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                creatDetailsContract(request, response);
                break;
            case "edit":
                editDetailsContract(request, response);
                break;
            default:
                displayDetailsContract(request, response);
                break;
        }
    }

    private void editDetailsContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int numberContract = Integer.parseInt(request.getParameter("numberContract"));
        int contractId = Integer.parseInt(request.getParameter("contract"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachService"));
        iDetailsContractService.getUpdateDetailsContract(new DetailsContract(id, numberContract, new Contract(contractId), new AttachService(attachServiceId)));
        try {
            response.sendRedirect("/details_contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatDetailsContract(HttpServletRequest request, HttpServletResponse response) {
        int numberContract = Integer.parseInt(request.getParameter("numberContract"));
        int contractId = Integer.parseInt(request.getParameter("contract"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachService"));
        iDetailsContractService.getCreateDetailsContract(new DetailsContract(numberContract, new Contract(contractId), new AttachService(attachServiceId)));
        try {
            response.sendRedirect("/details_contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayDetailsContract(HttpServletRequest request, HttpServletResponse response) {
        List<DetailsContract> detailsContractList = iDetailsContractService.getAllDetailsContract();
        request.setAttribute("detailsContractList", detailsContractList);
        try {
            request.getRequestDispatcher("details_contract/display_details_contract.jsp").forward(request, response);
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
                showUpdateDetailsContract(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                searchById(request, response);
                break;
            default:
                displayDetailsContract(request, response);
                break;
        }
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("nameSearch", id);
        request.setAttribute("contractList", iDetailsContractService.getAllContract());
        request.setAttribute("attachServiceList", iDetailsContractService.getAllAttachService());
        request.setAttribute("detailsContractList", iDetailsContractService.searchById(id));
        try {
            request.getRequestDispatcher("details_contract/display_details_contract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iDetailsContractService.delete(id);
        try {
            response.sendRedirect("/details_contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateDetailsContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("contractList", iDetailsContractService.getAllContract());
        request.setAttribute("attachServiceList", iDetailsContractService.getAllAttachService());
        DetailsContract detailsContract = iDetailsContractService.findById(id);

        request.setAttribute("id", detailsContract.getId());
        request.setAttribute("numberContract", detailsContract.getNumberContract());
        request.setAttribute("contract", detailsContract.getContract().getId());
        request.setAttribute("attachService", detailsContract.getAttachService().getId());
        try {
            request.getRequestDispatcher("details_contract/edit_details_contract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void select(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contractList", iDetailsContractService.getAllContract());
        request.setAttribute("attachServiceList", iDetailsContractService.getAllAttachService());
        try {
            request.getRequestDispatcher("details_contract/create_details_contract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
