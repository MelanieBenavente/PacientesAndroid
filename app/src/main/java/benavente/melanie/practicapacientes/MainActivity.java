package benavente.melanie.practicapacientes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements PatientInterface{
    private ActivityMainBinding binding;
    private List<Paciente> pacienteList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //mockeo de datos

        pacienteList.add(new Paciente("Paco", 15, true));
        pacienteList.add(new Paciente("Marc", 11, false));
        pacienteList.add(new Paciente("Toni", 10, true));
        pacienteList.add(new Paciente("Sara", 21, false));
        pacienteList.add(new Paciente("Alba", 71, true));
        pacienteList.add(new Paciente("Tona", 17, false));
        pacienteList.add(new Paciente("Lali", 22, false));

        binding.recyclerPaciente.setAdapter(new PacientesAdapter(pacienteList, this));
        binding.recyclerPaciente.setLayoutManager(new GridLayoutManager(this, 3));


    }

    @Override
    public void showDetailPatient(Paciente paciente) {
        binding.nombre.setText("hola " + paciente.getNombre());
    }
}