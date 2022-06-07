package controller;

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
            default:
                displayDetailsContract(request,response);
                break;
        }
    }

    private void displayDetailsContract(HttpServletRequest request, HttpServletResponse response) {
        List<DetailsContract> detailsContractList = iDetailsContractService.getAllDetailsContract();
        request.setAttribute("detailsContractList",detailsContractList);
        try {
            request.getRequestDispatcher("details_contract/display_details_contract.jsp").forward(request,response);
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
            default:
                displayDetailsContract(request,response);
                break;
        }
    }
}
