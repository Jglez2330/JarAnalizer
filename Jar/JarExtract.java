package Jar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import DataStructures.*;

public class JarExtract {
	static ArrayList<String> listD = new ArrayList<String>();
	static ArrayList<String> listJ = new ArrayList<String>();
	static ArrayList<String> listC = new ArrayList<String>();
	static JarFile jar;
	public static void getDependencies (JarFile jar) throws Exception {
		Manifest manifest = jar.getManifest();
		Attributes attrs = manifest.getMainAttributes();
		String s = attrs.getValue("Import-Package");
		String[] tokens = s.split(";");
		for(String t : tokens) {
			listD.add(t + ".jar");
		}
	}
	public static void main (String[] args) throws Exception {
		jar = new JarFile("C:\\Users\\ExtremeTech\\eclipse-workspace\\Gson\\gson-2.6.2.jar");
		getDependencies(jar);
		validateJars(listD);
//		System.out.println(sendtoGraphs(listJ));
		ArrayList<String> array = sendtoGraphs(listJ);
		GrafoD g1 = new GrafoD();


		
		for (int i = 0 ; i < array.size() - 1 ; i++) {
			if (array.get(i).startsWith("C:")) {
				g1.addArista(array.get(i), array.get(i + 1), 1);
			} else {
				g1.addArista(array.get(0), array.get(i + 1), 1);
			}
		}
		for (Nodo n : g1.getNodos()) {

			System.out.println("Los Nodos en el grafo son " + n.getNombre() + " y tienen como aristas dirigidos a");

			for (Arista a : n.getAristas()) { 

				System.out.println(a.getNFinal().getNombre());
			}
			System.out.println();

		}
		for (Arista a : g1.getAristas()) {

			System.out.println("El grafo posee arista que van de " + a.getNInicio().getNombre() + " a "
					+ a.getNFinal().getNombre());
		}
		System.out.println();
		g1.generateRankingDependencies();
		System.out.println();
		g1.generateRankingReferences();
		System.out.println();
		g1.generateMatrix();
	}
	public static void getManifest (JarFile jar) throws Exception {
		Manifest manifest = jar.getManifest();
		Attributes attrs = manifest.getMainAttributes();
	    for (Iterator it = attrs.keySet().iterator(); it.hasNext();) {
	    	Attributes.Name attrName = (Attributes.Name) it.next();
	    	String attrValue = attrs.getValue(attrName);
	    	System.out.println(attrName + ": " + attrValue);
	    }
	}
	public static ArrayList<String> validateJars (ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).endsWith(".jar")) {
				listJ.add(list.get(i));
			}
		}
		return listJ;
	}
	public static ArrayList<String> getClassPath() throws Exception {
		String s = System.getProperty("java.class.path");
		String[] tokens = s.split(";");
		for(int i = 0; i < tokens.length; i++) {
			listC.add(tokens[i]);
		}
		return listC;
	}
	public static ArrayList<String> sendtoGraphs (ArrayList<String> list) {
		ArrayList<String> listOut = new ArrayList<String>();
		String s = jar.getName();
		listOut.add(s);
		listOut.addAll(listJ);
		return listOut;
	}
	
} 

