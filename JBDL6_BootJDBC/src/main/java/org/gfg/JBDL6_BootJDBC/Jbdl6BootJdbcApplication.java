package org.gfg.JBDL6_BootJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Jbdl6BootJdbcApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Jbdl6BootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create data in database
		/*int rows = jdbcTemplate.update("insert into student values (?,?,?)",2,"Aakash","aakash@gmail.com");
		System.out.println("Rows Updated: "+rows);*/

		// Read data from database
		/* Student student = jdbcTemplate.query("select * from student where id=2",new RowMapperImpl()).get(0);

		System.out.println(student);*/

		// Updating the data
		/*int rows = jdbcTemplate.update("update student set email=? where id=?","aakash.new@gmail.com",2);
		System.out.println("Rows Updated: "+rows);*/

		// deleting the data
		/*int rows = jdbcTemplate.update("delete from student where id=?",2);
		System.out.println("Rows Updated: "+rows);*/





	}
}
