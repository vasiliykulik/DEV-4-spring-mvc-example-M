package ua.com.garage.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.garage.dao.DishDao;
import ua.com.garage.model.Dish;

import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public class HDishDao implements DishDao {

  private SessionFactory sessionFactory;


  @Override
  public void save(Dish dish) {
    sessionFactory.getCurrentSession().save(dish);
  }


  @Override
  public List<Dish> findAll() {
    return sessionFactory.getCurrentSession().
            createQuery("select d from Dish d").list();
  }

  @Override
  public Dish findByName(String name) {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("select d from Dish d where d.name like :name");
    query.setParameter("name", name);
    return (Dish) query.uniqueResult();
  }

  @Override
  public void removeAll() {
    sessionFactory.getCurrentSession().createQuery("delete from Dish ").executeUpdate();
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
