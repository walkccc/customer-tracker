package com.jaychen.springdemo.controller;

import com.jaychen.springdemo.dao.CustomerDAO;

import com.jaychen.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerDAO customerDAO;

  @RequestMapping("/list")
  public String listCustomers(Model model) {

    // get customers from the dao
    List<Customer> customers = customerDAO.getCustomers();

    // add the customers to the model
    model.addAttribute("customers", customers);

    return "list-customers";
  }
}
