package benavente.melanie.practicapacientes.ui;

import benavente.melanie.practicapacientes.domain.Paciente;

public interface PatientItemInterface {
    void showDetailPatient(Paciente paciente);
    void deletePatient(Paciente paciente);
    void duplicatePatient(Paciente paciente);
}
