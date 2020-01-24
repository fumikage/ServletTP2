

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;

/**
 * Servlet implementation class TP2CoursesServlet
 */
@WebServlet("/courses")
public class TP2CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Course> courses = new ArrayList<>();

    /**
     * Default constructor. 
     */
    public TP2CoursesServlet() {
    	Course c1 = new Course("poulet", 12);
    	Course c2 = new Course("tomate", 6.5);
    	Course c3 = new Course("liqueur d'ananas", 7.60);
    	this.courses.add(c1);
    	this.courses.add(c2);
    	this.courses.add(c3);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<ul>");
    	for(Course c : this.courses) {
			response.getWriter().println("<li>"+c+"</li>");
		}
    	response.getWriter().println("</ul>");
	}
    
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String title = request.getParameter("title");
    	double price = Double.parseDouble(request.getParameter("price"));
    	this.courses.add(new Course(title, price));
    	response.getWriter().println("201 Created - C'est tout bon le frère");
	}
    
    @Override
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String title = request.getParameter("title");
    	int index = -1;
		for(int i = 0; i< this.courses.size(); i++) {
			if(this.courses.get(i).getTitle() == title) {
				index = i;
			}
		}
		if(index != -1) {
			this.courses.remove(index);
			response.getWriter().println("C'est tout bon le frère");
		}
		else {
			response.getWriter().println("C'est vraiment po nice");
		}
	}
}
