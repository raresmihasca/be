package fortech.team2.VeterinaryClinicBE.services.impl;

import fortech.team2.VeterinaryClinicBE.entities.Patient;
import fortech.team2.VeterinaryClinicBE.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;
    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }
    public List<Patient> searchPatientsByName(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Patient> searchPatientsByType(String type) {
        return patientRepository.findByTypeIgnoreCase(type);
    }

    @Override
    public List<Patient> searchPatientsByBreed(String breed) {
        return patientRepository.findByBreedIgnoreCase(breed);
    }
    @Override
    public List<Patient> searchPatientsBySex(String sex) {
        return patientRepository.findBySexIgnoreCase(sex);
    }

    @Override
    public List<Patient> searchPatientsByColor(String color) {
        return patientRepository.findByColorIgnoreCase(color);
    }

    @Override
    public List<Patient> getPatientsBetweenAges(int minAge, int maxAge) {
        LocalDate currentDate = LocalDate.now();
        LocalDate minBirthDate = currentDate.minusYears(maxAge);
        LocalDate maxBirthDate = currentDate.minusYears(minAge);

        return patientRepository.findByBirthDateBetween(minBirthDate, maxBirthDate);
    }

    @Override
    public List<Patient> getPatientsBetweenWeights(float minWeight, float maxWeight) {
        return patientRepository.findByWeightBetween(minWeight, maxWeight);
    }
}
