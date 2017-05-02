package ua.com.garage.dao;

import ua.com.garage.model.Employee;

import java.util.List;

/**
 * Created by Raketa on 24.12.2016.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    //98.
    Employee findByName(String name);

    // 51. добавим меотд который будет удалять
    void remove(Employee employee);
}
