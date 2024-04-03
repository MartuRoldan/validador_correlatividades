package domain;

import domain.inscripciones.Alumno;
import domain.inscripciones.Inscripcion;
import domain.inscripciones.Materia;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InscripcionTest {

    @Test
    public void puedeCursarLaMateria(){
        // correlativas para Sistemas Operativos
        Materia arquitecturaDeComputadoras = new Materia("Arquitectura de computadoras", new ArrayList<>());
        Materia algoritmos = new Materia("Algoritmos", new ArrayList<>());

        // correlativas para Diseño de sistemas
        Materia analisisDeSistemas = new Materia("Analisis de sistemas", new ArrayList<>());
        Materia paradigmas = new Materia("Paradigmas de programacion", List.of(algoritmos));

        // Diseño de sistemas con sus correlativas
        Materia disenoSistemas = new Materia("Diseño de sistemas", List.of(analisisDeSistemas, paradigmas));

        // Sistemas Operativos con sus correlativas
        Materia sistemasOperativos = new Materia("Sistemas Operativos", List.of(arquitecturaDeComputadoras, algoritmos));

        //Alumno
        Alumno Margarita = new Alumno("Margarita", List.of(algoritmos, arquitecturaDeComputadoras));

        //Inscripciones
        Inscripcion PrimeraInscripcion = new Inscripcion(List.of(paradigmas, sistemasOperativos));
        Inscripcion SegundaInscripcion = new Inscripcion(List.of(paradigmas, sistemasOperativos, disenoSistemas));

        //este test tiene que dar bien
        assertTrue(PrimeraInscripcion.aprobada(Margarita.getMateriasAprobadas()));
        //este test tiene que romper
        //assertTrue(SegundaInscripcion.aprobada(Margarita.getMateriasAprobadas()));

        //test que antes rompio correctamente pero ahora debe funcionar bien por el assertFalse
        assertFalse(SegundaInscripcion.aprobada(Margarita.getMateriasAprobadas()));
    }

}

/*
Materia: Diseño de sistemas
Correlativas: Analisis de sistemas y paradigmas de programacion

Materia: Sistemas Operativos
Correlativas: Arquitectura de computadoras y Algoritmos

Materia: Paradigmas de programacion
Correlativas: Algoritmos

 */