import java.io
import java.utillities


public class DemoJars
{
        public static void showJars()
        {
            String str = System.getProperty(“sun.boot.class.path”);
            String jars[ ] = str.split(File.pathSeparator);
            for (String jar : jars)System.out.println(jar);
        }
}
        public static void main(String args[ ])
        {
            showJars();
        }



    
    
    








