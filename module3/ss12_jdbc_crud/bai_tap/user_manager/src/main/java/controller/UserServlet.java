package controller;

import model.User;
import repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserRepository userRepository;

    public void init() {
        userRepository = new UserRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "viewCountry":
                    viewCountry(request,response);
                    break;
                case "delete":
                    deleteUser(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void viewCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        request.setAttribute("listUser", userRepository.findByCountry(country));
        try {
            request.getRequestDispatcher("user/viewCountry.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userRepository.deleteUser(id);
            request.getRequestDispatcher("user/delete.jsp").forward(request,response);
            try {
                response.sendRedirect("/users");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
//        userRepository.insertUser(newUser);
        userRepository.insertUserStore(newUser);

        request.getRequestDispatcher("user/create.jsp").forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        userRepository.updateUser(book);
       request.getRequestDispatcher("user/edit.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteUser(request, response);
                    break;
                case "sortByName":
                    softByName(request,response);
                    break;
                case "permision":
                    addUserPermision(request, response);
                    break;
                case "test-without-tran":

                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":

                    testUseTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        userRepository.insertUpdateUseTransaction();
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userRepository.insertUpdateWithoutTransaction();
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        userRepository.addUserTransaction(user, permision);

    }

    private void softByName(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userRepository.sortByName();
        try {
            request.setAttribute("listUser", users);
            request.getRequestDispatcher("user/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userRepository.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userRepository.selectUser(id);
        User existingUser = userRepository.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void showDeleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userRepository.deleteUser(id);
        List<User> listUser = userRepository.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/delete.jsp");
        dispatcher.forward(request, response);
    }
}
