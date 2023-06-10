package br.com.hexagonal.domain.services;

import br.com.hexagonal.domain.entity.UserEntity;
import br.com.hexagonal.domain.exceptions.UserAlreadyCreated;
import br.com.hexagonal.domain.ports.UserRepository;

public class CreateNewUser {

    private final UserRepository userRepo;

    public CreateNewUser(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity execute(UserEntity user) {
        UserEntity userFromDB = userRepo.findByEmail(user.getEmail());

        if (userFromDB != null) {
            throw new UserAlreadyCreated();
        }

        // Validar atributos???

        return userRepo.save(user);
    }
}
