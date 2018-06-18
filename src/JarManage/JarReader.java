package JarManage;

import DataStructures.GrafoD;
import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.io.File;
import java.util.zip.ZipFile;

public class JarReader {
	public static GrafoD grafoD = new GrafoD();
	public static List<String> dependencies = new ArrayList<>();
	//Opens a jar file and enumerates its entries to get all elements
	public static void main(String path) throws IOException {
		JarFile jarFile = new JarFile(new File(path)); //This is the "resources" jar
        JarExtractFile.jar = jarFile;
		Enumeration<JarEntry> e = jarFile.entries();
		while (e.hasMoreElements()) {
			process(e.nextElement());
		}

		System.out.println(dependencies.size());

		//getDependencies(jarFile);
		//jarFile.close();
	}
	//Opens a jar file and gets an element's information
	private static void process(Object obj) {
		JarEntry entry = (JarEntry) obj;
		String name = entry.getName();
		long size = entry.getSize();
		long compressedSize = entry.getCompressedSize();
		System.out.println(name + "\n" + size + "\n" + compressedSize);
		if ( name.contains("$") || !name.contains("/")) {
            dependencies.add(name);
        }


    }

    public static GrafoD getGrafoD() {
        return grafoD;
    }

    public static List<String> getDependencies(String path) throws IOException, ClassNotFoundException {


        return null;
    }
}
