package com.jaychen.springdemo.service;

import com.jaychen.springdemo.dao.CustomerDAO;
import com.jaychen.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerDAO customerDAO;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    return customerDAO.getCustomers();
  }
}
