package controller;

import model.Student;
import service.IStudentService;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "add":
                request.getRequestDispatcher("view_student/add.jsp").forward(request,response);
                break;
            case "showEdit":
                showEdit(request,response);
                break;
            case "search":
                searchByName(request,response);
                break;
            case "sort":
                sortByName(request,response);
                break;
            default:
                listStudent(request,response);
                break;

        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("listStudent",studentService.sortByName());
            request.getRequestDispatcher("view_student/list.jsp").forward(request, response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("listStudent",studentService.searchByName(name));
        try {
            request.getRequestDispatcher("view_student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Student student : studentService.selectAllStudent()) {
            if (student.getId() == id) {
                request.setAttribute("id", id);
                request.setAttribute("name", student.getName());
                request.setAttribute("point", student.getPoint());
                request.setAttribute("gender", student.getGender());
                break;
            }
        }
        try {
            request.getRequestDispatcher("view_student/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentService.selectAllStudent();
        request.setAttribute("listStudent",students);
        try {
            request.getRequestDispatcher("view_student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "add":
                addStudent(request,response);
                break;
            case "edit":
                editStudent(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                listStudent(request,response);
                break;
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        studentService.deleteStudent(id);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double point = Double.parseDouble(request.getParameter("point"));
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        Student student = new Student(id,name,point,gender);
        this.studentService.editStudent(student);
        try {
            request.getRequestDispatcher("view_student/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double point = Double.parseDouble(request.getParameter("point"));
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        Student student = new Student(name,point,gender);
        this.studentService.add(student);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
