package com.example.demo.sql;

import com.example.demo.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmpDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Collection<Emp> findAll(){
        List<Emp> empList=new ArrayList<>();
        empList=jdbcTemplate.query("Select * from employee", new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp=new Emp();
                emp.setEmpId(resultSet.getInt("id"));
                emp.setEmpName((resultSet.getString("emp_name")));
                emp.setSalary(resultSet.getInt("salary"));
                emp.setDeptId(resultSet.getInt("dept_id"));
                return emp;
            }
        });
        return empList;
        }

   public Collection<Emp> findById(Integer id){
       List<Emp> empList=new ArrayList<>();
       empList=jdbcTemplate.query("Select * from employee where id="+id, new RowMapper<Emp>() {
           @Override
           public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
               Emp emp=new Emp();
               emp.setEmpId(resultSet.getInt("id"));
               emp.setEmpName((resultSet.getString("emp_name")));
               emp.setSalary(resultSet.getInt("salary"));
               emp.setDeptId(resultSet.getInt("dept_id"));
               return emp;
           }
       });
       return empList;
   }

   public Boolean saveEmp(Emp emp){
        String insert="Insert into employee values (?,?,?,?)";
        int result= jdbcTemplate.update(insert, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,emp.getEmpId());
                preparedStatement.setString(2,emp.getEmpName());
                preparedStatement.setInt(3,emp.getSalary());
                preparedStatement.setInt(4,emp.getDeptId());
            }
        });
        if(result>0)
            return true;
        return  false;
   }

   public Boolean addEmpBetter(Emp emp){
        String insert="Insert into employee (emp_name,salary,dept_id) values (:empName,:salary,:deptId)";
        int result= namedParameterJdbcTemplate.update(insert, new BeanPropertySqlParameterSource(emp));
       if(result>0)
            return true;
       return false;
   }


}

