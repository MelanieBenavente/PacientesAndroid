package benavente.melanie.practicapacientes.domain.repository;

import java.util.List;

import benavente.melanie.practicapacientes.domain.entity.Patient;

public interface PatientRepository {
    List<Patient> mockList();
    List<Patient> deletePatient(Patient patient);
    List<Patient> modifyPatient(Patient patient);
    List<Patient> addPatient(Patient patient);

}
