package benavente.melanie.practicapacientes.ui.fragment;

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
import benavente.melanie.practicapacientes.domain.entity.Patient;
import benavente.melanie.practicapacientes.ui.viewmodel.PatientViewModel;

public class DetailPatientFragment extends Fragment {

    private DetailPatientFragmentBinding binding;

    private PatientViewModel viewModel;

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
                Patient modifiedPatient = new Patient(binding.patientNameET.getText().toString(),
                        Integer.valueOf(binding.edadPaciente.getText().toString()),
                        binding.checkboxEstado.isChecked(),
                        viewModel.getActualPatient().getValue().getId()

                );
                viewModel.modifyPatient(modifiedPatient);
                getActivity().onBackPressed();
            }
        });
    }
    private void configureView() {
        viewModel = ViewModelProviders.of(getActivity()).get(PatientViewModel.class);

        final Observer<Patient> observer = new Observer<Patient>() {
            @Override
            public void onChanged(Patient patient) {
                if (patient != null) {

                    binding.patientNameET.setText(patient.getName());
                    binding.edadPaciente.setText(String.valueOf(patient.getAge()));
                    binding.checkboxEstado.setChecked(patient.getStatus());
                }
            }
        };

        viewModel.getActualPatient().observe(getActivity(), observer);
    }


}
