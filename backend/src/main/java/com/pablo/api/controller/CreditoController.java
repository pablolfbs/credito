package com.pablo.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.api.entity.Credito;
import com.pablo.api.entity.dto.CreditoDTO;
import com.pablo.api.exception.CreditoNotFoundException;
import com.pablo.api.service.CreditoService;

@RestController
@RequestMapping("/api")
public class CreditoController {

    private final CreditoService service;

    CreditoController(CreditoService service) {
        this.service = service;
    }

    @GetMapping("/creditos/{numeroNfse}")
    public ResponseEntity<List<CreditoDTO>> getCreditosNfse(@PathVariable String numeroNfse) {
        List<CreditoDTO> listaCreditosDTO = service.listarcreditos(numeroNfse).stream().map(service::creditoToCreditoDTOBuilder).toList();

        if (!listaCreditosDTO.isEmpty()) {
            List<CreditoDTO> listacreditos = listaCreditosDTO;
            return ResponseEntity.ok().body(listacreditos);
        }
        throw new CreditoNotFoundException(HttpStatus.NOT_FOUND.value(), "Erro ao buscar créditos. Verifique o número da NFSe.");
    }

    @GetMapping("/creditos/credito/{numeroCredito}")
    public ResponseEntity<CreditoDTO> getCreditoPorNumeroCredito(@PathVariable String numeroCredito) {
        Credito credito = service.getByNumeroCredito(numeroCredito);

        if (credito != null) {
            CreditoDTO creditoDTO = service.creditoToCreditoDTOBuilder(service.getByNumeroCredito(numeroCredito));
            return ResponseEntity.ok().body(creditoDTO);
        }
        throw new CreditoNotFoundException(HttpStatus.NOT_FOUND.value(), "Erro ao buscar crédito. Verifique o número do crédito.");
    }
    
}
