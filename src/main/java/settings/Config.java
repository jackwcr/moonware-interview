package settings;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private Dotenv dotenv;

    public Config() {
        dotenv = Dotenv.load(); // Load the .env file
    }

    public String getEmail() {
        return dotenv.get("EMAIL");
    }

    public String getPassword() {
        return dotenv.get("PASSWORD"); // Access the password
    }

}
