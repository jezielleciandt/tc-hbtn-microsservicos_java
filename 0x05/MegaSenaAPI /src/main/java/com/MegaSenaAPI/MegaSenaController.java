package com.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        Integer [] array = new Integer[6];
        Arrays.sort(array, Collections.reverseOrder());
        return List.of(array);
    }
}
