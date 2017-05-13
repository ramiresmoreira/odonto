package App;

import java.net.URI;
import java.net.URISyntaxException;

public class Teste {

	public static void main(String[] args) throws URISyntaxException {
		URI uri = new URI("postgres://mwvunzpjqtqwse:fdf5514aaf8c2ca203603a14c57dd9c6aa7cde9b5cf30b4cb2af124e8537f265@ec2-23-23-111-171.compute-1.amazonaws.com:5432/d9duj1m1po4a03");
		
		System.out.println("hotst = "+uri.getHost());
		System.out.println("port  = "+uri.getPort());
		System.out.println("DBase = "+uri.getPath());
		System.out.println("User  = "+uri.getUserInfo().split(":")[0]);
		System.out.println("Pass  = "+uri.getUserInfo().split(":")[1]);
	}
}
