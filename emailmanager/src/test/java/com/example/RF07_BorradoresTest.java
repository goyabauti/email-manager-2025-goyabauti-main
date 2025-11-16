package com.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RF07_BorradoresTest {

    @Test
    void guardarEditarYEnviarBorrador() {
        InMemoryEmailStore store = new InMemoryEmailStore();
        EmailService svc = new EmailService(store);

        Contacto remitente = new Contacto("Yo","yo@demo.com");
        Contacto ana = new Contacto("Ana","ana@demo.com");

        Email borrador = svc.crear("Borrador inicial", "Texto", remitente, List.of(ana));
        svc.guardarBorrador(borrador);
        assertEquals(1, store.bandeja(Bandeja.BORRADORES).size());

        // editar borrador
        borrador.setAsunto("Borrador final");
        borrador.setContenido("Texto actualizado");

        // enviar
        svc.enviar(borrador);
        assertEquals(1, store.bandeja(Bandeja.ENVIADOS).size());
    }
}
