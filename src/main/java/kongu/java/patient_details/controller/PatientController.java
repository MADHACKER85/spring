package kongu.java.patient_details.controller;

import kongu.java.patient_details.exception.ResourceNotFoundException;
import kongu.java.patient_details.entity.Patient;
import kongu.java.patient_details.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/details")
public class PatientController
{
    @Autowired
    private PatientRepository Repository;

    @GetMapping
    public List<Patient> getAllEmployees()
    {
        return Repository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Patient createEmployee(@RequestBody Patient employee)
    {
        return Repository.save(employee);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Patient> getEmployeeById(@PathVariable long id)
    {
        Patient employee=Repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping ("{id}")
    public ResponseEntity<Patient> updateEmployee(@PathVariable long id, @RequestBody Patient employeeDetails)
    {
        Patient updateEmployee = Repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with id: "+id));
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setAddress(employeeDetails.getAddress());
        updateEmployee.setAge(employeeDetails.getAge());

        Repository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    //build delete employee REST API
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
    {
        Patient employee = Repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+id));
        Repository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
