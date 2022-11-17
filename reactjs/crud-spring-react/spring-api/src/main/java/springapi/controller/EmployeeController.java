package springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springapi.enlity.Employee;
import springapi.repository.EmployeeRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = employeeRepository.findById(id).orElse(null);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeRepository.findById(employee.getId()).orElse(null);
        employeeRepository.save(employee1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEm(@PathVariable Long id){

         employeeRepository.deleteById(id);
    }
}
