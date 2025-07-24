package org.lessons.java.demo.controller;

import java.util.List;

import org.lessons.java.demo.model.Pizzeria;
import org.lessons.java.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/pizze")

public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {

        List<Pizzeria> pizzeria = repository.findAll();
        model.addAttribute("pizze", pizzeria);
        return "pizze/index";
    }

}
