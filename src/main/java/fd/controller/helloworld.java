package fd.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/helloworld")
public class helloworld extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());

        req.setAttribute("user","wxj");
        System.out.println(req.getAttribute("user"));
        //resp.sendRedirect("");
        req.getRequestDispatcher("/jsp/helloworld.jsp").forward(req,resp);
    }
}
