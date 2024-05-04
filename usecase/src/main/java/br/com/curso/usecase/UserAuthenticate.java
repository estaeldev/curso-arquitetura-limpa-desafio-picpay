package br.com.curso.usecase;

import br.com.curso.core.exception.AuthenticationException;

public interface UserAuthenticate {
    
    Boolean authenticate(String username, String password) throws AuthenticationException;

}
