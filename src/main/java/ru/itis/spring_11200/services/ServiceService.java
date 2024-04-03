package ru.itis.spring_11200.services;

import ru.itis.spring_11200.dto.ServiceDto;
import ru.itis.spring_11200.dto.ServiceForm;

import java.util.List;

public interface ServiceService {

    ServiceDto addService(ServiceForm serviceForm);
    List<ServiceDto> getAllServices();
    List<ServiceDto> serch(Integer page, Integer size, String query, String sortParametr, String direction);
}
