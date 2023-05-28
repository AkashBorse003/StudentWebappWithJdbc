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
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  int id=Integer.parseInt(request.getParameter("uid"));
	 String name=request.getParameter("uname");
	 //int mark=Integer.parseInt(request.getParameter("umark"));
	 String mark=request.getParameter("umark");
	  try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AKASH","Akash4020");
		String qry="update student001 set name=?,marks=? where id=?";
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setString(1, name);
		ps.setString(2, mark);
		ps.setInt(3, id);
		int i=ps.executeUpdate();
		if(i>0)
		{
			out.print("data updated Sucessfully");
		}
		else
		{
			out.print("error");
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

}
