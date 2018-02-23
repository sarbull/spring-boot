package com.thalesgroup.training.springboot.config;

import com.thalesgroup.training.springboot.service.QuestionService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionInitializer implements InitializingBean {

  @Autowired
  private QuestionService qs;

  @Override
  public void afterPropertiesSet() throws Exception {
    this.qs.createQuestions(10);
  }
}
