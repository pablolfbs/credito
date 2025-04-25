package com.pablo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.api.entity.Credito;
import com.pablo.api.entity.dto.CreditoDTO;
import com.pablo.api.repository.CreditoRepository;

@Service
public class CreditoService {

    @Autowired
    public CreditoRepository repository;

    public List<Credito> listarcreditos(String numeroNfse) {
        return repository.findByNumeroNfse(numeroNfse);
    }

    public Credito getByNumeroCredito(String numeroCredito) {
		Credito c = repository.findByNumeroCredito(numeroCredito);
        return c;
    }

    public CreditoDTO creditoToCreditoDTOBuilder(Credito credito) {
		return CreditoDTO.builder()
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
	}

}
