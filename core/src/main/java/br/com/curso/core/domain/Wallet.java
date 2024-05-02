package br.com.curso.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.curso.core.domain.enums.UserTypeEnum;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

public class Wallet {
    
    private UUID id;
    private BigDecimal balance;
    private User user;
    private final LocalDateTime createdAt;
    private LocalDateTime updateAt;
    
    public Wallet() {
        this.createdAt = null;
    }

    public Wallet(UUID id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        BigDecimal newValue = this.balance.add(value);
        this.balance = newValue;
    }

    public void transfer(BigDecimal value) throws TransferException {

        if(this.user.getType().equals(UserTypeEnum.SHOPKEEPER)) {
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

        if(this.balance.compareTo(value) < 0){
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        BigDecimal newValue = this.balance.subtract(value);
        this.balance = newValue;

    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    
    

}
