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
 * Servlet implementation class InsertDataDb
 */
@WebServlet("/InsertDataDb")
public class InsertDataDb extends HttpServlet {
	
	 int i;
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 int id=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		 //int mark= Integer.parseInt(request.getParameter("mark"));
		String mark=request.getParameter("mark");
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AKASH","Akash4020");
			String sql="insert into student001 values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, sname);
			ps.setString(3, mark);
		    i = ps.executeUpdate();
			 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 if(i>0)
		 {
			 out.print("data Inserted ");
		 }
		 else
		 {
			 out.print(" Error");
		 }
	 
		
		
	}
     
		
	}


