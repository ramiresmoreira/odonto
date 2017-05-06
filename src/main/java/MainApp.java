import static spark.Spark.*;

public class MainApp {

	public static void main(String[] args) {
        port(getHerokuAssignedPort());
        ProcessBuilder processBuilder = new ProcessBuilder();
        String url = processBuilder.environment().get("JDBC_DATABASE_URL");
        get("/hello", (req, res) -> "Hello Heroku World "+url);
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
