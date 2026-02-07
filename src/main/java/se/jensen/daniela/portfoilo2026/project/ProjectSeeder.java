package se.jensen.daniela.portfoilo2026.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProjectSeeder implements CommandLineRunner {

    private final ProjectRepository repo;

    public ProjectSeeder(ProjectRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() > 0) return;

        Project p1 = new Project();
        p1.setTitle("AWS Cloud Mini Project");
        p1.setDescription("Ett projekt som visar cloud koncept och deployment.");
        p1.setCategory("Cloud");
        p1.setRepoUrl("https://github.com/yourname/aws-mini-project");
        p1.setDemoUrl("");
        p1.setImageUrl("");

        Project p2 = new Project();
        p2.setTitle("Java Backend API");
        p2.setDescription("REST API byggt med Spring Boot, JPA och validering.");
        p2.setCategory("Java");
        p2.setRepoUrl("https://github.com/yourname/java-api");
        p2.setImageUrl("");

        repo.save(p1);
        repo.save(p2);
    }
}