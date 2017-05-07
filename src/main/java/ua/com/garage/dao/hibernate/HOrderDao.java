package ua.com.garage.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.com.garage.dao.OrderDao;
import ua.com.garage.model.Order;


import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public class HOrderDao implements OrderDao {

  private SessionFactory sessionFactory;

  @Override
  public void save(Order order) {
    sessionFactory.getCurrentSession().save(order);
  }

  @Override
  public List<Order> findAllOrders() {
    return sessionFactory.getCurrentSession().
            createQuery("select o from Order o").list();
  }

  @Override
  public void removeAll() {
    sessionFactory.getCurrentSession().createQuery("delete from Order").executeUpdate();
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

}
