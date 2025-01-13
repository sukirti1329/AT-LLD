package com.airtribe.library.management.repository;

import com.airtribe.library.management.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
