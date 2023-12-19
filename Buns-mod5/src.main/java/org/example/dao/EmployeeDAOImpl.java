package java.org.example.dao;

import java.org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.createQuery("from Employee", Employee.class).getResultList();
        }
    }

    @Override
    public void save(Employee employee) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.saveOrUpdate(employee);
        }
    }

    @Override
    public Employee getEmployee(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Query<Employee> query = session.createQuery("delete from Employee where id = :empId");
            query.setParameter("empId", id);
            query.executeUpdate();
        }
    }
}
