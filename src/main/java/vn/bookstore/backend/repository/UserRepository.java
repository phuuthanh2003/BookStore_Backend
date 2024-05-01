package vn.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bookstore.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}