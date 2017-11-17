package com.springboot.demo.repository;

import com.springboot.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository class
 *
 * @author niezi
 * @date 17/11/2017
 */
@Repository
public interface UserRepository extends  CrudRepository<User,String> {

}
