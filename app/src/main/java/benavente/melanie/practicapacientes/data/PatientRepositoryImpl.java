package benavente.melanie.practicapacientes.data;

import java.util.ArrayList;
import java.util.List;

import benavente.melanie.practicapacientes.domain.entity.Patient;
import benavente.melanie.practicapacientes.domain.repository.PatientRepository;

public class PatientRepositoryImpl implements PatientRepository {
    private List<Patient> patientList;
    @Override
    public List<Patient> mockList() {
        patientList = new ArrayList<>();
        patientList.add(new Patient("Paco", 19, true, 1));
        patientList.add(new Patient("Marc", 11, false,2));
        patientList.add(new Patient("Toni", 10, true, 3));
        patientList.add(new Patient("Sara", 21, false,4));
        patientList.add(new Patient("Alba", 71, true, 5));
        patientList.add(new Patient("Tona", 17, false,6));
        patientList.add(new Patient("Lali", 18, false,7));
        return patientList;
    }

    @Override
    public List<Patient> deletePatient(Patient patient) {
        patientList.remove(patient);
        return patientList;
    }

    @Override
    public List<Patient> modifyPatient(Patient patient) {
        List<Patient> temporaryList = patientList;
        for (int i = 0; i < patientList.size(); i++)
        {
            if (patient.getId() == patientList.get(i).getId()) {
                temporaryList.remove(i);
                temporaryList.add(i, patient);
            }
        }
        patientList = temporaryList;
        return patientList;
    }

    @Override
    public List<Patient> addPatient(Patient patient) {
        patientList.add(patient);
        return patientList;
    }
}
