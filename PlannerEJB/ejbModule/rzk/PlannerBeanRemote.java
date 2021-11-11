package rzk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Remote;

import model.Event;
import model.EventType;

@Remote
public interface PlannerBeanRemote {
	boolean createEvent(String description, LocalDateTime fromDate, LocalDateTime toDate, int eventTypeID);

	List<Event> searchEvents(LocalDate date);

	List<EventType> getTypes();

	String login(String email, String password);
}
