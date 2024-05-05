package br.com.curso.infrastructure.dto.response;

import java.util.List;

import br.com.curso.infrastructure.dto.error.ValidationError;

public record ErrorResponse(String code, String message, List<ValidationError> validations) {}
