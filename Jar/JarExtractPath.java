package Jar;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class JarExtractPath {
	//Variables
	static List<String> listC = new ArrayList<String>();
	static List<String> listD = new ArrayList<String>();
	static List<String> listJ = new ArrayList<String>();
	static List<String> listF = new ArrayList<String>();
	static File jar;
	//Opens the classpath and obtains a list of all jars
	public static void main (String args[]) throws Exception {
		jar = new File("C:\\Users\\Daniel\\Downloads\\commons-collections4-4.0.jar");
		getClassPath();
		System.out.println(listC.toString());
	}
	public static List<String> getClassPath() throws Exception {
		String s = System.getProperty("java.class.path");
		String[] tokens = s.split(";");
		for(int i = 0; i < tokens.length; i++) {
			listC.add(tokens[i]);
		}
		return listC;
	}
	//Obtains the dependencies from a jar file
	public static void getDependencies (File jar) throws Exception {
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("jdeps " + jar.getPath());
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    listD.add(s);
		}
		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
		    System.out.println(s);
		}
	}
	//Parses the list generated by the above function to include only jars
	public static List<String> validateJars (List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).endsWith(".jar")) {
				listJ.add(list.get(i));
			}
		}
		return listJ;
	}
	//Compares the classpath jars with dependencies jars
	public static List<String> compareLists (List<String> list1, List<String> list2){
		listF = (List<String>) CollectionUtils.retainAll(list1, list2);
		if(listF == null) {
			//Descargas de Maven van aqu�, mientras tanto
			return null;
		}
		return listF;
	}
	public static List<String> sendtoGraph(List<String> list) {
		List<String> listOut = new ArrayList<String>();
		listOut.add(jar.getPath());
		listOut.addAll(list);
		return listOut;
	}
}
