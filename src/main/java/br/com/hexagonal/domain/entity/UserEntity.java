package br.com.hexagonal.domain.entity;

import br.com.hexagonal.domain.valueobjects.Password;
import br.com.hexagonal.domain.valueobjects.Email;
import br.com.hexagonal.domain.valueobjects.Name;
import br.com.hexagonal.domain.valueobjects.TipoPerfil;

public class UserEntity {
    private Long id;
    private Name name;
    private Email email;
    private Password password;

    public UserEntity() {
    }

    public UserEntity(Long id, String tipoPerfil, String name, String email, String senha) {
        this(id,TipoPerfil.valueOf(tipoPerfil), new Name(name), new Email(email), new Password(senha));
    }

    public UserEntity(Long id, TipoPerfil tipoPerfil, Name name, Email email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Password getSenha() {
        return password;
    }
}
