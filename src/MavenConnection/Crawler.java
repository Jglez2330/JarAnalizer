package MavenConnection;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Crawler {
	
	private static final int MAX_PAGES_TO_SEARCH = 100;
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();
    
    private String nextUrl(){
        String nextUrl;
        do {
        	nextUrl = this.pagesToVisit.remove(0);
        }while(this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }
    
    public void search(String url, String searchWord) throws IOException{
        
    	while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH){
            String currentUrl;
            Leg leg = new Leg();
            if(this.pagesToVisit.isEmpty()){
                currentUrl = url;
                this.pagesVisited.add(url);
            }
            else{
                currentUrl = this.nextUrl();
            }
            leg.crawl(currentUrl); 
            
            boolean success = leg.searchForWord(searchWord);
            if(success){
                System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
        		String version = currentUrl.substring(currentUrl.lastIndexOf('/')+1);
        		currentUrl = currentUrl.substring(35,currentUrl.lastIndexOf('/'));
        		currentUrl = currentUrl.replace('.', '/');
        		String name = currentUrl.substring(currentUrl.lastIndexOf('/')+1);
        		String downloadUrl = "http://central.maven.org/maven2/" + currentUrl + "/" + version + "/" + name + "-" + version + ".jar";
                Downloader.downloadFile(downloadUrl, "DownloadedJars");
                break;
            }
            this.pagesToVisit.addAll(leg.getLinks());
        }
        System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));
    }
    
}
