package com.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RF06_BandejasClasificacionTest {

    @Test
    void moverYRestaurarCorreos() {
        InMemoryEmailStore store = new InMemoryEmailStore();
        EmailService svc = new EmailService(store);

        Contacto a = new Contacto("A","a@demo.com");
        Contacto b = new Contacto("B","b@demo.com");
        Email e = svc.crear("Asunto", "Texto", a, List.of(b));

        svc.recibirEnEntrada(e);
        assertEquals(1, store.bandeja(Bandeja.ENTRADA).size());

        svc.mover(Bandeja.ENTRADA, Bandeja.ELIMINADOS, e);
        assertEquals(0, store.bandeja(Bandeja.ENTRADA).size());
        assertEquals(1, store.bandeja(Bandeja.ELIMINADOS).size());

        svc.restaurarDeEliminados(e);
        assertEquals(1, store.bandeja(Bandeja.ENTRADA).size());
        assertEquals(0, store.bandeja(Bandeja.ELIMINADOS).size());
    }
}