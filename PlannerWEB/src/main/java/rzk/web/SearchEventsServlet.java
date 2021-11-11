package rzk.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import rzk.PlannerBeanRemote;

@WebServlet("/SearchEventsServlet")
public class SearchEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchEventsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlannerBeanRemote plannerBean = (PlannerBeanRemote) request.getSession().getAttribute("plannerBean");
		String date = request.getParameter("date");
		LocalDate d = LocalDate.parse(date);
		List<Event> events = plannerBean.searchEvents(d);
		request.setAttribute("events", events);
		request.getRequestDispatcher("searchEvents.jsp").forward(request, response);
	}

}
