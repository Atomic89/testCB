package servletmap;

import support.ConnectionToDB;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 * Добавление новой записи
 * @author NikolaevSA
 */
@WebServlet("/add")
public class AddInfoInsurOrg extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addInfoPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String inn = request.getParameter("inn");
        String ogrn = request.getParameter("ogrn");
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        String query = "insert into orginfo(inn, ogrn, name, address) values(?, ?, ?, ?)";
        try {
           Connection connection = ConnectionToDB.getConnection();
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, inn);
            preparedStmt.setString(2, ogrn);
            preparedStmt.setString(3, name);
            preparedStmt.setString(4, address);

            preparedStmt.execute();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("success", "Данные отправлены");
        request.getRequestDispatcher("addInfoPage.jsp").forward(request, response);
    }
}
