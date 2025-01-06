package businessLogic;

import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectManagementService {
    private Map<String, String> users = new HashMap<>(); // username -> password
    private Map<String, String> students = new HashMap<>(); // student username -> password
    private List<DBSuggestedProjectInfo> projects = new ArrayList<>();
    private List<DBRegisteredProjectInfo> registrations = new ArrayList<>();

    public void registerNewTechnicalAdviser(String user, String password) {
        users.put(user, password);
    }

    public void addNewStudent(String user, String password) {
        students.put(user, password);
    }

    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        // Validate user credentials
        if (!users.containsKey(user) || !users.get(user).equals(pass)) {
            return 0;
        }

        // Validate mandatory fields
        if (suggestedProject.firstName == null || suggestedProject.firstName.isEmpty() ||
                suggestedProject.lastName == null || suggestedProject.lastName.isEmpty() ||
                suggestedProject.email == null || suggestedProject.email.isEmpty() ||
                suggestedProject.projectName == null || suggestedProject.projectName.isEmpty() ||
                suggestedProject.phone == null || suggestedProject.phone.isEmpty()) { // הוספנו בדיקה לטלפון
            return 0;
        }

        // Validate number of hours
        if (suggestedProject.numberOfHours < 200 || suggestedProject.numberOfHours > 300) {
            return 0;
        }

        // Validate unique project name for the same organization and year
        for (DBSuggestedProjectInfo project : projects) {
            if (project.projectName.equals(suggestedProject.projectName) &&
                    project.organization.equals(suggestedProject.organization)) {
                return 0;
            }
        }

        // Add the project
        projects.add(suggestedProject);
        return projects.size(); // Return project ID
    }

    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        // Validate student credentials
        if (!students.containsKey(user) || !students.get(user).equals(pass)) {
            return 0;
        }

        // Validate at least two students
        if (registeredProject.studentList.size() < 2) {
            return 0;
        }

        // Validate academic adviser
        if (registeredProject.academicAdviser == null || registeredProject.academicAdviser.isEmpty()) {
            return 0;
        }

        // Validate project is not already registered
        for (DBRegisteredProjectInfo registration : registrations) {
            if (registration.projectId == registeredProject.projectId) {
                return 0;
            }
        }

        // Register the project
        registrations.add(registeredProject);
        return registrations.size(); // Return registration ID
    }
}