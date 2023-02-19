package benavente.melanie.practicapacientes.ui.adapter;


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
import benavente.melanie.practicapacientes.domain.entity.Patient;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.ViewHolder> {
    private List<Patient> patients;
    private PatientItemInterface patientItemInterface;
    public PatientsAdapter(List<Patient> patients, PatientItemInterface patientItemInterface){
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
        Patient actualPatient = patients.get(position);
        if (actualPatient.getStatus() == true){
            holder.textViewStatus.setText("Ingresado");
        } else {
            holder.textViewStatus.setText("No ingresado");
        }
        if (!actualPatient.isAdult()) {
            holder.textViewisNotAdult.setVisibility(View.VISIBLE);
        } else {
            holder.textViewisNotAdult.setVisibility(View.INVISIBLE);
        }
        holder.textViewName.setText(actualPatient.getName());
        holder.textViewAge.setText(Integer.toString(actualPatient.getAge()));
        holder.buttonHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientItemInterface.goToDetailPatient(actualPatient);
            }
        });
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientItemInterface.deletePatient(actualPatient);
            }
        });

        holder.buttonDuplicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientItemInterface.duplicatePatient(actualPatient);
            }
        });
    }



    @Override
    public int getItemCount(){
    return patients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewAge;
        TextView textViewStatus;
        Button buttonHistorial;
        Button buttonDelete;
        Button buttonDuplicate;
        TextView textViewisNotAdult;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.nombrePaciente);
            textViewAge = itemView.findViewById(R.id.edadPaciente);
            textViewStatus = itemView.findViewById(R.id.estadoPaciente);
            textViewisNotAdult = itemView.findViewById(R.id.isNotAdult);
            buttonHistorial = itemView.findViewById(R.id.buttonHistorial);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            buttonDuplicate = itemView.findViewById(R.id.buttonDuplicate);

        }
    }
}
