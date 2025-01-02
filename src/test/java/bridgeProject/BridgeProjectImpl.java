package bridgeProject;

import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

public class BridgeProjectImpl implements BridgeProject {

    // You may need to add fields here to manage your system state
    // For example:
    // private ProjectManager projectManager;
    // private UserManager userManager;

    public BridgeProjectImpl() {
        // Initialize your system components here
        // For example:
        // projectManager = new ProjectManager();
        // userManager = new UserManager();
    }

    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        // Implement the logic to register a new technical adviser
        // For example:
        // userManager.registerTechnicalAdviser(user, password);
    }

    @Override
    public void addNewStudent(String user, String password) {
        // Implement the logic to add a new student
        // For example:
        // userManager.addStudent(user, password);
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        // Implement the logic to add a new project
        // For example:
        // return projectManager.addProject(user, pass, suggestedProject);
        return 0;
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        // Implement the logic to register a student team to a project
        // For example:
        // return projectManager.registerTeamToProject(user, pass, registeredProject);
        return 0;
    }
}
