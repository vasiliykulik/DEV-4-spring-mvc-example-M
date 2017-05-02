package ua.com.garage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vasiliy Kylik on 03.05.2017.
 */
@Controller
        /*(value="main/")*/
public class MainController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "index";
  }
}
