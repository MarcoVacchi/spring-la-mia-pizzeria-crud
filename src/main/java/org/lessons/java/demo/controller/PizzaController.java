package org.lessons.java.demo.controller;

import java.util.List;

import org.lessons.java.demo.model.Pizzeria;
import org.lessons.java.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
// Mostriamo una singola pizza.

// Ogni pizza dell’elenco avrà quindi un pulsante che se cliccato ci porterà a
// una pagina che mostrerà i dettagli della pizza scelta. Dobbiamo quindi
// inviare l’id come parametro dell’URL, recuperarlo nel metodo del controller,
// caricare i dati della pizza ricercata e passarli come model.

// La view a quel punto li mostrerà all’utente con la grafica che preferiamo.