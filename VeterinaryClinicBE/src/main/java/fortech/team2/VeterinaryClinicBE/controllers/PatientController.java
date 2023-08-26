package fortech.team2.VeterinaryClinicBE.controllers;

import fortech.team2.VeterinaryClinicBE.entities.Patient;
import fortech.team2.VeterinaryClinicBE.repositories.PatientRepository;
import fortech.team2.VeterinaryClinicBE.services.impl.PatientService;
import fortech.team2.VeterinaryClinicBE.services.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping
public class PatientController {

    @Autowired
    PatientServiceImpl patientServiceImpl;

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    List<Patient> getPatients(){

        return patientServiceImpl.getPatients();

    }

    @GetMapping("/patients/{id}")
    public Patient getPatientDetails(@PathVariable Integer id) {
        return patientServiceImpl.getPatientById(id);
    }

    @GetMapping("/patients/search")
    List<Patient> searchPatients(@RequestParam String searchTerm) {
        return patientServiceImpl.searchPatientsByName(searchTerm);
    }

    @GetMapping("/type")
    List<String> getPatientTypes() {
        return patientRepository.findDistinctTypes();
    }
    @GetMapping("/breed")
    List<String> getPatientBreeds() {
        return patientRepository.findDistinctBreeds();
    }
    @GetMapping("/sex")
    List<String> getPatientSexes() {
        return patientRepository.findDistinctSexes();
    }
    @GetMapping("/color")
    List<String> getPatientColors() {
        return patientRepository.findDistinctColors();
    }


}
