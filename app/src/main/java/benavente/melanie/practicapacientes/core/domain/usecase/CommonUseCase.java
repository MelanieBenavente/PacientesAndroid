package benavente.melanie.practicapacientes.core.domain.usecase;

import benavente.melanie.practicapacientes.data.PatientRepositoryImpl;
import benavente.melanie.practicapacientes.domain.repository.PatientRepository;

public abstract class CommonUseCase <I, O>{
    public PatientRepository repository;

    public CommonUseCase(PatientRepository patientRepository) {
        this.repository = patientRepository;
    }

    public abstract O executeUseCase(I input);
}
