package br.com.hexagonal.adapters.dto;

import java.util.Date;

public record LoginSession(
        String name,
        String email,
        String token,
        Date startsAt) {}
