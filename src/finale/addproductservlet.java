package finale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addproductservlet")
public class addproductservlet extends HttpServlet {

	public static final long serialVersionUID=1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String requestdata=request.getReader().readLine();
		System.out.println(requestdata);
		
		product p=(product) UtilityJson.getObjectFromJSON(requestdata, product.class);
		
		Map<String, String> map = null;
		try
		{
			map = daolayer.addproduct(p);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		String responsedata = (String) UtilityJson.getJSONFromObject(map);
		
		response.getWriter().write(responsedata);
		
		response.flushBuffer();
	}
		
	}

