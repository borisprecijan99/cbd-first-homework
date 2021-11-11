package rzk;

import java.util.List;

import javax.ejb.Local;

import model.EventType;

@Local
public interface EventTypeBeanLocal {
	List<EventType> getTypes();
}
