package Jar;

import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;


public class JarManifest {
	static JarFile jarfile;
	public static void main (String[] args) throws Exception {
		jarfile = new JarFile("C:\\Users\\Daniel\\eclipse\\Jar Files\\jackson-core-2.9.5.jar");
		getManifest(jarfile);
	}
	public static void getFromManifest(JarFile j) throws Exception {
		Manifest manifest = j.getManifest();
		Attributes attrs = manifest.getMainAttributes();
		String s = attrs.getValue("Import-Package");
		System.out.println(s);
	}
	public static void getManifest(JarFile j) throws Exception {
		Manifest manifest = j.getManifest();
		Attributes attrs = manifest.getMainAttributes();
	    for (Iterator it = attrs.keySet().iterator(); it.hasNext();) {
	    	Attributes.Name attrName = (Attributes.Name) it.next();
	    	String attrValue = attrs.getValue(attrName);
	    	System.out.println(attrName + ": " + attrValue);
	    }
	}
}
