package Jar;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.io.File;

public class JarReader {
	//Opens a jar file and enumerates its entries to get all elements
	public static void main(String args[]) throws IOException {
		JarFile jarFile = new JarFile(new File("C:\\Program Files\\Java\\jre1.8.0_121\\lib\\resources.jar")); //This is the "resources" jar
		Enumeration<JarEntry> e = jarFile.entries();
		while (e.hasMoreElements()) {
			process(e.nextElement());
		}
		jarFile.close();
	}
	//Opens a jar file and gets an element's information
	private static void process(Object obj) {
		JarEntry entry = (JarEntry) obj;
		String name = entry.getName();
		long size = entry.getSize();
		long compressedSize = entry.getCompressedSize();
		System.out.println(name + "\t" + size + "\t" + compressedSize);
	}
}
