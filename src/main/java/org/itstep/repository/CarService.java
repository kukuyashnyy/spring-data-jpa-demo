package org.itstep.repository;

import org.itstep.domain.entity.Car;
import org.itstep.domain.entity.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;

    public CarService(CarRepository carRepository,
                      CategoryRepository categoryRepository) {
        this.carRepository = carRepository;
        this.categoryRepository = categoryRepository;

    }

    @Transactional
    public void addCar(Car car) {
        Category category = categoryRepository.findByName(car.getCategory().getName());
        if (category == null) {
            categoryRepository.save(car.getCategory());
        } else {
            car.setCategory(category);
        }
        carRepository.save(car);
    }
}
