package com.thalesgroup.training.springboot.repository;

import com.thalesgroup.training.springboot.bean.Question;
import com.thalesgroup.training.springboot.dao.DAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuestionRepository implements DAO<Question> {

  @PersistenceContext
  public EntityManager em;

  public void create(Question q) {
    em.persist(q);
  }

  public void update(Question q) {
    em.merge(q);
  }

  public void delete(Integer id) {
    em.remove(get(id));
  }

  public Question get(Integer id) {
    return em.find(Question.class, id);
  }

  public Question[] getAll() {
    @SuppressWarnings("unchecked")
    List<Question> all = em.createQuery("FROM Question").getResultList();

    return all.toArray(new Question[all.size()]);
  }
}
