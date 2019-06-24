package ui.driver;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}