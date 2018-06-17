package MavenConnection;

import java.io.IOException;

public class ConnectionManager {

	public static void main(String[] args) throws IOException {
		
		Crawler crawler = new Crawler();
		String dependencyName = "FindBugs JSR305";
		dependencyName = dependencyName.replace(' ', '+');
		crawler.search("https://mvnrepository.com/search?q="+ dependencyName, "jar (");
	}

}
