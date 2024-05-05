package br.com.curso.infrastructure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wallets")
public class WalletEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "wallet_id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "transaction_pin_id", nullable = false, unique = true)
    private TransactionPinEntity transactionPinEntity;
    
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity userEntity;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

}
