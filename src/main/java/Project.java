import java.time.LocalDate;
import java.util.UUID;

public class Project {
    private String name;
    private String description;
    private int estimatedHours;
    private String proposerName;
    private String proposerEmail;
    private String proposerPhone;
    private String proposerOrganization;
    private LocalDate creationDate;
    private String projectCode;
    private ProjectStatus status;

    public Project(String name, String description, int estimatedHours, String proposerName,
                   String proposerEmail, String proposerPhone, String proposerOrganization) {
        this.name = name;
        this.description = description;
        this.estimatedHours = estimatedHours;
        this.proposerName = proposerName;
        this.proposerEmail = proposerEmail;
        this.proposerPhone = proposerPhone;
        this.proposerOrganization = proposerOrganization;
        this.creationDate = LocalDate.now();
        this.projectCode = generateProjectCode();
        this.status = ProjectStatus.UNDER_REVIEW;
    }

    private String generateProjectCode() {
        return UUID.randomUUID().toString();
    }

    // Getters and setters for all fields
    // ...

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public String getProposerEmail() {
        return proposerEmail;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}

