package benavente.melanie.practicapacientes.ui.adapter;

import benavente.melanie.practicapacientes.domain.entity.Patient;

public interface PatientItemInterface {
    void showDetailPatient(Patient patient);
    void deletePatient(Patient patient);
    void duplicatePatient(Patient patient);
}
