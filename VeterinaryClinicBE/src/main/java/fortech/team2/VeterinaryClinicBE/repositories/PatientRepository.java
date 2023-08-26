package fortech.team2.VeterinaryClinicBE.repositories;

import fortech.team2.VeterinaryClinicBE.entities.Patient;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByNameContainingIgnoreCase(String name);

    @Query("SELECT DISTINCT p.type FROM Patient p")
    List<String> findDistinctTypes();
    @Query("SELECT DISTINCT p.breed FROM Patient p")
    List<String> findDistinctBreeds();
    @Query("SELECT DISTINCT p.sex FROM Patient p")
    List<String> findDistinctSexes();
    @Query("SELECT DISTINCT p.color FROM Patient p")
    List<String> findDistinctColors();

    List<Patient> findByTypeIgnoreCase(String type);
    List<Patient> findByBreedIgnoreCase(String breed);
    List<Patient> findBySexIgnoreCase(String type);
    List<Patient> findByColorIgnoreCase(String breed);
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByWeightBetween(float minWeight, float maxWeight);
}