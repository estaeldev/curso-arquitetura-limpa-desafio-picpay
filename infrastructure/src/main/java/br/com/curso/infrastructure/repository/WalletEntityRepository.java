package br.com.curso.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.infrastructure.entity.WalletEntity;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, UUID> {
    
}
