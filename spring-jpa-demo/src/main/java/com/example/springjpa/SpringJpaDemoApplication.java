package com.example.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.springjpa.entity.Employee;
import com.example.springjpa.repository.StudentRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}
	@Autowired
	private StudentRepository sr;
	
	@Override
	public void run(String... args) throws Exception {
		Employee s=new Employee();
		
		s.setName("Jyothi");
		s.setAddress("Hyderabad");
		sr.save(s);
		
		 // Read Operation (Retrieve by ID)
        int employeeId =3; // Replace with the actual ID
        Employee retrievedEmployee = sr.findById(employeeId).orElse(null);
        if (retrievedEmployee != null) {
            System.out.println("Retrieved Employee: " + retrievedEmployee.getName() + ", " + retrievedEmployee.getAddress());
        } else {
            System.out.println("Employee not found");
        }
        
        // Update Operation
        if (retrievedEmployee != null) {
            retrievedEmployee.setName("Vinay");
            sr.save(retrievedEmployee);
            System.out.println("Employee updated");
        }
        
        // Delete Operation
        if (retrievedEmployee != null) {
            sr.delete(retrievedEmployee);
            System.out.println("Employee deleted");
        }
		
	}

}
