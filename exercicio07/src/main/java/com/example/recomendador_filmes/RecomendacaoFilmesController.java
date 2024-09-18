package com.exemplo.recomendadorfilmes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecomendacaoFilmesController {

    @GetMapping("/recomendar")
    public String recomendarFilme(@RequestParam(required = false) Integer genero,
                                  @RequestParam(required = false) Integer ambiente) {
        if (genero == null || ambiente == null) {
            return "Por favor, forneça os parâmetros 'genero' e 'ambiente'.";
        }

        if (ambiente != 1 && ambiente != 2) {
            return "Escolha de ambientação inválida. Use 1 para Sci-fi ou 2 para Medieval.";
        }

        if (genero != 1 && genero != 2) {
            return "Escolha de gênero inválida. Use 1 para Comédia ou 2 para Drama.";
        }

        if (ambiente == 1 && genero == 1) {
            return "Recomendação: Homens de Preto";
        } else if (ambiente == 1 && genero == 2) {
            return "Recomendação: Arrival";
        } else if (ambiente == 2 && genero == 1) {
            return "Recomendação: Shrek";
        } else if (ambiente == 2 && genero == 2) {
            return "Recomendação: Gladiador";
        } else {
            return "Nenhuma recomendação disponível para essa combinação.";
        }
    }
}
