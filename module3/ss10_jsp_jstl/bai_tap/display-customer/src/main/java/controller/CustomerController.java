package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerController", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer[] customers = new Customer[5];
        customers[0] = new Customer("Phương","2000-10-10","bãi rác","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPf7fOCK3WZ6EJ3CHA4DHYWa-W6Be-M9M-rtIWlzFuIO8QeVp0kcVzWj9JavEtMrxreVQ&usqp=CAU");
        customers[1] = new Customer("Hậu","2001-11-11","xó núi","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEBlkjuoc6a9DppoJhUkSxOx8sw4P9dn6ICxom-E4fuvZoVRk3hOdAAdYYVYo6fEZUKJw&usqp=CAU");
        customers[2] = new Customer("Luận","2002-02-02","bãi rác","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnnnfuJ3yOTfYyNGwzHa1fx3tZ-vXh51yU18D-G0Sd0caraWZfcaK0qGdj8lVUsU5vScE&usqp=CAU");
        customers[3] = new Customer("Trí","2003-03-03","thiên đàng","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVLSI_T8_kgSmtGprn2JnmqFhsUMdtfq-tA1V3nGI1W3EFYdIqyLpirwiO3z2YuIKem7w&usqp=CAU");
        customers[4] = new Customer("Phúc","2004-04-04","địa ngục","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrExHxGswSyinbe1HJfB5W378zZLXXM5nxlQ&usqp=CAU");

        request.setAttribute("listCustomer",customers);

        request.getRequestDispatcher("customer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
