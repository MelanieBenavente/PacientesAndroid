package benavente.melanie.practicapacientes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benavente.melanie.practicapacientes.R;

public class DetailPatientFragment extends Fragment {
    //todo private Noseque binding

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_patient_fragment, container, false);
        //todo binding = loquesea
        return rootView;
    }


}
