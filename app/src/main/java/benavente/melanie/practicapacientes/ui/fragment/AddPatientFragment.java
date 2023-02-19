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

import benavente.melanie.practicapacientes.databinding.AddPatientFragmentBinding;
import benavente.melanie.practicapacientes.domain.entity.Patient;
import benavente.melanie.practicapacientes.ui.activity.MainActivity;
import benavente.melanie.practicapacientes.ui.adapter.PatientsAdapter;
import benavente.melanie.practicapacientes.ui.viewmodel.PatientViewModel;

public class AddPatientFragment extends Fragment {

        private AddPatientFragmentBinding binding;

        private PatientViewModel viewModel;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                binding = AddPatientFragmentBinding.inflate(getLayoutInflater());
                View view = binding.getRoot();
                configureView();
                return view;
        }

        @Override
        public void onResume() {
                super.onResume();

        binding.anadirButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                        //si el campo está vacío
                        if (binding.editTextEdad.getText().toString().equals("")) {
                                Toast.makeText(getContext(), "Debes introducir una edad", Toast.LENGTH_SHORT).show();
                         //si no está vacío
                        } else {
                        viewModel.addPatient(new Patient(binding.editTextNombre.getText().toString(),
                                Integer.valueOf(binding.editTextEdad.getText().toString()),
                                binding.checkboxEstado.isChecked(),
                                viewModel.getpatientList().getValue().size()+1));
                                getActivity().onBackPressed();
                        }

                }

        });
        }
        private void configureView() {
                viewModel = ViewModelProviders.of(getActivity()).get(PatientViewModel.class);

        }


}
