package ru.itis.spring_11200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.spring_11200.dto.ServiceDto;
import ru.itis.spring_11200.dto.ServiceForm;
import ru.itis.spring_11200.services.ServiceService;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/services")
    @ResponseBody
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceForm serviceForm) {
        return ResponseEntity.ok(serviceService.addService(serviceForm));
    }

    @GetMapping("/service")
    public String getAllServices(Model model) {
        model.addAttribute("servicesList", serviceService.getAllServices());
        return "service";
    }

    @GetMapping("/allservices")
    @ResponseBody
    public  ResponseEntity<List<ServiceDto>> addService(){
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    // номер страницы: 2 - href
    // href: localhost:8080/paper/service/search?page=0&size=3&q=имя
    @GetMapping("/paper/service/search")
    @ResponseBody
    public ResponseEntity<List<ServiceDto>> serch(@RequestParam("size") Integer size,
                                                  @RequestParam("page") Integer page,
                                                  @RequestParam(value = "q", required = false) String query,
                                                  @RequestParam(value = "sort", required = false) String sort,
                                                  @RequestParam(value = "direction", required = false) String direction){
        return ResponseEntity.ok(serviceService.serch(page, size, query, sort, direction));
    }
}
