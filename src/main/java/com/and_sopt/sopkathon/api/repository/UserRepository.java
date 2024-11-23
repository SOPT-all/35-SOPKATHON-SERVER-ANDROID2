package com.and_sopt.sopkathon.api.repository;

import com.and_sopt.sopkathon.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
