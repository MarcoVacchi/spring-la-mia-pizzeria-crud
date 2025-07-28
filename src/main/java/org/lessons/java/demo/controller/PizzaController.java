package org.lessons.java.demo.controller;

import java.util.List;

import org.lessons.java.demo.model.Pizzeria;
import org.lessons.java.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    // creazione

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizze", new Pizzeria());
        return "pizze/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizze") Pizzeria formPizzeria, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "pizze/create";
        }
        repository.save(formPizzeria);
        return "redirect:/pizze";
    }

}

// Step 1
// Abbiamo la lista delle pizze, abbiamo i dettagli delle pizze...perchè non
// realizzare la pagina per la creazione di una nuova pizza?

// Aggiungiamo quindi tutto il codice necessario per mostrare il form per la
// creazione di una nuova pizza e per il salvataggio dei dati in tabella.

// Nella index creiamo ovviamente il bottone “Crea nuova pizza” che ci porta a
// questa nuova pagina creata.

// Ricordiamoci che l’utente potrebbe sbagliare inserendo dei dati: gestiamo
// quindi la validazione! Ad esempio verifichiamo che :
// i dati della pizza siano tutti presenti
// il campi di testo non superino una certa lunghezza
// il prezzo abbia un valore valido (ha senso una pizza con prezzo minore o
// uguale a zero?)