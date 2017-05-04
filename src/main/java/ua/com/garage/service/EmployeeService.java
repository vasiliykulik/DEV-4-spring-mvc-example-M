package ua.com.garage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.garage.dao.EmployeeDao;
import ua.com.garage.model.Employee;

import java.util.List;

/**
 * Created by Vasiliy Kylik on 04.05.2017.
 */

public class EmployeeService {

  public EmployeeDao employeeDao;

  @Transactional
  public List<Employee> getEmployees(){
    return employeeDao.findAll();
  }


  public void setEmployeeDao(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }
}
