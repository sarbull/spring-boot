package com.thalesgroup.training.springboot.service;

import java.io.PrintStream;
import java.util.Arrays;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.thalesgroup.training.springboot.bean.Question;
import com.thalesgroup.training.springboot.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  @Autowired
  private QuestionDAO dao;

  public QuestionService() {}

  public Question[] getAll() {
    return this.dao.getAll();
  }

  public Question findById(int id) {
    return dao.get(id);
  }

  public void deleteWithId(int id) {
    dao.delete(id);
  }

  public void createQuestions(int size) {
    for(int i = 1; i <= size; i++) {
      this.dao.create(new Question("Question " + i, true));
    }
  }

  public Question[] getQuestions() {
    return this.dao.getAll();
  }
}
