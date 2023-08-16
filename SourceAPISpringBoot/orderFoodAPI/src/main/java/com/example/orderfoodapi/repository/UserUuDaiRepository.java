package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.UserUudai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUuDaiRepository extends JpaRepository<UserUudai,Integer> {
    UserUudai findUserUudaiById(int id);
}
