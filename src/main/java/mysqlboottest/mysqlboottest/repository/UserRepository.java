package mysqlboottest.mysqlboottest.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mysqlboottest.mysqlboottest.model.UserBean;


@Repository
public interface UserRepository extends CrudRepository<UserBean, Long> {

}
