import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class ProjectService {
    private ProjectRepository projectRepository;
    private AuthenticationService authService;

    public ProjectService(ProjectRepository projectRepository, AuthenticationService authService) {
        this.projectRepository = projectRepository;
        this.authService = authService;
    }

    public String addProject(Project project) {
        if (!authService.isUserLoggedIn()) {
            throw new IllegalStateException("User must be logged in to add a project");
        }

        validateProjectDetails(project);

        if (!projectRepository.isProjectNameUnique(project.getName(), LocalDate.now().getYear())) {
            throw new IllegalArgumentException("Project name must be unique for the current year");
        }

        projectRepository.addProject(project);
        return project.getProjectCode();
    }

    private void validateProjectDetails(Project project) {
        if (project.getEstimatedHours() < 200 || project.getEstimatedHours() > 300) {
            throw new IllegalArgumentException("Project hours must be between 200 and 300");
        }

        if (!isValidEmail(project.getProposerEmail())) {
            throw new IllegalArgumentException("Invalid email address");
        }

        // Add more validations as needed
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    public ProjectStatus getProjectStatus(String projectCode) {
        Project project = projectRepository.getProjectByCode(projectCode);
        if (project == null) {
            throw new IllegalArgumentException("Invalid project code");
        }
        return project.getStatus();
    }

    public String registerForProject(ProjectRegistration registration) {
        if (!authService.isUserLoggedIn()) {
            throw new IllegalStateException("User must be logged in to register for a project");
        }

        validateRegistrationDetails(registration);

        Project project = projectRepository.getProjectByCode(registration.getProjectCode());
        if (project == null || project.getStatus() != ProjectStatus.APPROVED) {
            throw new IllegalArgumentException("Project is not available for registration");
        }

        if (!checkProjectAvailability(project)) {
            throw new IllegalArgumentException("Project is already taken");
        }

        project.setStatus(ProjectStatus.IN_PROGRESS);
        return generateAccessCode();
    }

    private void validateRegistrationDetails(ProjectRegistration registration) {
        if (registration.getStudentIds().size() < 2) {
            throw new IllegalArgumentException("At least two students are required for registration");
        }

        for (Object studentId : registration.getStudentIds()) {
            if (!isValidStudentId((String) studentId)) {
                throw new IllegalArgumentException("Invalid student ID: " + studentId);
            }
        }

        // Add more validations as needed
    }

    private boolean isValidStudentId(String studentId) {
        // Implement student ID validation logic
        return studentId.matches("\\d{9}");  // Assuming 9-digit student IDs
    }

    private boolean checkProjectAvailability(Project project) {
        // Implement logic to check if the project is already taken
        return project.getStatus() == ProjectStatus.APPROVED;
    }

    private String generateAccessCode() {
        return UUID.randomUUID().toString();
    }

    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }
}
