package com.example.demo.controller;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class EmpJdbcController {
    @Autowired
    EmpService empService;

    @GetMapping("/find")
    public Collection<Emp> findAllEmp(){
        return empService.findAll();
    }

    @GetMapping("/findbyid")
    public Collection<Emp> findById(@RequestParam Integer id){
        return empService.findById(id);
    }

    @PostMapping("/addEmp")
    public Boolean saveEmp(@RequestBody Emp emp){
        return empService.addEmp(emp);
    }

    @PostMapping("/addEmpBetter")
    public Boolean saveEmpBetter(@RequestBody Emp emp){
        return empService.addEmpBetter(emp);
    }
}
