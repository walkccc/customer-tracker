package com.jaychen.springdemo.dao;

import com.jaychen.springdemo.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

  private SessionFactory sessionFactory;

  @Override
  @Transactional
  public List<Customer> getCustomers() {

    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // create a query
    Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

    // execute query and return the result list
    return query.getResultList();
  }
}
