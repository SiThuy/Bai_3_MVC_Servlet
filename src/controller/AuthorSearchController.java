package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorRepository;
import domain.Author;

@WebServlet("/admin/author/search.html")
public class AuthorSearchController extends HttpServlet {
	AuthorRepository repository = new AuthorRepository();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		 request.setAttribute("o", repository.search(q));
		
		request.getRequestDispatcher("/views/author/search.jsp").forward(request, response);
	}
	
	
}
