package benavente.melanie.practicapacientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PatientItemInterface {

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