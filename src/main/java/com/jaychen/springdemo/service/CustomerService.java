package com.jaychen.springdemo.service;

import com.jaychen.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

  List<Customer> getCustomers();

  void saveCustomer(Customer customer);

  Customer getCustomer(int id);
}
