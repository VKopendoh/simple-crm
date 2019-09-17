package com.vkopendoh.springcrm.controller;

import com.vkopendoh.springcrm.service.CustomerService;
import com.vkopendoh.springcrm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        //create model attr to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        //save the customer using service
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
        //get customer from db
        Customer customer = customerService.getCustomer(id);

        // set customer as a model attribute ti pre populate the form
        model.addAttribute("customer", customer);

        //send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String showFormForDelete(@RequestParam("customerId") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

}
