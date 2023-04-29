package com.menumaster.springbootlibrary.repositories;

import com.menumaster.springbootlibrary.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
