package com.vkopendoh.springcrm.controller;

import com.vkopendoh.springcrm.service.CustomerService;
import com.vkopendoh.springcrm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject DAO
   @Autowired
   private CustomerService customerService;

    @GetMapping("/list")
    public String listCostumer(Model model) {

        //get customers from service
        List<Customer> customers = customerService.getCustomers();

        //add the customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
