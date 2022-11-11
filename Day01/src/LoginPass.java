

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPass
 */
@WebServlet("/LoginPass")
public class LoginPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] coffe  = request.getParameterValues("coffe");
		String[] hobby = request.getParameterValues("hobby");
		String url = "TestloginView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("id", id); //컨트롤러에서 view에게 데이터를 전송
		request.setAttribute("pass", pass); //컨트롤러에서 view에게 데이터를 전송
		request.setAttribute("gender", gender); //컨트롤러에서 view에게 데이터를 전송
		request.setAttribute("job", job); //컨트롤러에서 view에게 데이터를 전송
		request.setAttribute("coffe", coffe); //컨트롤러에서 view에게 데이터를 전송
		request.setAttribute("hobby", hobby); //컨트롤러에서 view에게 데이터를 전송
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
