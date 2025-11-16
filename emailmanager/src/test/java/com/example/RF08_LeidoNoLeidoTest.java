package com.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RF08_LeidoNoLeidoTest {

    @Test
    void marcarComoLeidoYNoLeido() {
        EmailService svc = new EmailService(new InMemoryEmailStore());
        Email e = svc.crear("Asunto","Contenido", new Contacto("J","j@demo.com"), List.of(new Contacto("A","a@demo.com")));

        assertFalse(e.isLeido());
        svc.marcarLeido(e, true);
        assertTrue(e.isLeido());
        svc.marcarLeido(e, false);
        assertFalse(e.isLeido());
    }
}