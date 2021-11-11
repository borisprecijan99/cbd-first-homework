package rzk;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

@Stateless
public class AccountBean implements AccountBeanRemote {

	@PersistenceContext
	private EntityManager em;

	public AccountBean() {

	}

	@Override
	public boolean createAccount(String email, String password, String firstName, String lastName) {
		boolean ok = firstName != null && lastName != null && email != null && password != null
				&& !firstName.trim().isEmpty() && !lastName.trim().isEmpty() && !email.trim().isEmpty()
				&& !password.trim().isEmpty();
		if (ok) {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			em.persist(user);
			return true;
		}
		return false;
	}

	@PostConstruct
	private void create() {
		System.out.println(this.getClass().getSimpleName() + ": created");
	}

	@PreDestroy
	private void destroy() {
		System.out.println(this.getClass().getSimpleName() + ": destroyed");
	}

}
