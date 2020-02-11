package finale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

@WebServlet("/orderedproductservlet")
public class orderedproductservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestdata = request.getReader().readLine();
		System.out.println(requestdata);

		purchase p = (purchase) UtilityJson.getObjectFromJSON(requestdata, purchase.class);

		Map<String, String> map = null;
		try
		{
			System.out.println("hi");
			map = daolayer.saveorderedproduct(p);
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
