import entities.Candidato;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CandidatosList {
    private ArrayList<Candidato> candidates = new ArrayList<>();

    public ArrayList<Candidato> listarCandidatos() {
        return candidates;
    }

    public boolean guardarCandidato(Candidato candidate) {
        if (candidate == null) {
            return false;
        }
        return candidates.add(candidate);
    }

    public boolean borrarCandidato(Candidato candidate) {
        if (candidate != null) {
            candidates.removeIf(x -> candidate.getEmail().equals(x.getEmail()));
            return true;
        }
        return false;
    }

    public ArrayList<Candidato> filtrar(String filtro) {
        if (filtro.equalsIgnoreCase("remoto") ||
                filtro.equalsIgnoreCase("mixta") ||
                filtro.equalsIgnoreCase("presencial")) {
            return candidates.stream()
                    .filter(x -> filtro.equalsIgnoreCase(x.getModality()))
                    .collect(Collectors.toCollection(ArrayList::new));

        } else {
            return candidates.stream()
                    .filter(x -> filtro.equalsIgnoreCase(x.getCity()))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    public ArrayList<Candidato> filtrar(Boolean tipoTraslado) {
        return candidates.stream()
                .filter(x -> tipoTraslado == (x.getMove()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Candidato> filtrar(String ciudad, String presencialidad, boolean tipoTraslado) {
        ArrayList<Candidato> filteredCandidates = new ArrayList<>();

        return candidates.stream()
                .filter(x -> ciudad.equalsIgnoreCase(x.getCity()))
                .filter(x -> presencialidad.equalsIgnoreCase(x.getModality()))
                .filter(x -> tipoTraslado == x.getMove())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Candidato buscarEmail(String email) {
        if (email != null && !email.equals("")) {
            List<Candidato> filteredCandidates = candidates.stream()
                    .filter(x -> email.equals(x.getEmail()))
                    .toList();
            if (filteredCandidates.size() == 1) {
                return filteredCandidates.get(0);
            }
        }
        return null;
    }

    public Candidato buscarTelefono(String telefono) {
        if (telefono != null && !telefono.equals("")) {
            List<Candidato> filteredCandidates = candidates.stream()
                    .filter(x -> telefono.equals(x.getPhoneNumber()))
                    .toList();
            if (filteredCandidates.size() == 1) {
                return filteredCandidates.get(0);
            }
        }
        return null;
    }
}
