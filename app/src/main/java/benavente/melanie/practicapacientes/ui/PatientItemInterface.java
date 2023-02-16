package benavente.melanie.practicapacientes.ui;

import benavente.melanie.practicapacientes.domain.Patient;

public interface PatientItemInterface {
    void showDetailPatient(Patient patient);
    void deletePatient(Patient patient);
    void duplicatePatient(Patient patient);
}
