package controller;

import model.Customer;
import model.CustomerType;
import service.impl.CustomerService;
import service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            default:
                displayCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int idCustomerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customerList = new Customer(id, new CustomerType(idCustomerType), name, birthDay, gender, idCard, phone, email, address);
        iCustomerService.update(customerList);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public Customer(int id, CustomerType customerType, String name, String birthDay, int gender, String idCard, String phone, String email, String address) {

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idCustomerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customerList = new Customer(new CustomerType(idCustomerType), name, birthDay, gender, idCard, phone, email, address);
        iCustomerService.add(customerList);
        try {
            response.sendRedirect("/customer");
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
                request.getRequestDispatcher("customer/create_customer.jsp").forward(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            default:
                displayCustomer(request, response);
                break;
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("customerList", iCustomerService.sortByName());
            request.getRequestDispatcher("customer/display_customer.jsp").forward(request, response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("customerList", iCustomerService.searchByName(name));
        try {
            request.getRequestDispatcher("customer/display_customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Customer customerList : iCustomerService.selectAll()) {
            if (customerList.getId() == id) {
                request.setAttribute("id", customerList.getId());
                request.setAttribute("customerType", customerList.getCustomerType().getId());
                request.setAttribute("name", customerList.getName());
                request.setAttribute("birthDay", customerList.getBirthDay());
                request.setAttribute("gender", customerList.getGender());
                request.setAttribute("idCard", customerList.getIdCard());
                request.setAttribute("phone", customerList.getPhone());
                request.setAttribute("email", customerList.getEmail());
                request.setAttribute("address", customerList.getAddress());
                try {
                    request.getRequestDispatcher("customer/edit_customer.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.selectAll();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/display_customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
