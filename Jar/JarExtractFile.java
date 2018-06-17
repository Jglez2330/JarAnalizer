package Jar;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarExtractFile {
	//Variables needed for code
	static JarFile jar;
	static List<String> list = new ArrayList<String>();
	//Opens a jar file and gets all dependencies inside
	public static void getJars(JarFile jar) throws Exception {
		Enumeration entries = jar.entries();
		while(entries.hasMoreElements()) {
			JarEntry jarentry = (JarEntry)entries.nextElement();
			if(jarentry.getName().endsWith(".jar")) {
				list.add(jarentry.getName());
			}
		}
		System.out.println(list.toString());
		jar.close();
	}
	//Opens a jar file and gets all classes inside
	public static void getClasses(JarFile jar) throws Exception {
		Enumeration entries = jar.entries();
		while(entries.hasMoreElements()) {
			JarEntry jarentry = (JarEntry)entries.nextElement();
			if(jarentry.getName().endsWith(".class")) {
				list.add(jarentry.getName());
			}
		}
		System.out.println(list.toString());
		jar.close();
	}
	//Main class
	public static void main(String args[]) throws Exception {
		jar = new JarFile("C:\\Users\\Daniel\\eclipse\\jackson-core-2.9.5.jar");
		getClasses(jar);
	}
}
