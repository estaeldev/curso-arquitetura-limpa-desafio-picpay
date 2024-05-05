package br.com.curso.infrastructure.dto.error;

public record ValidationError(String field, String message) {}
