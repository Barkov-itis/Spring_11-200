package ru.itis.spring_11200.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_11200.dto.UserDto;
import ru.itis.spring_11200.repositores.UsersRepository;

import java.util.List;

import static ru.itis.spring_11200.dto.UserDto.userList;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return userList(usersRepository.findAll());
    }
}
