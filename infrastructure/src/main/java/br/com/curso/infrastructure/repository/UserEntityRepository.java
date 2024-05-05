package br.com.curso.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.infrastructure.entity.UserEntity;


public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    
    Boolean existsByTaxNumber(String taxNumber);
    Boolean existsByEmail(String email);

}
