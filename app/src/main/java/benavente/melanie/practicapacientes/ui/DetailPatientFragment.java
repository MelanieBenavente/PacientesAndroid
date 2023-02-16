package benavente.melanie.practicapacientes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import benavente.melanie.practicapacientes.databinding.DetailPatientFragmentBinding;
import benavente.melanie.practicapacientes.domain.Patient;

public class DetailPatientFragment extends Fragment {
    //todo private Noseque binding
    private DetailPatientFragmentBinding binding;

    private PacienteViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DetailPatientFragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        configureView();
        initListeners();
    }

    private void initListeners() {
        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Patient patientModificado = new Patient(binding.nombrePaciente.getText().toString(),
                        Integer.valueOf(binding.edadPaciente.getText().toString()),
                        binding.checkboxEstado.isChecked(),
                        viewModel.getActualPatient().getValue().getId()

                );
                viewModel.modifyPatient(patientModificado);
                getActivity().onBackPressed();
            }
        });
    }
    private void configureView() {
        viewModel = ViewModelProviders.of(getActivity()).get(PacienteViewModel.class);

        final Observer<Patient> observer = new Observer<Patient>() {
            @Override
            public void onChanged(Patient paciente) {
                if (paciente != null) {

                    binding.nombrePaciente.setText(paciente.getName());
                    binding.edadPaciente.setText(String.valueOf(paciente.getAge()));
                    binding.checkboxEstado.setChecked(paciente.getStatus());
                }
            }
        };

        viewModel.getActualPatient().observe(getActivity(), observer);
    }


}
