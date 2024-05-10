package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerJdbcRepo;
import com.jsp.repository.DancerMemoryRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chap04/show-list")
public class ShowDancerListServlet extends HttpServlet {

    private DancerJdbcRepo repo = DancerJdbcRepo.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 데이터베이스에 접근하여 댄서 목록을 조회 (위임)
        List<Dancer> dancerList = repo.retrieve();


        req.setAttribute("dancers", dancerList);
        // 적당한 HTML 을 또 JSP 에게 위임하자
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/chap04/dancer-list.jsp");
        rd.forward(req, resp);
    }
}
