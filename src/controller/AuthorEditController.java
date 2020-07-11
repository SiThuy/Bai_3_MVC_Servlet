package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorRepository;
import domain.Author;

@WebServlet("/admin/author/edit.html")
public class AuthorEditController extends HttpServlet {
	AuthorRepository repository = new AuthorRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("o", repository.getAuthor(id));
		request.getRequestDispatcher("/views/author/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Author obj = new Author(id, request.getParameter("name"));
		repository.edit(obj);
		response.sendRedirect(request.getContextPath() + "/admin/author.html");
	}

}
