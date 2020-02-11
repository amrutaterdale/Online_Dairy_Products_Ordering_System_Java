package finale;

import java.io.IOException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatequantityservlet")
public class updatequantityservlet extends HttpServlet {
	
	public static final long serialVersionUID=1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String requestdata=request.getReader().readLine();
		
product p = (product) UtilityJson.getObjectFromJSON(requestdata, product.class);
		

		Map<String, String> map = daolayer.updatequantity(p);

		String responseData = (String) UtilityJson.getJSONFromObject(map);
		
		response.getWriter().write(responseData);
		
		response.flushBuffer();

		
	}

}
