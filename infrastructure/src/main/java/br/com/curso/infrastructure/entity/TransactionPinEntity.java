package br.com.curso.infrastructure.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions_pin")
public class TransactionPinEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transactions_pin_id", nullable = false)
    private UUID id;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "attempt", nullable = false)
    private Integer attempt;

    @Column(name = "blocked", nullable = false)
    private Boolean blocked;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

}
