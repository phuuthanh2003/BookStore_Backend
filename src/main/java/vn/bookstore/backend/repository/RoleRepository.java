package vn.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bookstore.backend.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
