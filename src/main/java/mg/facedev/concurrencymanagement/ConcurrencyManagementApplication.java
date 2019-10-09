package mg.facedev.concurrencymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import mg.facedev.concurrencymanagement.config.MyConfig;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@Import(MyConfig.class)
public class ConcurrencyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyManagementApplication.class, args);
	}

}
