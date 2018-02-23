package com.thalesgroup.training.springboot.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.thalesgroup.training.springboot.bean.Question;

@Repository("map")
public class QuestionDAO implements DAO<Question> {

  private static Map<Integer, Question> map = new HashMap<>();
  private static int sequence;

  @Override
  public void create(Question t) {
    t.setId(sequence++);
    map.put(t.getId(), t);
  }

  @Override
  public void update(Question t) {
    map.put(t.getId(), t);
  }

  @Override
  public void delete(Integer id) {
    map.remove(get(id));
  }

  @Override
  public Question get(Integer id) {
    return map.get(id);
  }

  @Override
  public Question[] getAll() {
    return map.values().toArray(new Question[map.size()]);
  }

}
