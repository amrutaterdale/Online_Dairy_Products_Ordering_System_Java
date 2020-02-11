package finale;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/useractivitydeleteservlet")
public class useractivitydeleteservlet extends HttpServlet {
	
	public static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		
		try {
			Map<String,String>list=daolayer.deleteactivity();
			
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
	


