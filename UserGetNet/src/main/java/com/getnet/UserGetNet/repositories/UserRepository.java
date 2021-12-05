package com.getnet.UserGetNet.repositories;

import com.getnet.UserGetNet.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "select u from Users u where u.name like %?1%")
    List<Users> findUserByName(String name);

}
