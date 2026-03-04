package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    User findByEmail(String email);
    java.util.List<User> findByRole(String role);
}
