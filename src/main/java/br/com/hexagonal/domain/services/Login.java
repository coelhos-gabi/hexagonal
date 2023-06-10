package br.com.hexagonal.domain.services;

import br.com.hexagonal.domain.entity.UserEntity;
import br.com.hexagonal.domain.exceptions.EmailNotFoundException;
import br.com.hexagonal.domain.exceptions.WrongPasswordException;
import br.com.hexagonal.domain.ports.UserRepository;
import br.com.hexagonal.domain.valueobjects.Email;
import br.com.hexagonal.domain.valueobjects.Password;

public class Login {

    private UserRepository userRepo;

    public Login(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity execute(Email email, Password password) {
        UserEntity userFromDB = userRepo.findByEmail(email);
        if (userFromDB == null) {
            throw new EmailNotFoundException();
        }

        Password expected = userFromDB.getSenha();

        if (!expected.same(password)) {
            throw new WrongPasswordException();
        }

        return userFromDB;
    }
}