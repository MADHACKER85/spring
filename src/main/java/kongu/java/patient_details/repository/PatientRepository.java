package kongu.java.patient_details.repository;

import kongu.java.patient_details.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient,Long>
{
    //all crud database methods

}
