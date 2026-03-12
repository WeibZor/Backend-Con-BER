package com.gestiontalentohumano;

import com.gestiontalentohumano.domain.Aspirante;
import com.gestiontalentohumano.domain.Persona;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DomainModelTest {
    @Test
    public void aspiranteInheritance() {
        Aspirante a = new Aspirante("1", "Juan", "Perez", LocalDate.of(1990,1,1), "Analista", LocalDate.now());
        assertTrue(a instanceof Persona);
        assertEquals("Juan", a.getNombre());
    }
}
