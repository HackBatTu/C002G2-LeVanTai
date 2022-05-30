import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

@WebServlet(name = "Dictionary", urlPatterns = "/dictionary")
public class Dictionary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        String search = request.getParameter("search");

        String result = dic.get(search);

        if (result != null) {
           request.setAttribute("search",search);
             request.setAttribute("result",result);
        } else {
            request.setAttribute("alert","Not found");
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
