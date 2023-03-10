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

import benavente.melanie.practicapacientes.core.domain.Utils;
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
                //Instanciamos el viewModel
                configureView();
                initListeners();
                return view;
        }

        @Override
        public void onResume() {
                super.onResume();


        }
        private void configureView() {
                //En este caso no utilizamos el observer porque no hay que pintar datos en pantalla. Solamente nos aseguramos de que viewModel no sea nulo.
                viewModel = ViewModelProviders.of(getActivity()).get(PatientViewModel.class);

        }

        private void initListeners() {
                binding.anadirButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                //Programaci??n defensiva
                                //si el campo est?? vac??o
                                if (binding.editTextEdad.getText().toString().equals("")) {
                                        Toast.makeText(getContext(), "Debes introducir una edad", Toast.LENGTH_SHORT).show();
                                //si no est?? vac??o
                                //Fin programaci??n defensiva
                                } else if (binding.editTextNombre.getText().toString().equals("")) {
                                        Toast.makeText(getContext(), "Debes introducir un nombre", Toast.LENGTH_SHORT).show();
                                } else if (! Utils.isNumeric(binding.editTextEdad.getText().toString())) {
                                        Toast.makeText(getContext(), "El car??cter introducido debe ser un n??mero", Toast.LENGTH_SHORT).show();
                                } else if (Utils.isNumeric(binding.editTextNombre.getText().toString())) {
                                        Toast.makeText(getContext(), "El nombre no puede contener n??meros", Toast.LENGTH_SHORT).show();
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
}
