package RecS;

import RecS.MongoReps.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Cse364ProjectApplication{

	public static void main(String[] args){
		SpringApplication.run(Cse364ProjectApplication.class, args);
	}
}
