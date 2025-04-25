package com.pablo.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pablo.api.entity.Credito;
import com.pablo.api.service.CreditoService;

@SpringBootTest
@AutoConfigureMockMvc
class CreditoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CreditoService service;

    @Test
    void deveDevolverCodigo404AoPegarCreditosNfse() throws Exception {

        var response = mvc.perform(
                        MockMvcRequestBuilders.get("/api/creditos/111111")
                                    .contentType(MediaType.APPLICATION_JSON)
                    ).andReturn().getResponse();

        assertEquals(404, response.getStatus());
    }

    @Test
    void deveDevolverCodigo200AoPegarCreditosNfse() throws Exception {

        Long id = 1l;
        String numeroCredito = "123456";
        String numeroNfse = "123456";
        LocalDate dataConstituicao = LocalDate.of(2024, Month.FEBRUARY, 25);
        BigDecimal valorIssqn = new BigDecimal("1500.75");
        String tipoCredito = "ISSQN";
        boolean simplesNacional = true;
        BigDecimal aliquota = new BigDecimal(5.00);
        BigDecimal valorFaturado = new BigDecimal(30000.00);
        BigDecimal valorDeducao = new BigDecimal(5000.00);
        BigDecimal baseCalculo = new BigDecimal(25000.00);
        Credito credito = new Credito(id, numeroCredito, numeroNfse, dataConstituicao, valorIssqn, tipoCredito, simplesNacional, aliquota, valorFaturado, valorDeducao, baseCalculo);

        List<Credito> listaCreditos = new ArrayList<>();
        listaCreditos.add(credito);
        when(service.listarcreditos("7891011")).thenReturn(listaCreditos);

        var response = mvc.perform(
                        MockMvcRequestBuilders.get("/api/creditos/7891011")
                                    .contentType(MediaType.APPLICATION_JSON)
                    ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
    }

    @Test
    void deveDevolverCodigo404AoPegarCreditosNumero() throws Exception {

        var response = mvc.perform(
                        MockMvcRequestBuilders.get("/api/creditos/credito/111111")
                                    .contentType(MediaType.APPLICATION_JSON)
                    ).andReturn().getResponse();

        assertEquals(404, response.getStatus());
    }

    @Test
    void deveDevolverCodigo200AoPegarCreditosNumero() throws Exception {

        Long id = 1l;
        String numeroCredito = "123456";
        String numeroNfse = "123456";
        LocalDate dataConstituicao = LocalDate.of(2024, Month.FEBRUARY, 25);
        BigDecimal valorIssqn = new BigDecimal("1500.75");
        String tipoCredito = "ISSQN";
        boolean simplesNacional = true;
        BigDecimal aliquota = new BigDecimal(5.00);
        BigDecimal valorFaturado = new BigDecimal(30000.00);
        BigDecimal valorDeducao = new BigDecimal(5000.00);
        BigDecimal baseCalculo = new BigDecimal(25000.00);
        Credito credito = new Credito(id, numeroCredito, numeroNfse, dataConstituicao, valorIssqn, tipoCredito, simplesNacional, aliquota, valorFaturado, valorDeducao, baseCalculo);

        when(service.getByNumeroCredito("123456")).thenReturn(credito);

        var response = mvc.perform(
                        MockMvcRequestBuilders.get("/api/creditos/credito/123456")
                                    .contentType(MediaType.APPLICATION_JSON)
                    ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
    }

}
