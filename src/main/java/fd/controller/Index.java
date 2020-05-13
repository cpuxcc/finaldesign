package fd.controller;

import fd.service.IIndexService;
import fd.service.INavigationService;
import fd.service.impl.IndexServiceImpl;
import fd.service.impl.NavigationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/index")
public class Index extends HttpServlet {
    private IIndexService iIndexService=new IndexServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("index");
        req.setAttribute("rankList",iIndexService.rankList());
        req.setAttribute("newList",iIndexService.newCreate(0));
        req.setAttribute("newHighHeat",iIndexService.newHighHeat(0));
        req.setAttribute("coldList",iIndexService.lowAccessHighHeat(0));

        req.getRequestDispatcher("/jsp/index.jsp").forward(req,resp);
    }
}
