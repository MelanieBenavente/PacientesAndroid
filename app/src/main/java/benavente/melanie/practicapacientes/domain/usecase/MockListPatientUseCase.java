package benavente.melanie.practicapacientes.domain.usecase;

import java.util.List;

import benavente.melanie.practicapacientes.core.domain.entity.None;
import benavente.melanie.practicapacientes.core.domain.usecase.CommonUseCase;
import benavente.melanie.practicapacientes.domain.entity.Patient;

public class MockListPatientUseCase extends CommonUseCase<None, List<Patient>> {

    @Override
    public List<Patient> executeUseCase(None input) {
        return repository.mockList();
    }
}
