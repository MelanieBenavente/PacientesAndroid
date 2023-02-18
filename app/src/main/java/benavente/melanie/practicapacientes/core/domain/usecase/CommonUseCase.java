package benavente.melanie.practicapacientes.core.domain.usecase;

import benavente.melanie.practicapacientes.data.PatientRepositoryImpl;
import benavente.melanie.practicapacientes.domain.repository.PatientRepository;

public abstract class CommonUseCase <I, O>{
    public PatientRepository repository = new PatientRepositoryImpl();

    public abstract O executeUseCase(I input);
}
