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
        p1.setTitle("Social App");
        p1.setDescription("A full stack social platform built with Spring Boot and React. " +
                "Includes authentication and authorization with Spring Security, a PostgreSQL database on Neon," +
                " and a production deployment on Koyeb using environment variables..");
        p1.setFeatured(true);
        p1.setTechStack("Java, Spring Boot, Spring Security, REST API, PostgreSQL (Neon), React, JavaScript, CSS, Docker, Koyeb, Environment Variables");
        p1.setCategory("Cloud");
        p1.setRepoUrl("https://github.com/danielasilva92/social-app");
        p1.setDemoUrl("https://musical-polly-skiessss-083e1a67.koyeb.app/login");
        p1.setImageUrl("");

        Project p2 = new Project();
        p2.setTitle("Java Chat Application");
        p2.setDescription("A desktop chat application built in Java with a JavaFX user interface. " +
                "Focused on clean architecture, user friendly interaction, and real time messaging concepts.");
        p2.setCategory("Java");
        p2.setTechStack("Java, JavaFX, Clean Architecture, OOP, UI design, Real Time Messaging");
        p2.setRepoUrl("https://github.com/danielasilva92/ChatApp");
        p2.setImageUrl("");

        Project p3 = new Project();
        p3.setTitle("Danielas Booktook");
        p3.setDescription("IN PROGRESS........ ");
        p3.setCategory("Web");

        Project p4 = new Project();
        p4.setTitle("AWS Cloud Mini Project");
        p4.setDescription("IN PROGRESS........ ");
        p4.setCategory("Cloud");

        repo.save(p1);
        repo.save(p2);
        repo.save(p3);
        repo.save(p4);
    }
}