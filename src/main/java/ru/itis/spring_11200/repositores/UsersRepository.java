package ru.itis.spring_11200.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_11200.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmCode(String confirmCode);
}
