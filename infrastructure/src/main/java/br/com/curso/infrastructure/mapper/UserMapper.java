package br.com.curso.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.com.curso.core.domain.TaxNumber;
import br.com.curso.core.domain.User;
import br.com.curso.infrastructure.dto.request.UserRequest;
import br.com.curso.infrastructure.entity.UserEntity;

@Component
public class UserMapper {
    
    public UserEntity toUserEntity(User user) {
        return new UserEntity(
            user.getId(), 
            user.getEmail(), 
            user.getTaxNumber().getValue(), 
            user.getPassword(), 
            user.getFullname(), 
            user.getType(), 
            user.getCreatedAt(), 
            user.getUpdateAt()
        );
    }

    public User toUser(UserRequest userRequest) throws Exception {
        return new User(
            userRequest.email(), 
            userRequest.password(), 
            new TaxNumber(userRequest.taxNumber()), 
            userRequest.fullName(), 
            userRequest.type()
        );
    }

    public User toUser(UserEntity userEntity) throws Exception {
        return new User(
            userEntity.getId(), 
            userEntity.getEmail(), 
            userEntity.getPassword(), 
            new TaxNumber(userEntity.getTaxNumber()), 
            userEntity.getFullName(),
            userEntity.getType(),
            userEntity.getCreatedAt(),
            userEntity.getUpdatedAt()
        );
    }

}
