package benavente.melanie.practicapacientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.databinding.MainListFragmentBinding;

public class MainListFragment extends Fragment implements PatientItemInterface  {
    private MainListFragmentBinding binding;
    private List<Paciente> pacienteList= new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainListFragmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        pacienteList = new ArrayList<>();
        pacienteList.add(new Paciente("Paco", 15, true));
        pacienteList.add(new Paciente("Marc", 11, false));
        pacienteList.add(new Paciente("Toni", 10, true));
        pacienteList.add(new Paciente("Sara", 21, false));
        pacienteList.add(new Paciente("Alba", 71, true));
        pacienteList.add(new Paciente("Tona", 17, false));
        pacienteList.add(new Paciente("Lali", 22, false));

        binding.recyclerPaciente.setAdapter(new PacientesAdapter(pacienteList, this));
        binding.recyclerPaciente.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    public void showDetailPatient(Paciente paciente) {
        ((MainActivity)getActivity()).nextFragment(new DetailPatientFragment());
    }

    @Override
    public void deletePatient(Paciente paciente) {
        pacienteList.remove(paciente);
        binding.recyclerPaciente.getAdapter().notifyDataSetChanged();
    }
}
