package com.jsp.repository;

import com.jsp.chap05.Person;
import com.jsp.entity.Dancer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 역할: 실제 데이터베이스에 댄서들을 CRUD
// Model
public class DancerJdbcRepo {

    private String username = "root"; // db 계정명
    private String password = "mariadb"; // db 패스워드
    private String url = "jdbc:mariadb://localhost:3306/spring5"; // db url : 데이터베이스 설치 위치
    private String driverClassName = "org.mariadb.jdbc.Driver"; // db 벤더별 전용 커넥터 클래스

    private static DancerJdbcRepo repo = new DancerJdbcRepo();

    // 싱글톤 구현
    private DancerJdbcRepo() {}

    // 싱글 객체를 리턴하는 메서드
    public static DancerJdbcRepo getInstance() {
        return repo;
    }


    // 댄서를 데이터베이스에 저장하는 기능
    public boolean save(Dancer d) {
        try (Connection conn
                     = DriverManager.getConnection(url, username, password)){
            // 1. 연결 드라이버 로딩
            Class.forName(driverClassName);

            // 2. 데이터베이스 접속

            // 3. 실행할 SQL 생성
            String sql = "INSERT INTO tbl_dancer " +
                    "(name, crew_name, dance_level) " +
                    "VALUES (?, ?, ?)";

            // 4. SQL 실행 객체 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 5. ? 값 채우기
            pstmt.setString(1, d.getName());
            pstmt.setString(2, d.getCrewName());
            pstmt.setString(3, d.getDanceLevel().toString());

            // 6. 실행 명령
            // INSERT, UPDATE, DELETE 같은 명령을 사용
            pstmt.executeUpdate();
            return true;

            // 7. 데이터베이스 연결 해제
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 댄서리스트를 반환하는 기능
    public List<Dancer> retrieve() {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            Class.forName(driverClassName);

            String sql = "SELECT * FROM tbl_dancer ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // ResultSet : SELECT 의 결과집합 표를 가져옴
            ResultSet rs = pstmt.executeQuery();

            // ResultSet 데이터 가져오기

            List<Dancer> dancerList = new ArrayList<>();
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String crewName = rs.getString("crew_name");
                String danceLevel = rs.getString("dance_level");

                Dancer dancer = new Dancer();
                dancer.setName(name);
                dancer.setCrewName(crewName);
                dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));
                dancerList.add(dancer);
            }
            return dancerList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
