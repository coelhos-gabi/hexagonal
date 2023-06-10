package br.com.hexagonal.domain.valueobjects;

public enum TipoPerfil {
    ADMIN(1L, "ADMINISTRADOR"),
    ALUNO(2L, "ALUNO"),
    PROFESSOR(3L, "PROFESSOR");

    TipoPerfil(Long id, String perfil) {
    }

}
