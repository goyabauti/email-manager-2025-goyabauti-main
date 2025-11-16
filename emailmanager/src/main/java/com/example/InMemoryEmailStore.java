package com.example;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.example.Interfaces.EmailStore;

public class InMemoryEmailStore implements EmailStore {
    private final Map<Bandeja, List<Email>> porBandeja = new EnumMap<>(Bandeja.class);

    public InMemoryEmailStore() {
        for (Bandeja b : Bandeja.values()) porBandeja.put(b, new ArrayList<>());
    }

    @Override public List<Email> bandeja(Bandeja tipo) { return porBandeja.get(tipo); }

    @Override public void agregar(Bandeja tipo, Email e) { porBandeja.get(tipo).add(e); }

    @Override public boolean remover(Bandeja tipo, Email e) { return porBandeja.get(tipo).remove(e); }
}