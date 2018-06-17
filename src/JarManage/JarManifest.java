package JarManage;

import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarManifest {
	static JarFile jarfile;
	public static void main (String[] args) throws Exception {
		jarfile = new JarFile("C:\\Program Files\\Java\\jre1.8.0_121\\lib\\resources.jar");
		System.out.println(JarManifest.getFromManifest(jarfile));
	}
	public static String getFromManifest(JarFile j) throws Exception {
		Manifest manifest = j.getManifest();
		Attributes attributes = manifest.getMainAttributes();
		return attributes.getValue("Manifest-Version");
	}
}
