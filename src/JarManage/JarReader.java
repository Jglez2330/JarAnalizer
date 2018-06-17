package JarManage;

import DataStructures.GrafoD;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.io.File;

public class JarReader {
	public static GrafoD grafoD = new GrafoD();
	//Opens a jar file and enumerates its entries to get all elements
	public static void main(String path) throws IOException {
		JarFile jarFile = new JarFile(new File(path)); //This is the "resources" jar
        JarExtractFile.jar = jarFile;
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
		System.out.println(name + "\n" + size + "\n" + compressedSize);
        grafoD.addArista("Puntarenas", "San Jose", 1);
        grafoD.addArista("Cartago", "San Jose", 1);
        grafoD.addArista("Cartago", "Puntarenas", 1);
        grafoD.addArista("Alajuela", "Cartago", 1);
        grafoD.addArista("Guanacaste", "San Carlos", 1);


    }

    public static GrafoD getGrafoD() {
        return grafoD;
    }
}
