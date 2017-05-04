package ua.com.garage.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.com.garage.dao.EmployeeDao;
import ua.com.garage.model.Employee;


import java.util.List;

/**
 * Created by Raketa on 24.12.2016.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(Long id) {
        return null;
    }
    // 55. имплементируем findAll vtjnlz для этого воспользуемся другой возможностью Hibernate
    // а именно выполнение запросов
    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list(); // 56. select * from Employee, будет raw casting
    }
// 99. Имплементируем метод findByName, ссесия, query

    @Override
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name",name);// 100. должно совпадать с именем параметра в query
        return (Employee) query.uniqueResult(); // 101. uniqueResult - возвращает один результат, и кастим к Employee

    }


    // 51. Делается это точно так же через sessionFactory
    // 52. так как мы при каждом запуске будем создавать employee, можно написать маленький код - или удалять - или проверку существования

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
