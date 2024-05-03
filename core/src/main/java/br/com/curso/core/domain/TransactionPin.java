package br.com.curso.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

public class TransactionPin {

    private UUID id;
    private User user;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private final LocalDateTime createdAt;
    private LocalDateTime updateAt;


    public TransactionPin() {
        this.createdAt = null;
    }

    public TransactionPin(UUID id, User user, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt,
            LocalDateTime updateAt) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public TransactionPin(User user, String pin) throws TransactionPinException {
        this.user = user;
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    private void pinIsValid(String pin) throws TransactionPinException {

        if(pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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
