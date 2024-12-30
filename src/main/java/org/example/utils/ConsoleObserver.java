package org.example.utils;

import org.example.controllers.interfaces.IObserver;

public class ConsoleObserver implements IObserver {
    @Override
    public void update(String nombre, double calificacion) {
        System.out.println("La calificación de " + nombre + " ha cambiado a: " + calificacion);
    }
}
