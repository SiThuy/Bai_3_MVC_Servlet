package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorRepository;

@WebServlet("/admin/author/del.html")
public class AuthorDeleteController extends HttpServlet {
	AuthorRepository repository = new AuthorRepository();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		repository.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/author.html");

	}

}
