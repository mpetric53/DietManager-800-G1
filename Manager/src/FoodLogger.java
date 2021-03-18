import java.io.*;

public class FoodLogger {

    private String file;
    private FoodModel fm;

    public FoodLogger(FoodModel _fm, String _file) {
        file = _file;
        fm = _fm;
    }

    public boolean log() {
        PrintWriter pw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw, true);
        } catch(IOException ioe) {
            System.out.println("Error, in creating writer objects: " + ioe.getMessage());
            ioe.printStackTrace();
            return false;
        }
        //These need to change to date,name,type,typeVal
        String comma = ",";
        pw.print(fm.getName() + comma);
        pw.print("" + fm.getCalories() + comma);
        pw.print("" + fm.getFat() + comma);
        pw.print("" + fm.getCarb() + comma);
        pw.print("" + fm.getProtein());
        System.out.println("Logging completed");
        return true;
    }
}
