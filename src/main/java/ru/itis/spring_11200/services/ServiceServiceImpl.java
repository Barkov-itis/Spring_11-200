package ru.itis.spring_11200.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.itis.spring_11200.dto.ServiceDto;
import ru.itis.spring_11200.dto.ServiceForm;
import ru.itis.spring_11200.models.Service;
import ru.itis.spring_11200.repositores.ServiceRepository;

import java.util.List;

import static ru.itis.spring_11200.dto.ServiceDto.from;

@Component
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceDto addService(ServiceForm serviceForm) {
        Service service = Service.builder()
                .name(serviceForm.getName())
                .cost(serviceForm.getCost())
                .date(serviceForm.getDate())
                .build();
        serviceRepository.save(service);
        return ServiceDto.of(service);
    }

    @Override
    public List<ServiceDto> getAllServices() {
        return from(serviceRepository.findAll());
    }

    @Override
    public List<ServiceDto> serch(Integer page, Integer size, String query, String sortParameter, String directionParametr) {
        Sort.Direction direction = Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if(directionParametr != null) {
            direction = Sort.Direction.fromString(directionParametr);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }

        if(size == null) {
            size = 3;
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Service> papersPage = serviceRepository.search(query, pageRequest);
        return from(papersPage.getContent());
    }
}
