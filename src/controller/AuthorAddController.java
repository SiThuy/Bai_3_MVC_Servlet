package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorRepository;
import domain.Author;

@WebServlet("/author/add.html")
public class AuthorAddController extends HttpServlet{
	AuthorRepository repository = new AuthorRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/author/add.jsp").forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Author obj = new Author(null, request.getParameter("name"));
		repository.add(obj);
		response.sendRedirect(request.getContextPath() + "/admin/author.html");
	}

}
