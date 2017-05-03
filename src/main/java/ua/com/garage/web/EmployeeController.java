package ua.com.garage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.garage.service.EmployeeService;

import java.util.Map;

/**
 * Created by Vasiliy Kylik on 04.05.2017.
 */
@Controller
public class EmployeeController {

  private EmployeeService employeeService;

  @RequestMapping(value = "/employees", method = RequestMethod.GET)
  public String employees(Map<String, Object> model) {
    model.put("employees", employeeService.getEmployees());
    return "employees";
  }

  @Autowired
  public void setEmployeeService(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
}
