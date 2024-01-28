package com.example.demo.repository;

import com.example.demo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<Users , String > {

}
