package benavente.melanie.practicapacientes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements PatientInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new MainListFragment()).commit();

    }

    @Override
    public void showDetailPatient(Paciente paciente) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, DetailPatientFragment.class, null)
                .commit();
    }
}