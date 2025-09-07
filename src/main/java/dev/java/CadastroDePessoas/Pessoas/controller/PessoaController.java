package dev.java.CadastroDePessoas.Pessoas.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PessoaController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Boas Vindas ao inicio da minhas API!!";
    }

}