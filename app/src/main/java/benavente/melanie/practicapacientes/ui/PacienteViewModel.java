package benavente.melanie.practicapacientes.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.domain.Paciente;

public class PacienteViewModel extends ViewModel {

    private MutableLiveData<List<Paciente>> pacienteList = new MutableLiveData<>();
    private MutableLiveData<Paciente> actualPatient = new MutableLiveData<>();

    public PacienteViewModel(){
        mockList();
    }

    private void mockList(){
        List<Paciente> mockList = new ArrayList<>();
        mockList.add(new Paciente("Paco", 15, true, 1));
        mockList.add(new Paciente("Marc", 11, false,2));
        mockList.add(new Paciente("Toni", 10, true, 3));
        mockList.add(new Paciente("Sara", 21, false,4));
        mockList.add(new Paciente("Alba", 71, true, 5));
        mockList.add(new Paciente("Tona", 17, false,6));
        mockList.add(new Paciente("Lali", 22, false,7));
        pacienteList.setValue(mockList);
    }

    public MutableLiveData<List<Paciente>> getpacienteList(){
        return pacienteList;
    }

    public void addPaciente(Paciente paciente){
        List<Paciente> temporaryList = pacienteList.getValue();
        temporaryList.add(paciente);
        pacienteList.setValue(temporaryList);
    }

    public void deletePaciente(Paciente paciente){
        List<Paciente> temporaryList = pacienteList.getValue();
        temporaryList.remove(paciente);
        pacienteList.setValue(temporaryList);
    }

    public MutableLiveData<Paciente> getActualPatient() {
        return actualPatient;
    }

    public void setActualPatient(Paciente actualPatient) {
        this.actualPatient.setValue(actualPatient);
    }

    public void modifyPatient(Paciente paciente){
        List<Paciente> temporaryList = pacienteList.getValue();
        
        pacienteList.setValue(temporaryList);
    }
}
