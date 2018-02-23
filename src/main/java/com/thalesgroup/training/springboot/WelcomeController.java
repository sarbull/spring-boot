package com.thalesgroup.training.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

  @RequestMapping(method = RequestMethod.GET)
  public String welcome() {
    return "Welcome";
  }
}

