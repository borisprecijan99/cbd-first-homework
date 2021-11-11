package rzk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Event;
import model.EventType;
import model.User;

@Stateful
public class PlannerBean implements PlannerBeanRemote {

	private int userId;
	private User user;

	@PersistenceContext
	private EntityManager em;

	@EJB
	private EventTypeBeanLocal eventTypeBean;

	public PlannerBean() {

	}

	@Override
	public String login(String email, String password) {
		TypedQuery<User> q = em.createQuery(
				"SELECT u FROM User u WHERE u.email LIKE :email AND u.password LIKE :password", User.class);
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<User> users = q.getResultList();
		try {
			user = users.get(0);
			userId = user.getId();
			System.out.println(this.getClass().getSimpleName() + ": Logged in user with id=" + userId);
			return user.getEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@PostConstruct
	private void create() {
		System.out.println(this.getClass().getSimpleName() + ": created");
	}

	@PreDestroy
	private void destroy() {
		System.out.println(this.getClass().getSimpleName() + ": destroyed");
	}

	@Override
	public boolean createEvent(String description, LocalDateTime fromDate, LocalDateTime toDate, int eventTypeID) {
		boolean ok = description != null && fromDate != null && toDate != null;
		if (ok) {
			Event event = new Event();
			event.setUser(user);
			event.setDescription(description);
			event.setFromDate(fromDate);
			event.setToDate(toDate);
			EventType eventType = em.find(EventType.class, eventTypeID);
			event.setEventType(eventType);
			em.persist(event);
			return true;
		}
		return false;
	}

	@Override
	public List<Event> searchEvents(LocalDate date) {
		TypedQuery<Event> query = em
				.createQuery("SELECT e FROM Event e WHERE e.user=:user AND DATE(e.fromDate)=DATE(:date)", Event.class);
		query.setParameter("date", date);
		query.setParameter("user", user);
		List<Event> events = query.getResultList();
		return events;
	}

	@Override
	public List<EventType> getTypes() {
		return eventTypeBean.getTypes();
	}

}
