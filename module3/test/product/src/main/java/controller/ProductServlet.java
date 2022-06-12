package controller;

import model.Category;
import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.setAttribute("categoryList", iProductService.getAllCategory());
                request.getRequestDispatcher("product/create.jsp").forward(request, response);
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
                displayListProduct(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("nameSearch", name);
        request.setAttribute("productList", iProductService.searchByName(name));
        try {
            request.getRequestDispatcher("product/display.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("productList", iProductService.getAllProduct());
        request.setAttribute("categoryList", iProductService.getAllCategory());
        Product product = iProductService.findById(idEdit);
        request.setAttribute("id", product.getId());
        request.setAttribute("name", product.getName());
        request.setAttribute("price", product.getPrice());
        request.setAttribute("quality", product.getQuality());
        request.setAttribute("color", product.getColor());
        request.setAttribute("categoryId", product.getCategory().getId());
        try {
            request.getRequestDispatcher("product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayListProduct(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productList", iProductService.getAllProduct());
        request.setAttribute("categoryList", iProductService.getAllCategory());
        try {
            request.getRequestDispatcher("product/display.jsp").forward(request, response);
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
        switch (action) {
            case "create":
                insertIntoProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            default:
                displayListProduct(request, response);
                break;
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int quality = Integer.parseInt(request.getParameter("quality"));
        String color = request.getParameter("color");
        int category = Integer.parseInt(request.getParameter("category"));
        String categoryName = request.getParameter("categoryName");
        Product product = new Product(id, name, price, quality, color, new Category(category, categoryName));
        iProductService.updateProduct(product);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertIntoProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quality = Integer.parseInt(request.getParameter("quality"));
        String color = request.getParameter("color");
        int category = Integer.parseInt(request.getParameter("category"));
        String categoryName = request.getParameter("categoryName");
        Product product = new Product(name, price, quality, color, new Category(category, categoryName));
        iProductService.insert(product);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
