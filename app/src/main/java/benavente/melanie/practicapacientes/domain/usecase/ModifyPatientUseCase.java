package benavente.melanie.practicapacientes.domain.usecase;

import java.util.List;

import benavente.melanie.practicapacientes.core.domain.usecase.CommonUseCase;
import benavente.melanie.practicapacientes.domain.entity.Patient;

public class ModifyPatientUseCase extends CommonUseCase<Patient, List<Patient>> {
    @Override
    public List<Patient> executeUseCase(Patient input) {
        return repository.modifyPatient(input);
    }
}
