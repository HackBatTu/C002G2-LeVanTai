package controller;

import model.Customer;
import model.CustomerType;
import repository.customer.CustomerRepository;
import repository.customerType.CustomerTypeRepository;
import validation.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerRepository customerRepository = new CustomerRepository();
    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":

                break;
            default:
                showList(request, response);
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
                showCreate(request, response);
                break;
            case "edit":
                showUpdate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeRepository.selectAll();
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerRepository.findById(id);
        request.setAttribute("customerType", customerTypeList);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerRepository.delete(id);
        showList(request, response);
    }





    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeRepository.selectAll();
        request.setAttribute("customerType", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerRepository.selectAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("test-paging-sorting.jsp");
        dispatcher.forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String msg = null;
        boolean flag = false;
        String name = request.getParameter("name");
        String idCard = request.getParameter("idCard");
        if (Validate.regexIdCard(idCard)) {
            msg = "Id Card not match";
            flag = true;
        }
        ;
        String phone = request.getParameter("phone");
        int idCustomerType = Integer.parseInt(request.getParameter("id_customer_type"));
        Customer customer = new Customer(name, idCard, phone, new CustomerType(idCustomerType));
        try {
            if (flag) {
                request.setAttribute("msgIdCard", msg);
                request.setAttribute("customer", customer);
                showCreate(request, response);
            } else {
                customerRepository.insert(customer);
                response.sendRedirect("/customer");
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }


    private void search(HttpServletRequest request, HttpServletResponse response) {

    }

}
