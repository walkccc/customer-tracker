package com.jaychen.springdemo.dao;

import com.jaychen.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

  List<Customer> getCustomers();

  void saveCustomer(Customer customer);

  Customer getCustomer(int id);
}
