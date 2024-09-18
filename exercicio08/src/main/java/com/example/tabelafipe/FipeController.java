package com.example.tabelafipe;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FipeController {

    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/carros";

    @PostMapping("/fipe")
    public FipeResponse obterValorFipe(@RequestBody CarroRequest carroRequest) {
        RestTemplate restTemplate = new RestTemplate();

        // Obter marcas
        String marcasUrl = BASE_URL + "/marcas";
        Marca[] marcas = restTemplate.getForObject(marcasUrl, Marca[].class);

        if (marcas == null) {
            throw new RuntimeException("Não foi possível obter as marcas.");
        }

        // Encontrar o código da marca
        String marcaCodigo = findCodigoByNome(marcas, carroRequest.getMarca());

        if (marcaCodigo == null) {
            throw new RuntimeException("Marca não encontrada.");
        }

        // Obter modelos da marca
        String modelosUrl = BASE_URL + "/marcas/" + marcaCodigo + "/modelos";
        ModelosResponse modelosResponse = restTemplate.getForObject(modelosUrl, ModelosResponse.class);

        if (modelosResponse == null) {
            throw new RuntimeException("Não foi possível obter os modelos.");
        }

        // Encontrar o código do modelo
        String modeloCodigo = findCodigoByNome(modelosResponse.getModelos(), carroRequest.getModelo());

        if (modeloCodigo == null) {
            throw new RuntimeException("Modelo não encontrado.");
        }

        // Obter anos do modelo
        String anosUrl = BASE_URL + "/marcas/" + marcaCodigo + "/modelos/" + modeloCodigo + "/anos";
        AnosResponse anosResponse = restTemplate.getForObject(anosUrl, AnosResponse.class);

        if (anosResponse == null) {
            throw new RuntimeException("Não foi possível obter os anos.");
        }

        // Encontrar o código do ano
        String anoCodigo = findAnoCodigoByAno(anosResponse.getAnos(), carroRequest.getAno());

        if (anoCodigo == null) {
            throw new RuntimeException("Ano não encontrado.");
        }

        // Obter valor do ano
        String valorUrl = BASE_URL + "/marcas/" + marcaCodigo + "/modelos/" + modeloCodigo + "/anos/" + anoCodigo;
        ValorFipeResponse valorFipeResponse = restTemplate.getForObject(valorUrl, ValorFipeResponse.class);

        if (valorFipeResponse == null) {
            throw new RuntimeException("Não foi possível obter o valor.");
        }

        FipeResponse response = new FipeResponse();
        response.setValor(valorFipeResponse.getValor());
        response.setMes(valorFipeResponse.getMesReferencia());

        return response;
    }

    private String findCodigoByNome(Marca[] marcas, String nome) {
        for (Marca marca : marcas) {
            if (marca.getNome().equalsIgnoreCase(nome)) {
                return marca.getCodigo();
            }
        }
        return null;
    }

    private String findCodigoByNome(Modelo[] modelos, String nome) {
        for (Modelo modelo : modelos) {
            if (modelo.getNome().equalsIgnoreCase(nome)) {
                return modelo.getCodigo();
            }
        }
        return null;
    }

    private String findAnoCodigoByAno(Ano[] anos, int ano) {
        for (Ano anoObj : anos) {
            if (anoObj.getAno() == ano) {
                return anoObj.getCodigo();
            }
        }
        return null;
    }
}
