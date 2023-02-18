package benavente.melanie.practicapacientes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import benavente.melanie.practicapacientes.R;
import benavente.melanie.practicapacientes.ui.fragment.MainListFragment;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new MainListFragment()).commit();

    }

    public void nextFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment, null)
                .addToBackStack(fragment.getTag())
                .commit();
    }




}