package App;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.port;
import static spark.Spark.post;

import java.net.URI;
import java.net.URISyntaxException;

import org.hibernate.Session;

import com.google.gson.Gson;

import br.edu.ifce.odonto.controllers.AgendamentoController;
import br.edu.ifce.odonto.controllers.DentistaController;
import br.edu.ifce.odonto.controllers.DiscenteController;
import br.edu.ifce.odonto.util.GsonUtil;
import br.edu.ifce.odonto.util.HibernateUtil;
import spark.Spark;

public class MainApp {

	private static DiscenteController discenteController = new DiscenteController();
	private static DentistaController dentistaController = new DentistaController();
	private static Gson gson = GsonUtil.getGson();
	private static Session session;

	public static void main(String[] args) {
		port(getHerokuAssignedPort());
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			String url = processBuilder.environment().get("DATABASE_URL");
			URI dbURl = new URI(url);
//			URI dbURl = new URI("jdbc:postgresql://mwvunzpjqtqwse:fdf5514aaf8c2ca203603a14c57dd9c6aa7cde9b5cf30b4cb2af124e8537f265@ec2-23-23-111-171.compute-1.amazonaws.com:5432/d9duj1m1po4a03");
			String[] userInfo = dbURl.getUserInfo().split(":");
			session = HibernateUtil.openSession(dbURl.getHost(), dbURl.getPort(), dbURl.getPath(), userInfo[0],
					userInfo[1]);
		} catch (URISyntaxException | NullPointerException e) {
			session = HibernateUtil.openSession("localhost", 5432, "/odonto", "postgres", "R@mireswin120210");
			System.out.println("rodando local");
		}

		path("/api/", () -> {
			path("/paciente/", () -> {
				get("/","application/json",  (req, resp) -> discenteController.getAll(), gson::toJson);
				get(":id", (req, resp) -> discenteController.get(req, resp), gson::toJson);
				post("/add", (req, resp) -> discenteController.addUser(req, resp), gson::toJson);
			});
		});

		path("/api/", () -> {
			path("/dentista/", () -> {
				get("/","application/json",  (req, resp) -> dentistaController.getAll(), gson::toJson);
				get(":id","application/json",  (req, resp) -> dentistaController.get(req,resp), gson::toJson);
				post("/add", (req, resp) -> dentistaController.addDentista(req, resp), gson::toJson);
			});
		});
		
		path("/api/", () -> {
			path("/agendamento/", () -> {
				get("/:diaI/:mesI/:anoI/:diaF/:mesF/:anoF",(req,resp)-> AgendamentoController.getAll(req, resp), gson::toJson);
				post("/add","application/json",(req,resp)-> AgendamentoController.agendar(req, resp), gson::toJson);
			});
		});

		after((req, resp) -> {
			resp.header("Content-Encondig", "gzip");
			resp.type("application/json");
		});
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

	public static Session getSession() {
		return session;
	}

}
