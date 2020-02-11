package finale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finale.UtilityJson;
import finale.reguser;
import finale.daolayer;

@WebServlet("/regviewservlet")
public class regviewservlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		try {
			ArrayList<reguser> list = daolayer.getRegAllData();
			
			//System.out.println(list);
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


