package mysqlboottest.mysqlboottest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import mysqlboottest.mysqlboottest.model.UserBean;
import mysqlboottest.mysqlboottest.service.UserService;



/**
 * @author NikolayNikolaev
 * 
 * this is the RestController containing the Rest endpoints for user operations
 * at the moment those are:
 * 1.create user
 * 2.delete user
 * 3.get list of all current users
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * this method simply returns the list of all current users, no input required
	 * @return list of all current users
	 */
	@RequestMapping(value = "/all")
	public List<UserBean> getAllUser() {
		List<UserBean> list = new ArrayList<>();
		// Add each element of iterator to the List
		userService.getAllUsers().forEach(list::add);
		return list;
	}
    
	/**
	 * creates a user through POSt call,example usage in POSTMan
	 * 
	 * in the body part put:
	 * to create user John with id 1
	 * 
	 * {
		"userName": "John",
		"userId": 1
	   }
	   
	   keep in mind that id's should be unique, so if the id already exists it will 
	   throw an error
	 * @param user
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createUser(@RequestBody UserBean user) {
		userService.createUser(user);
	}

	/**
	 * same input as the method above, but this time it will remove the existing user
	 * by the given name and id
	 * @param user
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteteUser(@RequestBody UserBean user) {
		userService.deleteUser(user);
	}
}
