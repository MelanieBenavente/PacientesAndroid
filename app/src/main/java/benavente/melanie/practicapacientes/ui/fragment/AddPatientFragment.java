package benavente.melanie.practicapacientes.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benavente.melanie.practicapacientes.databinding.AddPatientFragmentBinding;

public class AddPatientFragment extends Fragment {

        private AddPatientFragmentBinding binding;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                binding = AddPatientFragmentBinding.inflate(getLayoutInflater());
                View view = binding.getRoot();
                return view;
        }

}
