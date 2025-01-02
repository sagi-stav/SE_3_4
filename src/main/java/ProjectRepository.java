import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    private List<Project> projects = new ArrayList<>();

    public void addProject(Project project) {
        projects.add(project);
    }

    public Project getProjectByCode(String projectCode) {
        return projects.stream()
                .filter(p -> p.getProjectCode().equals(projectCode))
                .findFirst()
                .orElse(null);
    }

    public boolean isProjectNameUnique(String name, int year) {
        return projects.stream()
                .noneMatch(p -> p.getName().equals(name) && p.getCreationDate().getYear() == year);
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }
}
