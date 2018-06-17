package JarManage;

import java.util.ArrayList;
import java.util.List;

public class JarExtractPath {
	//Variables
	static List<String> list = new ArrayList<String>();
	//Opens the classpath and obtains a list of all jars
	public static void main (String args[]) {
		String s = System.getProperty("java.class.path");
		String[] tokens = s.split(";");
		for(int i = 0; i < tokens.length; i++) {
			list.add(tokens[i]);
		}
		System.out.println(list.toString());
	}
}
