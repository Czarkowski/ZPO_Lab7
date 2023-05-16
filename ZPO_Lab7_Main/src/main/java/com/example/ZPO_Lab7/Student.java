package com.example.ZPO_Lab7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private int age;

}
