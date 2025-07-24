package org.lessons.java.demo.controller;

import java.util.List;

import org.lessons.java.demo.model.Pizzeria;
import org.lessons.java.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/pizze")

public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    // index
    @GetMapping
    public String index(Model model) {

        List<Pizzeria> pizzeria = repository.findAll(); // new ArrayList<>(); --> per testare in caso sia vuoto;
        model.addAttribute("pizze", pizzeria);
        return "pizze/index";
    }

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        Pizzeria pizza = repository.findById(id).get();

        model.addAttribute("pizza", pizza);
        return "pizze/show";
    }

    // ricerca
    @GetMapping("/searchByName")
    public String searchByName(@RequestParam(name = "name") String name, Model model) {
        List<Pizzeria> pizzeria = repository.findByNameContainingIgnoreCase(name);
        model.addAttribute("pizze", pizzeria);
        model.addAttribute("name", name);
        return "pizze/index";
    }

}
// Step 3 - Bonus
// Nella pagina con l’elenco delle pizze aggiungiamo un campo di testo che se
// compilato filtrerà le pizze (lato server) aventi come titolo quello inserito
// dall’utente.