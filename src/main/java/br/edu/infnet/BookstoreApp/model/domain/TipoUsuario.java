package br.edu.infnet.BookstoreApp.model.domain;

import java.util.Arrays;

public enum TipoUsuario {
    CLIENTE,
    ADMINISTRADOR;

    public static boolean exists(String tipo) {
        return Arrays.stream(values())
            .anyMatch(value -> value.name().equalsIgnoreCase(tipo));
    }
}
