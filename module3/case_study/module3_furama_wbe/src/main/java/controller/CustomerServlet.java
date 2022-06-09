package controller;

import model.person.Customer;
import model.person.CustomerType;
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
import java.util.Map;


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
        int id = Integer.parseInt(request.getParameter("gender"));
        int idCustomerType = 0;
        String errCustomerType = null;
        try {
            idCustomerType = Integer.parseInt(request.getParameter("customerType"));
        } catch (NumberFormatException e) {
            errCustomerType = "Ôi bạn ơi nhập dữ liệu đi ! ở đó mà f12";
        }
        String nameCustomerType = request.getParameter("nameCustomerType");
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");

        int gender = 0;
        String errGender= null;
        try {
            gender = Integer.parseInt(request.getParameter("gender"));
        } catch (NumberFormatException e) {
            errGender = "Ôi bạn ơi nhập dữ liệu đi ! ở đó mà f12";
        }

        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customerList = new Customer(id,new CustomerType(idCustomerType,nameCustomerType), name, birthDay, gender, idCard, phone, email, address);

        Map<String, String> errors = iCustomerService.update(customerList);
        if (errCustomerType != null) {
            errors.put("customerType", errCustomerType);
        }
        if (errGender != null) {
            errors.put("gender", errGender);
        }
        if(errors.isEmpty()){
            try {
                response.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("errors", errors);
            request.setAttribute("listCustomerType", iCustomerService.getAllCustomerType());
            request.setAttribute("customerType", idCustomerType);
            request.setAttribute("name", name);
            request.setAttribute("birthDay", birthDay);
            request.setAttribute("gender", gender);
            request.setAttribute("idCard", idCard);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            try {
                request.getRequestDispatcher("customer/edit_customer.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idCustomerType = 0;
        String errCustomerType = null;
        try {
            idCustomerType = Integer.parseInt(request.getParameter("customerType"));
        } catch (NumberFormatException e) {
            errCustomerType = "Ôi bạn ơi nhập dữ liệu đi ! ở đó mà f12";
        }
        String nameCustomerType = request.getParameter("nameCustomerType");
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");

        int gender = 0;
        String errGender= null;
        try {
            gender = Integer.parseInt(request.getParameter("gender"));
        } catch (NumberFormatException e) {
            errGender = "Ôi bạn ơi nhập dữ liệu đi ! ở đó mà f12";
        }

        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customerList = new Customer(new CustomerType(idCustomerType,nameCustomerType), name, birthDay, gender, idCard, phone, email, address);

        Map<String, String> errors = iCustomerService.add(customerList);
        if (errCustomerType != null) {
            errors.put("customerType", errCustomerType);
        }
        if (errGender != null) {
            errors.put("gender", errGender);
        }
        if(errors.isEmpty()){
            try {
                response.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("errors", errors);
            request.setAttribute("listCustomerType", iCustomerService.getAllCustomerType());
            request.setAttribute("customerType", idCustomerType);
            request.setAttribute("name", name);
            request.setAttribute("birthDay", birthDay);
            request.setAttribute("gender", gender);
            request.setAttribute("idCard", idCard);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            try {
                request.getRequestDispatcher("customer/create_customer.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
                showEdit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            case "sortByName":
                sortByName(request, response);
                break;
            case "showCustomerService":
                showListCustomerService(request, response);
                break;
            default:
                displayCustomer(request, response);
                break;
        }
    }

    private void showListCustomerService(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listCustomerService", iCustomerService.getAllCustomerServiceDTO());
        try {
            request.getRequestDispatcher("customer/display_customer_service.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("customerList", iCustomerService.sortByName());
            for (Customer customer:iCustomerService.sortByName()) {
                System.out.println(customer);
            }
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
        request.setAttribute("nameSearch",name);
        String customerType = request.getParameter("customerType");
        List<Customer> customerList = iCustomerService.searchByName(name,customerType);
        request.setAttribute("listCustomerType", iCustomerService.getAllCustomerType());
        request.setAttribute("customerList", customerList);
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
        request.setAttribute("listCustomerType", iCustomerService.getAllCustomerType());
        for (Customer customerList : iCustomerService.selectAll()) {
            if (customerList.getId() == id) {
                request.setAttribute("id", customerList.getId());
                request.setAttribute("customerTypeId", customerList.getCustomerType().getId());
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
    private void select(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listCustomerType", iCustomerService.getAllCustomerType());
        try {
            request.getRequestDispatcher("customer/create_customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
