package org.itstep.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @NotEmpty
    @Length(max = 50)
    private String model;
    @NonNull
    private String color;
    @NonNull
    @Min(value = 0)
    private BigDecimal price;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
}
