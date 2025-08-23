package test;

import main.Professor   ;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void deveCriarProfessorComNome() {
        Professor professor = new Professor("Sabrina de Figuerêdo");

        assertEquals("Sabrina de Figuerêdo", professor.getNome());
    }
}
