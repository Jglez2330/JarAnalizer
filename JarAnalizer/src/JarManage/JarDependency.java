package JarManage;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarDependency {
    public static List<String> getDependencies(JarFile jarFile){
        ArrayList arrayList = new ArrayList<String>();
        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
        while (jarEntryEnumeration.hasMoreElements()){
            JarEntry entry = jarEntryEnumeration.nextElement();

        }
        return arrayList;
    }

}
