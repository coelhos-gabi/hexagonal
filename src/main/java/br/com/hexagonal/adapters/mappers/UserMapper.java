package br.com.hexagonal.adapters.mappers;

import br.com.hexagonal.adapters.dto.UserDTO;
import br.com.hexagonal.domain.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity asUserEntity(UserDTO userDTO);
    UserDTO asUserDTO(UserEntity user);
}
