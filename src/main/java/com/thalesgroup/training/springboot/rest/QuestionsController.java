package com.thalesgroup.training.springboot.rest;

import com.thalesgroup.training.springboot.bean.Question;
import com.thalesgroup.training.springboot.repository.QuestionRepository;
import com.thalesgroup.training.springboot.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

  Logger logger = Logger.getLogger(QuestionsController.class);

  @Autowired
  private QuestionService qs;

  @Autowired
  private QuestionRepository qr;

  @RequestMapping(method = RequestMethod.GET)
  public Question[] questions() {
    // return qs.getAll();

    return qr.getAll();
  }


  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity createQuestion(@RequestBody Question q) {
    // return qs.getAll();
    qr.create(q);

    return new ResponseEntity(HttpStatus.CREATED);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public Question question(@PathVariable("id") int id) {
    // return qs.findById(id);

    return qr.get(id);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
  public ResponseEntity deleteQuestion(@PathVariable("id") int id) {
    // TODO: treat scenario for multiple deletion
    // qs.deleteWithId(id);

    qr.delete(id);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}

