package MavenConnection;

import java.io.IOException;

public class ConnectionManager {

	public static void main(String[] args) throws IOException {
		
		//Crawler crawler = new Crawler();
		//String dependencyName = "jsoup";
		//crawler.search("https://mvnrepository.com/search?q="+ dependencyName, "jar (");
		Downloader.downloadFile("http://central.maven.org/maven2/org/webjars/bower/lodash/4.17.10/lodash-4.17.10.jar", "C:\\Users\\Jose Andres Ch\\Documents\\TEC\\2018-1\\Datos 1\\JarAnalizer\\JarsDownloaded");
	}

}
