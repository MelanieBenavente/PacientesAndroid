package benavente.melanie.practicapacientes.ui.fragment;

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
import benavente.melanie.practicapacientes.domain.entity.Patient;
import benavente.melanie.practicapacientes.ui.activity.MainActivity;
import benavente.melanie.practicapacientes.ui.adapter.PatientItemInterface;
import benavente.melanie.practicapacientes.ui.adapter.PatientsAdapter;
import benavente.melanie.practicapacientes.ui.viewmodel.PatientViewModel;

public class MainListFragment extends Fragment implements PatientItemInterface {
    private MainListFragmentBinding binding;

    private PatientViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainListFragmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        configureView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


        binding.recyclerPaciente.setAdapter(new PatientsAdapter(viewModel.getpatientList().getValue(), this));
        binding.recyclerPaciente.setLayoutManager(new GridLayoutManager(getContext(), 3));
        binding.anadirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editTextEdad.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Debes de introducir una edad", Toast.LENGTH_SHORT).show();

                } else {
                viewModel.addPatient(new Patient(binding.editTextNombre.getText().toString(),
                        Integer.valueOf(binding.editTextEdad.getText().toString()),
                        binding.checkboxEstado.isChecked(),
                        viewModel.getpatientList().getValue().size()+1));
                    }
            }
        });

        binding.goToAddFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity)getActivity()).nextFragment(new AddPatientFragment());
            }
        });
    }
    private void configureView() {
        viewModel = ViewModelProviders.of(getActivity()).get(PatientViewModel.class);


        final Observer<List<Patient>> observer = new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                if (patients != null && binding.recyclerPaciente != null && binding.recyclerPaciente.getAdapter() != null){
                    binding.recyclerPaciente.getAdapter().notifyDataSetChanged();
                }
            }
        };

        viewModel.getpatientList().observe(getActivity(), observer);
    }

    @Override
    public void showDetailPatient(Patient patient) {
        viewModel.setActualPatient(patient);
        ((MainActivity)getActivity()).nextFragment(new DetailPatientFragment());
    }

    @Override
    public void deletePatient(Patient patient) {
        viewModel.deletePatient(patient);
    }

    @Override
    public void duplicatePatient(Patient nieto) {
        viewModel.addPatient(nieto);
        //binding.recyclerPaciente.getAdapter().notifyItemInserted(viewModel.getpacienteList().getValue().size()-1);
    }
}
