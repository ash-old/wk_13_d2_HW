package com.codeclan.example.OneToManyHW.repositories;

import com.codeclan.example.OneToManyHW.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
