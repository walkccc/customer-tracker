package com.jaychen.springdemo.controller;

import com.jaychen.springdemo.entity.Customer;
import com.jaychen.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/list")
  public String listCustomers(Model model) {

    // get customers from the service
    List<Customer> customers = customerService.getCustomers();

    // add the customers to the model
    model.addAttribute("customers", customers);

    return "list-customers";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {

    // create model attribute to bind form data
    Customer customer = new Customer();
    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {

    customerService.saveCustomer(customer);

    return "redirect:/customer/list";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

    // get the customer from the database
    Customer customer = customerService.getCustomer(id);

    // set the customer as a model attribute to pre-populate the form
    model.addAttribute("customer", customer);

    // send over to our form
    return "customer-form";
  }
}
