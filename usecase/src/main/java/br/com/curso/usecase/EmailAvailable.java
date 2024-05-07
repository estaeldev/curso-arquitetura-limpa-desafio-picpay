package br.com.curso.usecase;

import br.com.curso.core.exception.EmailException;

public interface EmailAvailable {

     Boolean emailAvailable(String email) throws EmailException;
    
}
