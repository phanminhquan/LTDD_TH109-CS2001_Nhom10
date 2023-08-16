package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.Loaifood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiFoodRepository extends JpaRepository<Loaifood,Integer> {
    Loaifood findLoaifoodById (int id);
}
