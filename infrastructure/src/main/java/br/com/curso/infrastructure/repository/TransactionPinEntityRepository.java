package br.com.curso.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.infrastructure.entity.TransactionPinEntity;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, UUID> {
    
}
