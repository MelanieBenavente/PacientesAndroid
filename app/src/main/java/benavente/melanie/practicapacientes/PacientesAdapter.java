package benavente.melanie.practicapacientes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PacientesAdapter extends RecyclerView.Adapter<PacientesAdapter.ViewHolder> {
    private List<Paciente> pacientes;
    private PatientInterface patientInterface;
    public PacientesAdapter(List<Paciente> pacientes, PatientInterface patientInterface){
        this.pacientes= pacientes;
        this.patientInterface= patientInterface;
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
        Paciente pacienteActual = pacientes.get(position);
        if (pacienteActual.getIngresado() == true){
            holder.textViewEstado.setText("Ingresado");
        } else {
            holder.textViewEstado.setText("No ingresado");
        }
        holder.textViewNombre.setText(pacienteActual.getNombre());
        holder.textViewEdad.setText(Integer.toString(pacienteActual.getEdad()));
        holder.buttonHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Bienvenido al historial de" + pacienteActual.getNombre(), Toast.LENGTH_SHORT).show();
                patientInterface.showDetailPatient(pacienteActual);
            }
        });
    }


    @Override
    public int getItemCount(){
    return pacientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombre;
        TextView textViewEdad;
        TextView textViewEstado;
        Button buttonHistorial;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.nombrePaciente);
            textViewEdad = itemView.findViewById(R.id.edadPaciente);
            textViewEstado = itemView.findViewById(R.id.estadoPaciente);
            buttonHistorial = itemView.findViewById(R.id.buttonHistorial);
        }
    }
}
