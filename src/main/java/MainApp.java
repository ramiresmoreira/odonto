import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.port;
import static spark.Spark.post;

import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.Gson;

import br.edu.ifce.odonto.controllers.DiscenteController;

public class MainApp {

	private static DiscenteController discenteController = new DiscenteController();
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		port(getHerokuAssignedPort());
		ProcessBuilder processBuilder = new ProcessBuilder();
		String url = processBuilder.environment().get("JDBC_DATABASE_URL");
		try {
			URI dbURl = new URI(url);
		} catch (URISyntaxException | NullPointerException e) {
			System.out.println("rodando local");
		}
		
		path("/api/", ()->{
			path("/paciente/", ()->{
				get("/",(req,resp)->discenteController.getAll(),gson::toJson);
				get(":id",(req,resp)-> discenteController.get(req, resp),gson::toJson);
				post("/add", (req, resp) -> discenteController.addUser(req, resp), gson::toJson);
			});
		});
		
		path("/api/", ()->{
			get("/outro",(req,resp)->"So um exemplo",gson::toJson);
		});
		
		after((req,resp)->resp.header("Content-Encondig", "gzip"));
	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			int PORT = Integer.parseInt(processBuilder.environment().get("PORT"));
			return PORT;
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on
						// localhost)
	}

}
