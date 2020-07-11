package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorRepository;

@WebServlet("/admin/author.html")
public class AuthorController extends HttpServlet{
	AuthorRepository repository = new AuthorRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", repository.getAuthors());
		request.getRequestDispatcher("/views/author/index.jsp").forward(request, response);
	}

}
