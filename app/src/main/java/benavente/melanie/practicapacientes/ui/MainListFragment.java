package benavente.melanie.practicapacientes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.List;

import benavente.melanie.practicapacientes.databinding.MainListFragmentBinding;
import benavente.melanie.practicapacientes.domain.Paciente;

public class MainListFragment extends Fragment implements PatientItemInterface  {
    private MainListFragmentBinding binding;

    private PacienteViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainListFragmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        configureView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();


        binding.recyclerPaciente.setAdapter(new PacientesAdapter(viewModel.getpacienteList().getValue(), this));
        binding.recyclerPaciente.setLayoutManager(new GridLayoutManager(getContext(), 3));
        binding.anadirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editTextEdad.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Debes de introducir una edad", Toast.LENGTH_SHORT).show();

                } else {
                viewModel.addPaciente(new Paciente(binding.editTextNombre.getText().toString(), Integer.valueOf(binding.editTextEdad.getText().toString()), binding.checkboxEstado.isChecked()));
                binding.recyclerPaciente.getAdapter().notifyItemInserted(viewModel.getpacienteList().getValue().size()-1);}
            }
        });
    }
    private void configureView() {
        viewModel = ViewModelProviders.of(this).get(PacienteViewModel.class);


        final Observer<List<Paciente>> observer = new Observer<List<Paciente>>() {
            @Override
            public void onChanged(List<Paciente> pacientes) {
                //todo actualizarrecyclerview
            }
        };

        viewModel.getpacienteList().observe(getActivity(), observer);
    }

    @Override
    public void showDetailPatient(Paciente paciente) {
        ((MainActivity)getActivity()).nextFragment(new DetailPatientFragment());
    }

    @Override
    public void deletePatient(Paciente paciente) {
        viewModel.deletePaciente(paciente);
        binding.recyclerPaciente.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void duplicatePatient(Paciente paciente) {
        viewModel.addPaciente(paciente);
        binding.recyclerPaciente.getAdapter().notifyItemInserted(viewModel.getpacienteList().getValue().size()-1);

    }
}
