package benavente.melanie.practicapacientes.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.domain.Patient;

public class PatientViewModel extends ViewModel {

    private MutableLiveData<List<Patient>> patientList = new MutableLiveData<>();
    private MutableLiveData<Patient> actualPatient = new MutableLiveData<>();

    public PatientViewModel(){
        mockList();
    }

    private void mockList(){
        List<Patient> mockList = new ArrayList<>();
        mockList.add(new Patient("Paco", 15, true, 1));
        mockList.add(new Patient("Marc", 11, false,2));
        mockList.add(new Patient("Toni", 10, true, 3));
        mockList.add(new Patient("Sara", 21, false,4));
        mockList.add(new Patient("Alba", 71, true, 5));
        mockList.add(new Patient("Tona", 17, false,6));
        mockList.add(new Patient("Lali", 22, false,7));
        patientList.setValue(mockList);
    }

    public MutableLiveData<List<Patient>> getpatientList(){
        return patientList;
    }

    public void addPatient(Patient patient){
        List<Patient> temporaryList = patientList.getValue();
        temporaryList.add(patient);
        patientList.setValue(temporaryList);
    }

    public void deletePatient(Patient patient){
        List<Patient> temporaryList = patientList.getValue();
        temporaryList.remove(patient);
        patientList.setValue(temporaryList);
    }

    public MutableLiveData<Patient> getActualPatient() {
        return actualPatient;
    }

    public void setActualPatient(Patient actualPatient) {
        this.actualPatient.setValue(actualPatient);
    }

    public void modifyPatient(Patient patient){
        List<Patient> temporaryList = patientList.getValue();
        for (int i = 0; i < patientList.getValue().size(); i++)
        {
            if (patient.getId() == patientList.getValue().get(i).getId()) {
                temporaryList.remove(i);
                temporaryList.add(i, patient);
            }
        }
        patientList.setValue(temporaryList);
    }
}
