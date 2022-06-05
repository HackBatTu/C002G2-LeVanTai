package controller;

import model.*;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            default:
                displayEmployee(request,response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int employeePosition_id = Integer.parseInt(request.getParameter("employeePosition"));
        int educationDegree_id = Integer.parseInt(request.getParameter("educationDegree"));
        int division_id = Integer.parseInt(request.getParameter("division"));
        String userName = request.getParameter("userName");

        Employee employeeList = new Employee(id,name, birthDay, idCard,salary, phone, email, address,new EmployeePosition(employeePosition_id),new EducationDegree(educationDegree_id),new Division(division_id),new User(userName));
        iEmployeeService.update(employeeList);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
            String name = request.getParameter("name");
            String birthDay = request.getParameter("birthDay");
            String idCard = request.getParameter("idCard");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            int employeePosition_id = Integer.parseInt(request.getParameter("employeePosition"));
            int educationDegree_id = Integer.parseInt(request.getParameter("educationDegree"));
            int division_id = Integer.parseInt(request.getParameter("division"));
            String userName = request.getParameter("userName");

        Employee employeeList = new Employee(name, birthDay, idCard,salary, phone, email, address,new EmployeePosition(employeePosition_id),new EducationDegree(educationDegree_id),new Division(division_id),new User(userName));
            iEmployeeService.add(employeeList);
            try {
                response.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployeeService.selectAll();
        request.setAttribute("employeeList",employeeList);
        try {
            request.getRequestDispatcher("employee/display_employee.jsp").forward(request,response);
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
                request.getRequestDispatcher("employee/create_employee.jsp").forward(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                displayEmployee(request,response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("customerList", iEmployeeService.searchByName(name));
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
        iEmployeeService.delete(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Employee employeeList : iEmployeeService.selectAll()) {
            if (employeeList.getId() == id) {
                request.setAttribute("id", employeeList.getId());
                request.setAttribute("name", employeeList.getName());
                request.setAttribute("birthDay", employeeList.getBirthDay());
                request.setAttribute("idCard", employeeList.getIdCard());
                request.setAttribute("salary", employeeList.getSalary());
                request.setAttribute("phone", employeeList.getPhone());
                request.setAttribute("email", employeeList.getEmail());
                request.setAttribute("address", employeeList.getAddress());
                request.setAttribute("employeePosition", employeeList.getEmployeePosition().getId());
                request.setAttribute("educationDegree", employeeList.getEducationDegree().getId());
                request.setAttribute("division", employeeList.getDivision().getId());
                request.setAttribute("userName", employeeList.getUserName().getUsername());
                try {
                    request.getRequestDispatcher("employee/edit_employee.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
