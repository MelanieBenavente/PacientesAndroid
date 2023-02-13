package benavente.melanie.practicapacientes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benavente.melanie.practicapacientes.R;
import benavente.melanie.practicapacientes.databinding.DetailPatientFragmentBinding;
import benavente.melanie.practicapacientes.databinding.MainListFragmentBinding;

public class DetailPatientFragment extends Fragment {
    //todo private Noseque binding
    private DetailPatientFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DetailPatientFragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


}
