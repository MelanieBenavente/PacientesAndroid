package benavente.melanie.practicapacientes.ui;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import benavente.melanie.practicapacientes.R;
import benavente.melanie.practicapacientes.domain.Patient;

public class PacientesAdapter extends RecyclerView.Adapter<PacientesAdapter.ViewHolder> {
    private List<Patient> patients;
    private PatientItemInterface patientItemInterface;
    public PacientesAdapter(List<Patient> patients, PatientItemInterface patientItemInterface){
        this.patients = patients;
        this.patientItemInterface = patientItemInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.paciente_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Patient patientActual = patients.get(position);
        if (patientActual.getIngresado() == true){
            holder.textViewEstado.setText("Ingresado");
        } else {
            holder.textViewEstado.setText("No ingresado");
        }
        holder.textViewNombre.setText(patientActual.getName());
        holder.textViewEdad.setText(Integer.toString(patientActual.getEdad()));
        holder.buttonHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientItemInterface.showDetailPatient(patientActual);
            }
        });
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientItemInterface.deletePatient(patientActual);
            }
        });

        holder.buttonDuplicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientItemInterface.duplicatePatient(patientActual);
            }
        });
    }



    @Override
    public int getItemCount(){
    return patients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombre;
        TextView textViewEdad;
        TextView textViewEstado;
        Button buttonHistorial;
        Button buttonDelete;
        Button buttonDuplicate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.nombrePaciente);
            textViewEdad = itemView.findViewById(R.id.edadPaciente);
            textViewEstado = itemView.findViewById(R.id.estadoPaciente);
            buttonHistorial = itemView.findViewById(R.id.buttonHistorial);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            buttonDuplicate = itemView.findViewById(R.id.buttonDuplicate);
        }
    }
}
