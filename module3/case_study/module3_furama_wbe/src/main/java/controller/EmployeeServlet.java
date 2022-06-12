package controller;

import model.person.Division;
import model.person.EducationDegree;
import model.person.Employee;
import model.person.EmployeePosition;
import model.user.User;
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
                displayEmployee(request, response);
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
        int employeePosition = Integer.parseInt(request.getParameter("employeePosition"));
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        int division = Integer.parseInt(request.getParameter("division"));
        String userName = request.getParameter("userName");

        Employee employeeList = new Employee(id, name, birthDay, idCard, salary, phone, email, address, new EmployeePosition(employeePosition), new EducationDegree(educationDegree), new Division(division), new User(userName));
        iEmployeeService.update(employeeList);
        try {
            response.sendRedirect("/employee");
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
        int employeePosition = Integer.parseInt(request.getParameter("employeePosition"));
        String employeePosition_name = request.getParameter("employeePosition_name");
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        String educationDegree_name = request.getParameter("educationDegree_name");
        int division = Integer.parseInt(request.getParameter("division"));
        String division_name = request.getParameter("division_name");
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        Employee employeeList = new Employee(name, birthDay, idCard, salary, phone, email, address, new EmployeePosition(employeePosition, employeePosition_name), new EducationDegree(educationDegree, educationDegree_name), new Division(division, division_name), new User(username, password));
        iEmployeeService.add(employeeList);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployeeService.selectAll();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("employee/display_employee.jsp").forward(request, response);
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
            case "delete":
                delete(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                displayEmployee(request, response);
                break;
        }
    }

    private void select(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listEmployeePosition", iEmployeeService.getAllEmployeePosition());
        request.setAttribute("listEducationDegree", iEmployeeService.getAllEducationDegree());
        request.setAttribute("listDivision", iEmployeeService.getAllDivision());
        request.setAttribute("listUser", iEmployeeService.getAllUser());
        try {
            request.getRequestDispatcher("employee/create_employee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        request.setAttribute("nameSearch", name);
        request.setAttribute("emailSearch", email);
        request.setAttribute("employeeList", iEmployeeService.searchByName(name,email));
        try {
            request.getRequestDispatcher("employee/display_employee.jsp").forward(request, response);
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
        int idEdit = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("listEmployeePosition", iEmployeeService.getAllEmployeePosition());
        request.setAttribute("listEducationDegree", iEmployeeService.getAllEducationDegree());
        request.setAttribute("listDivision", iEmployeeService.getAllDivision());
        request.setAttribute("listUser", iEmployeeService.getAllUser());
        Employee employeeList = iEmployeeService.findById(idEdit);
        request.setAttribute("id", employeeList.getId());
        request.setAttribute("name", employeeList.getName());
        request.setAttribute("birthDay", employeeList.getBirthDay());
        request.setAttribute("idCard", employeeList.getIdCard());
        request.setAttribute("salary", employeeList.getSalary());
        request.setAttribute("phone", employeeList.getPhone());
        request.setAttribute("email", employeeList.getEmail());
        request.setAttribute("address", employeeList.getAddress());
        request.setAttribute("employeePositionId", employeeList.getEmployeePosition().getId());
        request.setAttribute("educationDegreeId", employeeList.getEducationDegree().getId());
        request.setAttribute("divisionId", employeeList.getDivision().getId());
        request.setAttribute("userNames", employeeList.getUserName().getUsername());
        try {
            request.getRequestDispatcher("employee/edit_employee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

