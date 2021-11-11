package rzk;

import javax.ejb.Remote;

@Remote
public interface AccountBeanRemote {
	boolean createAccount(String email, String password, String firstName, String lastName);
}
