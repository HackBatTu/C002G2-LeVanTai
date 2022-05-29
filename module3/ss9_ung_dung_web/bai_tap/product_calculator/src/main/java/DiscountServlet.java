import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double listPrice = Double.parseDouble(request.getParameter("listPrince "));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));

        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = Double.parseDouble(String.valueOf(listPrice)) - discountAmount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>productDescription: ");
        writer.println("<h1>listPrice: " + listPrice + "</h1>");
        writer.println("<h1>discountPercent: " + discountPercent + "</h1>");
        writer.println("<h1>discountAmount: " + discountAmount + "</h1>");
        writer.println("<h1>Discount Price: " + Double.toString(discountPrice) + "</h1>");
        writer.println("</html>");
    }
}
