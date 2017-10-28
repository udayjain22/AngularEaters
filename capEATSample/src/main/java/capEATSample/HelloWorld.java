package capEATSample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloWorld  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" DO GET in  FC  " + req.getRequestURI());
		//log.trace("full url: " + req.getRequestURI());
		String requestUrl = req.getRequestURI().substring(req.getContextPath().length());
		//log.debug("get request made with url: " + requestUrl);

		// route static content normally
		if (requestUrl.startsWith("/static")) {
			System.out.println("In get method of front controller to direct static page");
			super.doGet(req, resp);
			
		}
	

}
}
