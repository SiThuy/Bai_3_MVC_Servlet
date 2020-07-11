package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublisherRepository;

@WebServlet("/admin/publisher.html")
public class PublisherController extends HttpServlet {
	private PublisherRepository repository = new PublisherRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 	throws ServletException, IOException {
		try {
			request.setAttribute("list", repository.getPublishers());
			request.getRequestDispatcher("/views/publisher/index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
