package br.com.curso.infrastructure.dto.request;

import br.com.curso.core.domain.enums.UserTypeEnum;

public record UserRequest(String email, String password, String taxNumber, String fullName, UserTypeEnum type, String pin) {} 
