package bridgeProject;

import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;
import businessLogic.ProjectManagementService;

public class RealBridge implements BridgeProject {
    private ProjectManagementService service = new ProjectManagementService();

    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        service.registerNewTechnicalAdviser(user, password);
    }

    @Override
    public void addNewStudent(String user, String password) {
        service.addNewStudent(user, password);
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        return service.addNewProject(user, pass, suggestedProject);
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        return service.registerToProject(user, pass, registeredProject);
    }
}