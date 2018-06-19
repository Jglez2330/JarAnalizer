package MavenConnection;

import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class ConnectionManager {
	
	private Crawler crawler = new Crawler();
	private String currentUrl = ""; //Es el mejor resultado encontrado


	
	public void search(String name) throws IOException {
		name = name.replace(' ', '+');

		currentUrl = crawler.search("https://mvnrepository.com/search?q="+ name, "jar ("); // Es "" si no encuentra el jar
	}

	public void download() throws IOException {
		if (currentUrl != "") {
			String version = currentUrl.substring(currentUrl.lastIndexOf('/')+1);
			currentUrl = currentUrl.substring(35,currentUrl.lastIndexOf('/'));
			currentUrl = currentUrl.replace('.', '/');
			String name = currentUrl.substring(currentUrl.lastIndexOf('/')+1);
			String downloadUrl = "http://central.maven.org/maven2/" + currentUrl + "/" + version + "/" + name + "-" + version + ".jar";
			Downloader.downloadFile(downloadUrl, "DownloadedJars");
		}else {
		    throw new IOException("Failed");
		}
	}
	public String getCurrentUrl() {
		return currentUrl;
	}

}
