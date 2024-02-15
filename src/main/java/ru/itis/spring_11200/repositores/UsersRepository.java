package ru.itis.spring_11200.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_11200.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
