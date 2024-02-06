package kongu.java.patient_details;

import kongu.java.patient_details.entity.Patient;
import kongu.java.patient_details.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientDetailsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PatientDetailsApplication.class, args);
	}


	@Autowired
	private PatientRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		Patient employee =new Patient();
		employee.setName("Ramesh");
		employee.setAddress("Fadatare");
		employee.setAge(44);
		employeeRepository.save(employee);

		Patient employee1 =new Patient();
		employee1.setName("John");
		employee1.setAddress("Cena");
		employee1.setAge(22);
		employeeRepository.save(employee1);
	}
}
