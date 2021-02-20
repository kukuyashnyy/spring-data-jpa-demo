package org.itstep.controller;

import org.hibernate.Hibernate;
import org.itstep.domain.entity.Car;
import org.itstep.domain.entity.Category;
import org.itstep.repository.CarRepository;
import org.itstep.repository.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final CarRepository carRepository;
    private final CarService carService;

    @Autowired
    public HomeController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("car", new Car());
//        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute Car car, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "index";
        }
        carService.addCar(car);
//        car = carRepository.save(car);
        System.out.println("car = " + car);
        System.out.println("State: " + Hibernate.isInitialized(car));
        return "redirect:/";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "all";
    }

    @GetMapping("/color")
    public String findByColor(@RequestParam(required = false) String color, Model model) {
        System.out.println("color = " + color);
        if(color != null) {
//            Car car = null; //carRepository.carByColor(color);
//            Car probe = new Car();
//            probe.setColor(color);
//            ExampleMatcher colorMatcher = matching().withMatcher("color", contains());
//            car = carRepository.findOne(Example.of(probe, colorMatcher)).orElse(null);
            model.addAttribute("car", carRepository.findCarByColorContains(color));
        }
        return "one";
    }

    @GetMapping("/price")
    public String findByPrice(@RequestParam(required = false) int minPrice, int maxPrice, Model model) {
        model.addAttribute("cars", carRepository.carsByPrice(minPrice, maxPrice));
//        model.addAttribute("cars", carRepository.findCarsByPriceBetween(minPrice, maxPrice));
        return "all";
    }
}
