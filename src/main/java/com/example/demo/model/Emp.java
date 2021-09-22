package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Emp {
    int empId;
    String empName;
    int salary;
    int deptId;
}
