package domain.inscripciones;

import java.util.List;

public class Inscripcion {
    private List<Materia> materiasAInscribir;

    public Inscripcion(List<Materia> materiasAInscribir) {
        this.materiasAInscribir = materiasAInscribir;
    }

    public boolean aprobada(List<Materia> materiasAprobadas) {
        return materiasAInscribir.stream()
                .allMatch(materia -> materia.cumpleLaCorrelativaDeEstaMateria(materiasAprobadas));
    }
}
