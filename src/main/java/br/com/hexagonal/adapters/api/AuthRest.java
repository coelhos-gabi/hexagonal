package br.com.hexagonal.adapters.api;
import br.com.hexagonal.adapters.dto.LoginSession;
import br.com.hexagonal.domain.entity.UserEntity;
import br.com.hexagonal.domain.exceptions.EmailNotFoundException;
import br.com.hexagonal.domain.exceptions.WrongPasswordException;
import br.com.hexagonal.domain.ports.UserRepository;
import br.com.hexagonal.domain.services.Login;
import br.com.hexagonal.domain.valueobjects.Email;
import br.com.hexagonal.domain.valueobjects.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthRest {

    @Autowired
    private UserRepository userRepo;

    @PostMapping(path = "login")
    public LoginSession login(String email, String password) {
        Login login = new Login(userRepo);
        UserEntity user = login.execute(new Email(email), new Password(password));
        return new LoginSession(user.getName().toString(),
                user.getEmail().toString(),
                "fake token...",
                new Date());
    }

    @ExceptionHandler({ EmailNotFoundException.class, WrongPasswordException.class })
    public ResponseEntity<String> wrongEmailAndPassword(RuntimeException e) {
        return new ResponseEntity<String>("Usuário/Senha inválidos", HttpStatus.BAD_REQUEST);
    }
}