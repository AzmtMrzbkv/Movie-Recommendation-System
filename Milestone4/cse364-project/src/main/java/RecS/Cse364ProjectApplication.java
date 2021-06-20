package RecS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cse364ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cse364ProjectApplication.class, args);
	}

}

@RestController
public class TomcatController {

    @GetMapping("/hello")
    public Collection<String> sayHello() {
        return IntStream.range(0, 10)
          .mapToObj(i -> "Hello number " + i)
          .collect(Collectors.toList());
    }
}
