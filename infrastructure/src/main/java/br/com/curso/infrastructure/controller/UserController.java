package br.com.curso.infrastructure.controller;

import static br.com.curso.infrastructure.util.LogUtil.LOG;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.infrastructure.dto.request.UserRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.usecase.CreateUser;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    
    private final CreateUser createUser;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<BaseResponse<?>> create(@RequestBody final UserRequest userRequest) throws Exception {

        LOG.info("Inicio da criação do usuário::UserController");

        this.createUser.create(this.userMapper.toUser(userRequest), userRequest.pin());

        LOG.info("Usuário criado com sucesso::UserController");

        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.builder()
            .success(Boolean.TRUE)
            .message("Usuário criado com sucesso")
            .build());
    }


}
