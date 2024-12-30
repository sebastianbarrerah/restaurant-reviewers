package org.example.utils;

import org.example.controllers.interfaces.Observer;

public class ConsoleObserver implements Observer {
    @Override
    public void update(String nombre, double calificacion) {
        System.out.println("La calificación de " + nombre + " ha cambiado a: " + calificacion);
    }
}
