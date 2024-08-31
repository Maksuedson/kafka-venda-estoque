package com.kipper.vendaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/venda")
    public String registrarVenda(@RequestBody String venda) {
        kafkaTemplate.send("estoque_topico", venda);
        return "Venda registrada com sucesso!";
    }
}