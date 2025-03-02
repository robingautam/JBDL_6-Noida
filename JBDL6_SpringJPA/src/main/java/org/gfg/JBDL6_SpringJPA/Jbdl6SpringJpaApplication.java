package org.gfg.JBDL6_SpringJPA;

import org.gfg.JBDL6_SpringJPA.mapping.Laptop;
import org.gfg.JBDL6_SpringJPA.mapping.LaptopRepository;
import org.gfg.JBDL6_SpringJPA.mapping.Student;
import org.gfg.JBDL6_SpringJPA.mapping.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Jbdl6SpringJpaApplication implements CommandLineRunner{

	@Autowired
	PersonRepositoy personRepositoy;
	@Autowired
	LaptopRepository laptopRepository;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Jbdl6SpringJpaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/*Person person = new Person("Aakash","Aakash@gmail.com");
		person.setAddress(new Address("M.v","110091"));
		personRepositoy.save(person);
		System.out.println("data saved");
		//Person person1 = personRepositoy.findById(1).get();
		//System.out.println(person1);
	//	personRepositoy.deleteById(1);
	//	personRepositoy.deleteById(2);
//		System.out.println("Data deleted");*/

		// Mapping



		Student student = new Student(1,"Robin","robin@gmail.com");
		Laptop HP = new Laptop(1001,"HP");
		Laptop dell = new Laptop(1002,"DELL");
		// One to One Example
		/*student.setLaptop(HP);

		laptopRepository.save(HP);
		laptopRepository.save(dell);

		studentRepository.save(student);

		System.out.println("Data saved");*/

		// One to Many Example
	/*	student.setLaptop(Arrays.asList(HP,dell));

		laptopRepository.save(HP);
		laptopRepository.save(dell);

		studentRepository.save(student);

		System.out.println("data saved");*/

		// Many to One Example

		//student.setLaptop(Arrays.asList(HP,dell));
		HP.setStudent(student);
		dell.setStudent(student);

		studentRepository.save(student);

		laptopRepository.save(HP);
		laptopRepository.save(dell);









		System.out.println("Data saved");



	}
}
