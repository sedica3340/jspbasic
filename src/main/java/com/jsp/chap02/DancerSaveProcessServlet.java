package com.jsp.chap02;

import com.jsp.entity.Dancer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chap02/dancer/saveProcess")
public class DancerSaveProcessServlet extends HttpServlet {

    public static List<Dancer> dancerList = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("댄서 정보 등록중...");


        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genres = req.getParameterValues("genres");

        // 댄서 객체 생성
        Dancer dancer = new Dancer();
        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));
        List<Dancer.Genre> genreList = new ArrayList<>();
        for (String genre : genres) {
            genreList.add(Dancer.Genre.valueOf(genre));
        }
        dancer.setGenres(genreList);

        System.out.println("dancer = " + dancer.toString());

        dancerList.add(dancer);

        // 응답 메세지 생성
        resp.setStatus(200);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // 응답 바디에 넣을 html 생성
        PrintWriter w = resp.getWriter();
        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<h1>" + dancer.getName() + "님이 등록되었습니다. </h1>");
        w.write("<a href=\"/chap02/dancer/show-list\"> 댄서 정보 모아보기</a>\n" );
        w.write("</body>\n");
        w.write("</html>");
    }
}
