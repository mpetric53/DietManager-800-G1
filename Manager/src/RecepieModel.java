import java.util.ArrayList;
import java.util.HashMap;

public class RecepieModel {

    private HashMap<FoodModel, Float> foods = new HashMap<FoodModel, Float>();
    private String name;

    public RecepieModel () {}

    public RecepieModel(String name) {
        this.name = name;
    }
    
    public RecepieModel( String name, HashMap<FoodModel, Float> foods ) {
        this.name = name;
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "RecepieModel{" +
                "name='" + name+
                ", foods=" + foods  + '\'' +
                '}';
    }

    public HashMap<FoodModel, Float> getFoods() {
        return foods;
    }

    public void setFoods(HashMap<FoodModel, Float> foods) {
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFood(FoodModel food, float quantity) {
        if(food != null) this.foods.put(food, quantity);
    }
    
    public void removeFood(FoodModel food) {
        this.foods.remove(food);
    }

    /*
        Gets total calories for this recepie
     */
    public float getCalories() {
        float calories = 0;
        for (FoodModel food : foods.keySet()) { //So it's food calories * quantitiy of food in recepie
            calories += food.getCalories() * foods.get(food);
        }
        return calories;
    }
    /*
        Gets total fat for this recepie
     */
    public float getFat() {
        float fat = 0;
        for (FoodModel food : foods.keySet()) {//So it's food fat * quantitiy of food in recepie
            fat += food.getFat() * foods.get(food);
        }
        return fat;
    }
    /*
        Gets total carb for this recepie
     */
    public float getCarb() {
        float carb = 0;
        for (FoodModel food : foods.keySet()) {//So it's food carbs * quantitiy of food in recepie
            carb += food.getCarb() * foods.get(food);
        }
        return carb;
    }
    /*
        Gets total protein for this recepie
     */
    public float getProtein() {
        float protein = 0;
        for (FoodModel food : foods.keySet()) {//So it's food protein * quantitiy of food in recepie
            protein += food.getProtein() * foods.get(food);
        }
        return protein;
    }
}
