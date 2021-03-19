
/*
    This class is representing a particular food item from list.
    Each item that is read from the file will be constructed as
    Food model object.
 */
public class FoodModel {

    String name;
    float calories;
    float fat;
    float carb;
    float protein;

    public FoodModel() {
        this.name = null;
        this.calories = -1;
        this.fat = -1;
        this.carb = -1;
        this.protein = -1;
    }

    public FoodModel(String name, float calories, float fat, float carb, float protein) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carb = carb;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carb=" + carb +
                ", protein=" + protein +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getCarb() {
        return carb;
    }

    public void setCarb(float carb) {
        this.carb = carb;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }
}
