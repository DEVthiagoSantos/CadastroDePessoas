package dev.java.CadastroDePessoas.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Boas Vindas ao inicio da minhas API!!";
    }

}