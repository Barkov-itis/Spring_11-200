package ru.itis.spring_11200.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.spring_11200.dto.UserForm;
import ru.itis.spring_11200.models.Role;
import ru.itis.spring_11200.models.User;
import ru.itis.spring_11200.repositores.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SmsService smsService;

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .firstName(form.getFirstname())
                .lastName(form.getLastname())
                .phone(form.getPhone())
                .confirmed("CONFIRMED")
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        smsService.sendSms(form.getPhone(), "Вы зарегестрированы!");
    }
}
