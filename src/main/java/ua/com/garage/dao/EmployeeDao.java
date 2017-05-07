package ua.com.garage.dao;


import ua.com.garage.model.Employee;

import java.util.List;

/**
 * Created by Raketa on 24.12.2016.
 */
public interface EmployeeDao {
  // 24. как и с Jdbc  - хорошим тоном будет выделение объектов работающих с БД
//  или с Hibernate в отдельные объекты DataAccessObjects
  void save(Employee employee);

  Employee load(Long id);

  List<Employee> findAll();

  Employee findByName(String name);

  void remove(Employee employee);

  void removeAll();
}
