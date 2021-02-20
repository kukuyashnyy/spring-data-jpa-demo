package org.itstep.repository;

import org.itstep.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
//    @Query(value = "SELECT * from Car where color=?0", nativeQuery = true)
    @Query("from Car c where c.color like :color")
    Car carByColor(@Param("color") String color);

    Car findCarByColorContains(String color);

    @Query("select c from Car c where c.price >=:minPrice and c.price <= :maxPrice")
    List<Car> carsByPrice(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);

    List<Car> findCarsByPriceBetween(int minPrice, int maxPrice);
}
