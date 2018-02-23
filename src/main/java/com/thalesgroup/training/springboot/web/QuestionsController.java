package com.thalesgroup.training.springboot.web;

import com.thalesgroup.training.springboot.bean.Question;
import com.thalesgroup.training.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

  @Autowired
  private QuestionService qs;

  @RequestMapping(method = RequestMethod.GET)
  public Question[] questions() {
    return qs.getAll();
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public Question question(@PathVariable("id") int id) {
    return qs.findById(id);
  }
}

