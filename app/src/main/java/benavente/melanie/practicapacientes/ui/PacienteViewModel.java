package benavente.melanie.practicapacientes.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.domain.Paciente;

public class PacienteViewModel extends ViewModel {

    private MutableLiveData<List<Paciente>> pacienteList;
    private Paciente actualPatient = null;

    public PacienteViewModel(){
        pacienteList = new MutableLiveData<>();
        mockList();
    }

    private void mockList(){
        List<Paciente> mockList = new ArrayList<>();
        mockList.add(new Paciente("Paco", 15, true));
        mockList.add(new Paciente("Marc", 11, false));
        mockList.add(new Paciente("Toni", 10, true));
        mockList.add(new Paciente("Sara", 21, false));
        mockList.add(new Paciente("Alba", 71, true));
        mockList.add(new Paciente("Tona", 17, false));
        mockList.add(new Paciente("Lali", 22, false));
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

    public Paciente getActualPatient() {
        return actualPatient;
    }

    public void setActualPatient(Paciente actualPatient) {
        this.actualPatient = actualPatient;
    }
}
