package studentwebjdbcpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletedata
 */
@WebServlet("/deletedata")
public class deletedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
int i;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 int id=Integer.parseInt(request.getParameter("uid"));
		 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AKASH","Akash4020");
			String qry="delete from student001 where Id=?";
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setInt(1, id);
			 i=ps.executeUpdate();
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i>0) {
			out.print("data deleted ");
		}
		else 
		{
		out.print("error");
		}
	}

}
