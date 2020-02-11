package finale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewpurchaseservlet")
public class viewpurchaseservlet extends HttpServlet {
	
	public static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try {
			ArrayList<purchase>list=daolayer.getpurchaseList();
			
			String responseData = (String) UtilityJson.getJSONFromObject(list);

			response.getWriter().write(responseData);

			response.flushBuffer();
			

		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}

}
