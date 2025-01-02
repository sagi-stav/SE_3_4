public class AuthenticationService {
    private boolean userLoggedIn = false;

    public void login(String username, String password) {
        // Implement login logic
        userLoggedIn = true;
    }

    public void logout() {
        userLoggedIn = false;
    }

    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }
}
