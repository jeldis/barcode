package org.jeldis.barcode;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BarcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarcodeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

		return args -> {
			System.out.println("=========== BEAN ===============");

			String[] beanNames = ctx.getBeanDefinitionNames();

			Arrays.sort(beanNames);

			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

			System.out.println("================================");
		};
	}

	public class FileProcessingCommandLine implements ApplicationRunner {
		@Override
		public void run(ApplicationArguments applicationArguments) throws Exception {
			for (String filename : applicationArguments.getNonOptionArgs()) 
			   
			}
	}

}
