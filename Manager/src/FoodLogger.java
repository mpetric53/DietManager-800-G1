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
        }
        String comma = ",";
        pw.print(fm.getName() + comma);
        pw.print("" + fm.getCalories() + comma);
        pw.println("" + fm.getFat() + comma);
        pw.println("" + fm.getCarb() + comma);
        pw.println("" + fm.getProtein());




        return false;
    }
}
