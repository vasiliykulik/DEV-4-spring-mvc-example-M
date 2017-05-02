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
    // 72. Здесь нам понадобится Session Factory

    private SessionFactory sessionFactory;
    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    // 77.
    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    // 104. То же самое здесь

    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish в where d.name like :name");
        // 108. Самое главное хабыл - нужно было засетить параметр
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }


    // 73. setter понадобиться

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
