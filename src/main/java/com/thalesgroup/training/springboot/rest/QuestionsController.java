package com.thalesgroup.training.springboot.rest;

import com.thalesgroup.training.springboot.bean.Question;
import com.thalesgroup.training.springboot.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

  Logger logger = Logger.getLogger(QuestionsController.class);

  @Autowired
  private QuestionService qs;

  @RequestMapping(method = RequestMethod.GET)
  public Question[] questions() {
    logger.info("questions() has been called!");

    return qs.getAll();
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public Question question(@PathVariable("id") int id) {
    return qs.findById(id);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
  public ResponseEntity deleteQuestion(@PathVariable("id") int id) {
    // TODO: treat scenario for multiple deletion
    qs.deleteWithId(id);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
