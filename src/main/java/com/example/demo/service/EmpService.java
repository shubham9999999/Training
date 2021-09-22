package com.example.demo.service;

import com.example.demo.model.Emp;
import com.example.demo.sql.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmpService {
    @Autowired
    EmpDao empDao;
    public Collection<Emp> findAll(){
        return empDao.findAll();
    }
    public Collection<Emp> findById(Integer id){
        return empDao.findById(id);
    }
    public boolean addEmp(Emp emp){
        return empDao.saveEmp(emp);
    }
    public Boolean addEmpBetter(Emp emp){
        return empDao.addEmpBetter(emp);
    }
}
