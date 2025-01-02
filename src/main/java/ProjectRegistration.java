import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProjectRegistration {
    private String projectCode;
    private List<String> studentIds;
    private String academicAdvisor;

    public ProjectRegistration(String projectCode, List<String> studentIds, String academicAdvisor) {
        this.projectCode = projectCode;
        this.studentIds = studentIds;
        this.academicAdvisor = academicAdvisor;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public Collection<Object> getStudentIds() {
        return Collections.singleton(studentIds);
    }

    // Getters and setters
    // ...
}
