package br.com.alura.screensound_java;

import br.com.alura.screensound_java.principal.Principal;
import br.com.alura.screensound_java.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundJavaApplication implements CommandLineRunner {

    @Autowired
private ArtistaRepository repositorio;
	public static void main(String[] args) {
		SpringApplication.run(ScreensoundJavaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(repositorio);
        principal.exibeMenu();
    }
}
