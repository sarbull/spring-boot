package com.thalesgroup.training.springboot.bean;

import javax.persistence.Entity;

@Entity
public class Question extends BaseEntity {

  private String question;
  private boolean correctAnswer;

  @Override
  public String toString() {
    return "Question{" +
        "question='" + question + '\'' +
        ", correctAnswer=" + correctAnswer +
        '}';
  }

  public Question() {}

  public Question(String question, boolean correctAnswer) {
    super();

    this.question = question;
    this.correctAnswer = correctAnswer;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public boolean getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(boolean correctAnswer) {
    this.correctAnswer = correctAnswer;
  }
}
