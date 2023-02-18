package benavente.melanie.practicapacientes.domain.usecase;

import java.util.List;

import benavente.melanie.practicapacientes.core.domain.usecase.CommonUseCase;
import benavente.melanie.practicapacientes.domain.entity.Patient;
import benavente.melanie.practicapacientes.domain.repository.PatientRepository;

public class DeletePatientUseCase extends CommonUseCase<Patient, List<Patient>> {
    public DeletePatientUseCase(PatientRepository patientRepository) {
        super(patientRepository);
    }

    @Override
    public List<Patient> executeUseCase(Patient input) {
        return repository.deletePatient(input);
    }
}
