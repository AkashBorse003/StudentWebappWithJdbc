package studentwebjdbcpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class readdata
 */
@WebServlet("/readdata")
public class readdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AKASH","Akash4020");
			String qry="select * from student001";
			PreparedStatement ps=con.prepareStatement(qry);
					ResultSet rs=ps.executeQuery();
			out.print("<table>");
			out.print("<tr>");
			while(rs.next())
			{
				out.print(rs.getInt(1)+"     ");
				out.print(rs.getString(2)+"     ");
				out.print(rs.getInt(3)+"     ");
			}
			out.print("</table>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
