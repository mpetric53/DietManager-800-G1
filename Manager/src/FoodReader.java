import java.io.*;
import java.util.*;

/*
    This class is responsible for reading and interpreting
    foods.csv file. This will be used to access the file and
    return food model or recepie model which will be further used
    within the controler
 */
public class FoodReader {
    private String fileName;
    private ArrayList<RecepieModel> recepies = new ArrayList<RecepieModel>();
    private ArrayList<FoodModel> foods = new ArrayList<FoodModel>();

    //Constructor reads the file initially, but can be refreshed later by calling readFile again
    public FoodReader(String filename) {
        this.fileName = filename;
        readFile();
    }

    /*
        This function is used to refresh the file. This means that once invoked,
        it will read foods file and set foods as attributes to this class. If invoked again,
        it will clear previous foods and set new foods, meaning it could be used  as
        refresh file function.
     */
    public void readFile() {
        foods.clear();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));

                if(values[0].equals("b")) addFood(values);
                else addRecepie(values);
            }
        } catch (IOException e) {
            System.out.println("There was a problem reading foods.csv, please check if it is in the root directory.");
            e.printStackTrace();
        }
    }

    public void addFood(String[] values) {
        FoodModel newFood = new FoodModel();

        try{
            newFood.setName(values[1]);
            newFood.setCalories(Float.parseFloat(values[2]));
            newFood.setFat(Float.parseFloat(values[3]));
            newFood.setCarb(Float.parseFloat(values[4]));
            newFood.setProtein(Float.parseFloat(values[5]));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("FoodReader -> addFood() recieved incomplete food, ignoring row...");
        }
        this.foods.add(newFood);
        System.out.println(newFood.toString());
    }

    /*
        Parse recepie line and add it as object
     */
    public void addRecepie(String[] values) {
        String recepieName = values[1];

        //init recepie
        RecepieModel recepie = new RecepieModel(recepieName);

        // 0 position tells us it's recepie, 1 position gives us the name
        //of recepie, and then positions 2/3 give us foodName/quantity
        //due to unknown amount of foods in recepie, we have to loop through
        //this until we reach end
        for (int i = 2; i < values.length-1; i=i+2) {
            FoodModel food = findFoodByName(values[i]);

            if(food == null) { //If our food is null, check if recepie with that name exists
                System.out.println("Checking if recepie exists...");
                RecepieModel subRecepie = findRecpieByName(values[i]);
                //for every food within our recepie, add it and it's quantitiy to the new recepie
                for (FoodModel subFood : subRecepie.getFoods().keySet()) {
                    recepie.addFood(subFood, subRecepie.getFoods().get(subFood));
                }

                System.out.println("Exists!");
            }
            float quantity = Float.parseFloat(values[i+1]);
            recepie.addFood(food, quantity);
        }
        System.out.println(recepie.toString());
        this.recepies.add(recepie);
    }

    /*
        Find food model by name of the food
     */
    public FoodModel findFoodByName(String name) {
        for (FoodModel food : foods) {
            if(food.getName().equals(name)) return food;
        }
        System.out.println("Food not found: " + name);
        return null; //If null returned, no food with that name exists
    }

    /*
        Find recepie model by name of the food
     */
    public RecepieModel findRecpieByName(String name) {
        for (RecepieModel recepie : recepies) {
            if(recepie.getName().equals(name)) return recepie;
        }
        System.out.println("Recepie not found: " + name);
        return null; //If null returned, no food with that name exists
    }

    public static void main(String[] args) {
        FoodReader reader = new FoodReader("foods.csv");
        reader.readFile();

        System.out.println("Bad Dinner calories: " + reader.findRecpieByName("Bad Dinner").getCalories());
        System.out.println("Bad Dinner protein: " + reader.findRecpieByName("Bad Dinner").getProtein());
        System.out.println("Bad Dinner carbs: " + reader.findRecpieByName("Bad Dinner").getCarb());
        System.out.println("Bad Dinner fat: " + reader.findRecpieByName("Bad Dinner").getFat());
    }
}
