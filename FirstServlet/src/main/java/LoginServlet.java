import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		description = "LoginServlet",
		urlPatterns = {"/Login"},
		initParams = {
				@WebInitParam(name= "User",value = "Mohan"),
				@WebInitParam(name = "Pass",value = "Mohan@1324")
		}
	)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //get request parameters for username and password
		String username = request.getParameter("User");
		String pass = request.getParameter("Password");
		//get servlet config init params
		String userID = getServletConfig().getInitParameter("User");
		String password = getServletConfig().getInitParameter("Pass");
		//Username Regex Patter
		String nameRegex = "^[A-Z]{1}.{2,}$";

		//Username Regex
		if (!username.matches(nameRegex)) {
			RequestDispatcher req = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Kindly Enter Correct USERNAME</font>");
			req.include(request, response);
		}
		else {
			RequestDispatcher reqD = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Incorrect Credentials</font>");
			reqD.include(request, response);
		}
	}
}