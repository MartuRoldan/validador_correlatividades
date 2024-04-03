package domain.inscripciones;

import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public boolean cumpleLaCorrelativaDeEstaMateria(List<Materia> materiasAprobadas) {
        return materiasAprobadas.containsAll(correlativas);
    }
}
