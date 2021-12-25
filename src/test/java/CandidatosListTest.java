import entities.Candidato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidatosListTest {

    @Test
    void guardarCandidato() {
        CandidatosList list = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixto", true);

        assertAll(
                () -> assertFalse(list.guardarCandidato(null)),
                () -> assertTrue(list.guardarCandidato(candidato1)),
                () -> assertTrue(list.guardarCandidato(candidato2)),
                () -> assertTrue(list.guardarCandidato(candidato3)),
                () -> assertTrue(list.guardarCandidato(candidato4))
        );
    }

    @Test
    void borrarCandidato() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixto", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixto", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixto", false);
        Candidato candidato8 = new Candidato("Candidato8", "México", "Ciudad de México",
                "222-3333-4444", "candidato8@ejemplo.com", "Presencial", true);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);

        assertAll(
                () -> assertFalse(candidatosList.borrarCandidato(null)),
                () -> assertTrue(candidatosList.borrarCandidato(candidato1)),
                () -> assertTrue(candidatosList.borrarCandidato(candidato3)),
                () -> assertEquals(candidatosList.listarCandidatos().size(), 6)
        );
    }


    @Test
    void filtrar() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixta", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixta", false);
        Candidato candidato8 = new Candidato("Candidato8", "México", "Ciudad de México",
                "222-3333-4444", "candidato8@ejemplo.com", "Presencial", true);
        Candidato candidato9 = new Candidato("Candidato9", "España", "Madrid",
                "3222-333-444", "candidato9@ejemplo.com", "Mixta", false);
        Candidato candidato10 = new Candidato("Candidato10", "México", "Ciudad de México",
                "222-3333-4444", "candidato10@ejemplo.com", "Presencial", false);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);
        candidatosList.guardarCandidato(candidato9);
        candidatosList.guardarCandidato(candidato10);

        assertAll(
                () -> assertEquals(candidatosList.filtrar("Madrid").size(), 3),
                () -> assertEquals(candidatosList.filtrar("Rosario").size(), 1),
                () -> assertEquals(candidatosList.filtrar("Mixta").size(), 4),
                () -> assertEquals(candidatosList.filtrar("Remoto").size(), 2),
                () -> assertEquals(candidatosList.filtrar(true).size(), 4),
                () -> assertEquals(candidatosList.filtrar(false).size(), 6),
                () -> assertEquals(candidatosList.filtrar("Madrid", "Mixta",false).size(), 1),
                () -> assertEquals(candidatosList.filtrar("Rosario", "Mixta",false).size(), 1),
                () -> assertEquals(candidatosList.filtrar("Buenos Aires", "Presencial",true).size(), 0),
                () -> assertEquals(candidatosList.filtrar("Barcelona","Remoto",false).size(), 1)
        );
    }

    @Test
    void buscarEmailTelefono() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "1111-222-333", "candidato5@ejemplo.com", "Mixta", true);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);

        assertAll(
                () -> assertTrue(candidatosList.buscarEmail("candidato1@ejemplo.com").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato1', country='España'," +
                                " city='Madrid', phoneNumber='111-222-333', email='candidato1@ejemplo.com'," +
                                " modality='Presencial', move=true, photoUrl='null', resumeUrl='null'}")),
                () -> assertNull(candidatosList.buscarEmail("candidato17@ejemplo.com")),
                () -> assertNull(candidatosList.buscarEmail("")),
                () -> assertNull(candidatosList.buscarEmail(null)),
                () -> assertTrue(candidatosList.buscarEmail("candidato4@ejemplo.com").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato4', country='México'," +
                                " city='Ciudad de México', phoneNumber='222-3333-4444', email='candidato4@ejemplo.com'," +
                                " modality='Mixta', move=true, photoUrl='null', resumeUrl='null'}"))
        );
    }

    @Test
    void buscarTelefono() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "1111-222-333", "candidato5@ejemplo.com", "Mixta", true);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);

        assertAll(
                () -> assertTrue(candidatosList.buscarTelefono("111-222-333").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato1', country='España', " +
                                "city='Madrid', phoneNumber='111-222-333', email='candidato1@ejemplo.com'," +
                                " modality='Presencial', move=true, photoUrl='null', resumeUrl='null'}")),
                () -> assertNull(candidatosList.buscarTelefono("111-222-33333")),
                () -> assertNull(candidatosList.buscarTelefono("")),
                () -> assertNull(candidatosList.buscarTelefono(null)),
                () -> assertTrue(candidatosList.buscarTelefono("222-3333-4444").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato4', country='México'," +
                                " city='Ciudad de México', phoneNumber='222-3333-4444', email='candidato4@ejemplo.com'," +
                                " modality='Mixta', move=true, photoUrl='null', resumeUrl='null'}"))
        );
    }
}