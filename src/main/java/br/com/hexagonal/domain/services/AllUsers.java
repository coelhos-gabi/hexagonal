package br.com.hexagonal.domain.services;

import br.com.hexagonal.domain.entity.UserEntity;
import br.com.hexagonal.domain.ports.UserRepository;

import java.util.List;
import java.util.Optional;

public class AllUsers {
    private final UserRepository userRepo;

    public AllUsers(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEntity> execute(Optional<Integer> page, Optional<Integer> size) {
        int validPage = page.isPresent() && page.get() >= 0 ? page.get() : 0;
        int validSize = size.isPresent() && size.get() <= 50 && size.get() > 0 ? size.get() : 10;
        return userRepo.findAll(validPage, validSize);
    }
}
