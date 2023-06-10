package br.com.hexagonal.domain.ports;

import br.com.hexagonal.domain.entity.UserEntity;
import br.com.hexagonal.domain.valueobjects.Email;

import java.util.List;

public interface UserRepository {
    UserEntity save(UserEntity user);

    UserEntity findByEmail(Email email);

    List<UserEntity> findAll(int page, int size);
}
