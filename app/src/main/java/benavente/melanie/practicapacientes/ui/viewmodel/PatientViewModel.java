package benavente.melanie.practicapacientes.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.core.domain.entity.None;
import benavente.melanie.practicapacientes.domain.entity.Patient;
import benavente.melanie.practicapacientes.domain.usecase.AddPatientUseCase;
import benavente.melanie.practicapacientes.domain.usecase.DeletePatientUseCase;
import benavente.melanie.practicapacientes.domain.usecase.MockListPatientUseCase;
import benavente.melanie.practicapacientes.domain.usecase.ModifyPatientUseCase;

public class PatientViewModel extends ViewModel {

    //livedatas
    private MutableLiveData<List<Patient>> patientList = new MutableLiveData<>();
    private MutableLiveData<Patient> actualPatient = new MutableLiveData<>();

    //usecases
    private MockListPatientUseCase mockListPatientUseCase = new MockListPatientUseCase();
    private AddPatientUseCase addPatientUseCase = new AddPatientUseCase();
    private DeletePatientUseCase deletePatientUseCase = new DeletePatientUseCase();
    private ModifyPatientUseCase modifyPatientUseCase = new ModifyPatientUseCase();
    public PatientViewModel(){
        mockList();
    }

    private void mockList(){
        patientList.setValue(mockListPatientUseCase.executeUseCase(new None()));
    }

    public MutableLiveData<List<Patient>> getpatientList(){
        return patientList;
    }

    public void addPatient(Patient patient){
        patientList.setValue(addPatientUseCase.executeUseCase(patient));
    }

    public void deletePatient(Patient patient){
        patientList.setValue(deletePatientUseCase.executeUseCase(patient));
    }

    public MutableLiveData<Patient> getActualPatient() {
        return actualPatient;
    }

    public void setActualPatient(Patient actualPatient) {
        this.actualPatient.setValue(actualPatient);
    }

    public void modifyPatient(Patient patient){
        patientList.setValue(modifyPatientUseCase.executeUseCase(patient));
    }
}
