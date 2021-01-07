package mysqlboottest.mysqlboottest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mysqlboottest.mysqlboottest.model.UserBean;
import mysqlboottest.mysqlboottest.repository.UserRepository;

/**
 * @author Nikolay
 * 
 *         the standart Service class for controller, for more information on
 *         the individual methods check the UserController class
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Iterable<UserBean> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<UserBean> getTransaction(Long id) {
		return userRepository.findById(id);
	}

	public void deleteUser(UserBean user) {
		userRepository.delete(user);
	}

	public void createUser(UserBean user) {
		userRepository.save(user);
	}

}
