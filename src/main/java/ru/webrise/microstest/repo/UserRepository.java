package ru.webrise.microstest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webrise.microstest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
