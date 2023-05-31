package com.example.ZPO_Lab7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String lastName;

    @Column(name = "age")
    @Max(99)
    @Min(10)
    private int age;
}
