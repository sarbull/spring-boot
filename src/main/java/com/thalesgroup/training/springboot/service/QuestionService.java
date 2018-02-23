package com.thalesgroup.training.springboot.service;

import java.io.PrintStream;
import java.util.Arrays;
import com.thalesgroup.training.springboot.bean.Question;
import com.thalesgroup.training.springboot.dao.DAO;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
  private DAO<Question> dao;
  private PrintStream ps = System.out;

  public QuestionService(DAO<Question> dao, PrintStream ps) {
    super();

    this.dao = dao;
    this.ps = ps;

    this.createQuestions(10);
  }

  public void createQuestions(int size) {
    for(int i = 0; i <= size; i++) {
      this.dao.create(new Question("Question " + i, true));
    }
  }

  public Question[] getQuestions() {
    return this.dao.getAll();
  }

  public void printAll() {

    ps.println(Arrays.asList(dao.getAll()));
  }
}
