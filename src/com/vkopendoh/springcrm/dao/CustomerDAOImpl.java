package com.vkopendoh.springcrm.dao;

import com.vkopendoh.springcrm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //inject session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        //get hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create query .. sort by last name
        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

        // exec query and get result list
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session =sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class,id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Customer where id=:theId").setParameter("theId",id).executeUpdate();
    }
}
