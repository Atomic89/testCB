package servletmap;
import igm.*;
import support.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;


@WebServlet("/search")
public class SearchInfoInsurOrg extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrgInsurInfo> values = new ArrayList<>();
        request.setAttribute("records", values);
        request.getRequestDispatcher("searchInfoPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    /**
     * Обработка запроса
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String inn = request.getParameter("inn");
        String ogrn = request.getParameter("ogrn");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String type = request.getParameter("all");
        String query ;
        PreparedStatement stmt;
            List<OrgInsurInfo> values = new ArrayList<>();

            try (Connection con = ConnectionToDB.getConnection()) {
                if(type == null) {
                    query = "SELECT * FROM orginfo where (? like '' or inn = ?) and (? like '' or ogrn = ?) and (? like '' or name = ?) and (? like '' or address = ?)";
                } else {
                    query = "SELECT * FROM orginfo";
                }
                stmt = con.prepareStatement(query);
                if(type == null) {
                    stmt.setString(1, inn);
                    stmt.setString(2, inn);
                    stmt.setString(3, ogrn);
                    stmt.setString(4, ogrn);
                    stmt.setString(5, name);
                    stmt.setString(6, name);
                    stmt.setString(7, address);
                    stmt.setString(8, address);
                }
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    OrgInsurInfo orgInsurInfo = new OrgInsurInfo();
                    orgInsurInfo.setInn(rs.getString("inn"));
                    orgInsurInfo.setOgrn(rs.getString("ogrn"));
                    orgInsurInfo.setName(rs.getString("name"));
                    orgInsurInfo.setAddress(rs.getString("address"));
                    values.add(orgInsurInfo);
                }
                rs.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("records", values);
            request.getRequestDispatcher("searchInfoPage.jsp").forward(request, response);

    }
}
