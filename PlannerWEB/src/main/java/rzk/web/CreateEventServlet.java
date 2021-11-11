package rzk.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rzk.PlannerBeanRemote;

@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateEventServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlannerBeanRemote plannerBean = (PlannerBeanRemote) request.getSession().getAttribute("plannerBean");
		String description = request.getParameter("description");
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime fromDate = LocalDateTime.parse(request.getParameter("fromDateTime"), dtf);
		LocalDateTime toDate = LocalDateTime.parse(request.getParameter("toDateTime"), dtf);
		int eventType = Integer.parseInt(request.getParameter("eventTypeId"));
		boolean ok = plannerBean.createEvent(description, fromDate, toDate, eventType);
		if (ok) {
			request.getRequestDispatcher("createEvent.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
