package com.pablo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pablo.api.entity.Credito;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Integer> {

    List<Credito> findByNumeroNfse(String numeroNfse);
    
    Credito findByNumeroCredito(String numeroCredito);
    
}