package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UserReponsitory extends JpaRepository<User,Integer> {
    User findUserById(int id);
    User findByTaiKhoan(String tk);

    Optional<User> findByTaiKhoanAndMatKhau(String tk, String mk);
}
