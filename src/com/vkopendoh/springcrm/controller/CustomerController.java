package com.vkopendoh.springcrm.controller;

import com.vkopendoh.springcrm.dao.CustomerDAO;
import com.vkopendoh.springcrm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject DAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCostumer(Model model) {
        //get customers from dao
        List<Customer> customers = customerDAO.getCustomers();

        //add the customers to the model
        model.addAttribute("customers", customers);


        return "list-customers";
    }
}
