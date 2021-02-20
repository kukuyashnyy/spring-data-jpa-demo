package org.itstep.repository;

import org.itstep.domain.entity.Car;
import org.itstep.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
