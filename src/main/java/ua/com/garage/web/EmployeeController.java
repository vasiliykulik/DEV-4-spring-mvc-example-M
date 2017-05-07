package ua.com.garage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
/*Если имя совпадает можно не уточнять @RequestParam("employeeName")*/
/*  @RequestMapping(value = "/employee", method = RequestMethod.GET)
  public ModelAndView employees(@RequestParam("employeeName") String employeeName) {
    ModelAndView modelAndView= new ModelAndView();
    modelAndView.addObject("employee", employeeService.getEmployeeByName(employeeName));
    modelAndView.setViewName("employee");// даем логическое имя вашей модельке
    return modelAndView;
  }*/

  /*Более REST-товый подход, вы не передаете параметр, вы делаете другой URL */
  @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
  public ModelAndView employees(@PathVariable String employeeName) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("employee", employeeService.getEmployeeByName(employeeName));
    modelAndView.setViewName("employee");// даем логическое имя вашей модельке
    return modelAndView;
  }

  @Autowired
  public void setEmployeeService(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
}
