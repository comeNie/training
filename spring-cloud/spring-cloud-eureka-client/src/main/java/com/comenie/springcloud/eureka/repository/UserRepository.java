package com.comenie.springcloud.eureka.repository;


import com.comenie.springcloud.eureka.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
