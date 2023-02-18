package benavente.melanie.practicapacientes.domain.usecase;

import benavente.melanie.practicapacientes.data.PatientRepositoryImpl;
import benavente.melanie.practicapacientes.domain.repository.PatientRepository;

public class UseCaseProvider {
    private PatientRepository repository = new PatientRepositoryImpl();
    private AddPatientUseCase addPatientUseCase;
    private DeletePatientUseCase deletePatientUseCase;
    private MockListPatientUseCase mockListPatientUseCase;
    private ModifyPatientUseCase modifyPatientUseCase;

    public AddPatientUseCase getAddPatientUseCase() {
        if (addPatientUseCase == null) {
            addPatientUseCase = new AddPatientUseCase(repository);
        }
        return addPatientUseCase;
    }

    public DeletePatientUseCase getDeletePatientUseCase() {
        if (deletePatientUseCase == null) {
            deletePatientUseCase = new DeletePatientUseCase(repository);
        }
        return deletePatientUseCase;
    }

    public MockListPatientUseCase getMockListPatientUseCase() {
        if (mockListPatientUseCase == null) {
            mockListPatientUseCase = new MockListPatientUseCase(repository);
        }
        return mockListPatientUseCase;
    }

    public ModifyPatientUseCase getModifyPatientUseCase() {
        if (modifyPatientUseCase == null) {
            modifyPatientUseCase = new ModifyPatientUseCase(repository);
        }
        return modifyPatientUseCase;
    }
}
