package se.jensen.daniela.portfoilo2026.project;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    public List<Project> list() {
        return repo.findAll().stream()
                .sorted((a, b) -> {
                    if (a.isFeatured() != b.isFeatured()) {
                        return b.isFeatured() ? 1 : -1; // featured först
                    }
                    return b.getCreatedAt().compareTo(a.getCreatedAt());
                })
                .toList();
    }


    public Project get(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Project not found: " + id));
    }

    public Project create(Project p) {
        p.setId(null);
        return repo.save(p);
    }

    @Transactional
    public Project update(Long id, Project patch) {
        Project existing = get(id);
        existing.setTitle(patch.getTitle());
        existing.setDescription(patch.getDescription());
        existing.setCategory(patch.getCategory());
        existing.setRepoUrl(patch.getRepoUrl());
        existing.setDemoUrl(patch.getDemoUrl());
        existing.setImageUrl(patch.getImageUrl());
        return existing;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}