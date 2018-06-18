package Jar;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import java.util.jar.JarFile;

public class JarExtractPath {
	//Variables
	static List<String> list;
	static File jar;
	//Opens the classpath and obtains a list of all jars
	public static void main (String args[]) throws Exception {
		jar = new File("C:\\Users\\Daniel\\eclipse\\Jar Files\\jackson-core-2.9.5.jar");
		getDependencies(jar);
	}
	public static List<String> getClassPath() throws Exception {
		String s = System.getProperty("java.class.path");
		String[] tokens = s.split(";");
		for(int i = 0; i < tokens.length; i++) {
			list.add(tokens[i]);
		}
		return list;
	}
	public static void getDependencies (File jar) throws Exception {
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("jdeps " + jar.getPath());
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    System.out.println(s);
		}
		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
		    System.out.println(s);
		}
	}
}
