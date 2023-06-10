package br.com.hexagonal.domain.exceptions;

import java.io.Serial;

public class UserAlreadyCreated extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5635518137843386883L;
}
