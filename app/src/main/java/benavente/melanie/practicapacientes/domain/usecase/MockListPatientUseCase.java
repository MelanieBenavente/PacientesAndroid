package benavente.melanie.practicapacientes.domain.usecase;

import java.util.List;

import benavente.melanie.practicapacientes.core.domain.entity.None;
import benavente.melanie.practicapacientes.core.domain.usecase.CommonUseCase;
import benavente.melanie.practicapacientes.domain.entity.Patient;
import benavente.melanie.practicapacientes.domain.repository.PatientRepository;

public class MockListPatientUseCase extends CommonUseCase<None, List<Patient>> {

    public MockListPatientUseCase(PatientRepository patientRepository) {
        super(patientRepository);
    }

    @Override
    public List<Patient> executeUseCase(None input) {
        return repository.mockList();
    }
}
