package com.files.Workspace.Repositories;

import com.files.Workspace.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
Optional<User> findByUserEmail(String userEmail);
boolean existByUserEmail(String userEmail);
}
