package org.lessons.java.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizzeria")

public class Pizzeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The name mustn't be empty or null or blank")
    private String name;

    @Lob
    private String description;

    @NotBlank(message = "The URLcode mustn't be empty or null or blank")
    private String pick;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPick() {
        return this.pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    private BigDecimal price;

}

// Dobbiamo realizzare un’applicazione web che ci aiuti a gestire la nostra
// pizzeria.

// Abbiamo bisogno di creare la prima pagina (index) dove mostriamo tutte le
// pizze che prepariamo. Nei prossimi giorni implementeremo il resto dei metodi
// per le CRUD.

// Una pizza avrà le seguenti informazioni :

// un id
// un nome
// una descrizione
// una foto (url)
// un prezzo

// Creiamo il database, repository e l'entity per gestire le CRUD delle pizze.

// Implementiamo quindi il controller con il metodo index che restituisce una
// view per mostrare l’elenco delle pizze caricate dal database (possiamo creare
// una tabella con bootstrap o una qualche grafica a nostro piacimento che
// mostri questo elenco... con un po’ di creatività se vogliamo!)

// L’elenco potrebbe essere vuoto: in quel caso dobbiamo mostrare un messaggio
// che indichi all’utente che non ci sono pizze presenti nella nostra
// applicazione.

// Gestiamo i componenti riutilizzabili con i fragments.