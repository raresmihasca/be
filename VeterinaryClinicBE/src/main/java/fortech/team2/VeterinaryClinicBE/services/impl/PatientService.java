package fortech.team2.VeterinaryClinicBE.services.impl;

import fortech.team2.VeterinaryClinicBE.entities.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {

    public List<Patient> getPatients();

    public Patient getPatientById(Integer id);

    public List<Patient> searchPatientsByType(String type);
    public List<Patient> searchPatientsByBreed(String breed);
    public List<Patient> searchPatientsBySex(String type);
    public List<Patient> searchPatientsByColor(String breed);
    public List<Patient> getPatientsBetweenAges(int minAge, int maxAge);
    public List<Patient> getPatientsBetweenWeights(float minWeight, float maxWeight);
}
