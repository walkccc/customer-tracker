package com.jaychen.springdemo.dao;

import com.jaychen.springdemo.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Customer> getCustomers() {

    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // create a query ... sort by last name
    Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

    // execute query and return the result list
    return query.getResultList();
  }

  @Override
  public void saveCustomer(Customer customer) {

    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // save the customer
    currentSession.save(customer);
  }
}
