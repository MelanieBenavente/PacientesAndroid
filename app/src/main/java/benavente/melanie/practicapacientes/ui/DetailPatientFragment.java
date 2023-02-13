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

import benavente.melanie.practicapacientes.R;
import benavente.melanie.practicapacientes.databinding.DetailPatientFragmentBinding;
import benavente.melanie.practicapacientes.databinding.MainListFragmentBinding;
import benavente.melanie.practicapacientes.domain.Paciente;

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
    }

    private void configureView() {
        viewModel = ViewModelProviders.of(getActivity()).get(PacienteViewModel.class);

        final Observer<Paciente> observer = new Observer<Paciente>() {
            @Override
            public void onChanged(Paciente paciente) {
                if (paciente != null) {

                    binding.nombrePaciente.setText(paciente.getNombre());
                    binding.edadPaciente.setText(String.valueOf(paciente.getEdad()));
                    binding.checkboxEstado.setChecked(paciente.getIngresado());
                }
            }
        };

        viewModel.getActualPatient().observe(getActivity(), observer);
    }


}
