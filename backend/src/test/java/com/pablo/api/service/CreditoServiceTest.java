package com.pablo.api.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pablo.api.entity.Credito;
import com.pablo.api.entity.dto.CreditoDTO;
import com.pablo.api.repository.CreditoRepository;

@ExtendWith(MockitoExtension.class)
class CreditoServiceTest {

    @InjectMocks
    private CreditoService service;

    @Mock
    CreditoRepository creditoRepository;

    @Test
    void deveListarcreditosSemErros() {
        String numeroNfse = "7891011";

        assertDoesNotThrow(() -> service.listarcreditos(numeroNfse));
    }

    @Test
    void deveChamarRepositoryAoListarCreditos() {
        String numeroNfse = "7891011";

        service.listarcreditos(numeroNfse);

        verify(creditoRepository, times(1)).findByNumeroNfse(numeroNfse);
    }

    @Test
    void deveRetornarCreditoSemErros() {
        String numeroCredito = "123456";

        assertDoesNotThrow(() -> service.getByNumeroCredito(numeroCredito));
    }

    @Test
    void deveChamarRepositoryPorNumeroCredito() {
        String numeroCredito = "123456";

        service.getByNumeroCredito(numeroCredito);

        verify(creditoRepository, times(1)).findByNumeroCredito(numeroCredito);
    }

    @Test
    void deveCriarCreditoDTO() {
        Long id = 1l;
        String numeroCredito = "123456";
        String numeroNfse = "7891011";
        LocalDate dataConstituicao = LocalDate.of(2024, Month.FEBRUARY, 25);
        BigDecimal valorIssqn = new BigDecimal("1500.75");
        String tipoCredito = "ISSQN";
        boolean simplesNacional = true;
        BigDecimal aliquota = new BigDecimal(5.00);
        BigDecimal valorFaturado = new BigDecimal(30000.00);
        BigDecimal valorDeducao = new BigDecimal(5000.00);
        BigDecimal baseCalculo = new BigDecimal(25000.00);
        Credito credito = new Credito(id, numeroCredito, numeroNfse, dataConstituicao, valorIssqn, tipoCredito, simplesNacional, aliquota, valorFaturado, valorDeducao, baseCalculo);

        CreditoDTO dto = CreditoDTO.builder()
                .numeroCredito(credito.getNumeroCredito())
                .numeroNfse(credito.getNumeroNfse())
                .dataConstituicao(credito.getDataConstituicao())
                .valorIssqn(credito.getValorIssqn())
                .tipoCredito(credito.getTipoCredito())
                .simplesNacional(credito.isSimplesNacional())
                .aliquota(credito.getAliquota())
                .valorFaturado(credito.getValorFaturado())
                .valorDeducao(credito.getValorDeducao())
                .baseCalculo(credito.getBaseCalculo())
            .build();

        service.creditoToCreditoDTOBuilder(credito);

        assertNotNull(dto);
        assertEquals("123456", dto.getNumeroCredito());
        assertEquals("7891011", dto.getNumeroNfse());
        assertEquals(LocalDate.of(2024, Month.FEBRUARY, 25), dto.getDataConstituicao());
        assertEquals(new BigDecimal("1500.75"), dto.getValorIssqn());
        assertEquals(true, dto.isSimplesNacional());
        assertEquals(new BigDecimal(5.00), dto.getAliquota());
        assertEquals(new BigDecimal(30000.00), dto.getValorFaturado());
        assertEquals(new BigDecimal(5000.00), dto.getValorDeducao());
        assertEquals(new BigDecimal(25000.00), dto.getBaseCalculo());
    }

}
