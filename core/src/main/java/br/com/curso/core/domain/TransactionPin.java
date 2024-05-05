package br.com.curso.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

public class TransactionPin {

    private UUID id;
    
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private final LocalDateTime createdAt;
    private LocalDateTime updateAt;


    public TransactionPin() {
        this.createdAt = null;
    }

    public TransactionPin(UUID id, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt,
            LocalDateTime updateAt) {
        this.id = id;
        
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    private void pinIsValid(String pin) throws TransactionPinException {

        if(pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.PIN0003.getMessage(), ErrorCodeEnum.PIN0003.getCode());
        }

    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {

        if(this.attempt == 1) {
            this.blocked = true;
            this.attempt = 0;
        } else {
            this.attempt--;
        }

    }

    public void restaureAttempt() {
        this.attempt = 3;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((pin == null) ? 0 : pin.hashCode());
        result = prime * result + ((attempt == null) ? 0 : attempt.hashCode());
        result = prime * result + ((blocked == null) ? 0 : blocked.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((updateAt == null) ? 0 : updateAt.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransactionPin other = (TransactionPin) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (pin == null) {
            if (other.pin != null)
                return false;
        } else if (!pin.equals(other.pin))
            return false;
        if (attempt == null) {
            if (other.attempt != null)
                return false;
        } else if (!attempt.equals(other.attempt))
            return false;
        if (blocked == null) {
            if (other.blocked != null)
                return false;
        } else if (!blocked.equals(other.blocked))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (updateAt == null) {
            if (other.updateAt != null)
                return false;
        } else if (!updateAt.equals(other.updateAt))
            return false;
        return true;
    }


}
