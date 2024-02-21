package ru.itis.spring_11200.services;

import ru.itis.spring_11200.dto.UserDto;

import java.util.List;

public interface UsersService {

    List<UserDto> getAllUsers();
}
