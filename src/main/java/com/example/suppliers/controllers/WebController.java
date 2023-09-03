package com.example.suppliers.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.suppliers.entities.Order;
import com.example.suppliers.repositories.OrderRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WebController {

    @Autowired
    private OrderRepository repository;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    @GetMapping(path = "/orders")
    public String orders(Principal principal, Model model) {
        Iterable<Order> orders = repository.findAll();
        model.addAttribute("orders", orders);
        model.addAttribute("username", principal.getName());

        return "orders";
    }

}
