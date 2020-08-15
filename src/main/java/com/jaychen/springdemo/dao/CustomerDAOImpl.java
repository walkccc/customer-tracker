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

    // save or update the customer
    currentSession.saveOrUpdate(customer);
  }

  @Override
  public Customer getCustomer(int id) {

    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // retrieve/read from database using the primary key
    return currentSession.get(Customer.class, id);
  }

  @Override
  public void deleteCustomer(int id) {

    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // delete from database using the primary key
    Query query = currentSession.createQuery("delete from Customer where id=:customerId");
    query.setParameter("customerId", id);
    query.executeUpdate();
  }

  @Override
  public List<Customer> searchCustomers(String searchName) {

    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    Query<Customer> query = null;

    // only search by name if theSearchName is not empty
    if (searchName != null && searchName.trim().length() > 0) {

      // search for firstName or lastName ... case insensitive
      query = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
      query.setParameter("theName", "%" + searchName.toLowerCase() + "%");

    } else {
      // theSearchName is empty ... so just get all customers
      query = currentSession.createQuery("from Customer", Customer.class);
    }

    // execute query and return the result list
    return query.getResultList();
  }
}
