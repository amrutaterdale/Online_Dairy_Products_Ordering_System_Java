package finale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finale.UtilityJson;
import finale.product;
import finale.daolayer;

@WebServlet("/viewproductservlet")
public class viewproductservlet extends HttpServlet {
	
	public static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		try {
			ArrayList<product>list=daolayer.getAllProduct();
			
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


