import java.util.HashMap;

public class FoodDatabase {
    private final HashMap<String, Double> foodData;
    private final HashMap<String, Double> drinkData;

    public FoodDatabase() {
        foodData = new HashMap<>();
        drinkData = new HashMap<>();
        initializeDatabase();
    }

    private void initializeDatabase() {
        // Data makanan
        foodData.put("Nasi Goreng", 350.0);
        foodData.put("Sate Ayam", 200.0);
        foodData.put("Rendang", 400.0);

        // Data minuman
        drinkData.put("Es Teh Manis", 120.0);
        drinkData.put("Jus Alpukat", 180.0);
        drinkData.put("Air Mineral", 0.0);
    }

    public String[] getFoodOptions() {
        return foodData.keySet().toArray(new String[0]);
    }

    public String[] getDrinkOptions() {
        return drinkData.keySet().toArray(new String[0]);
    }

    public Double getCalories(String itemName) {
        if (foodData.containsKey(itemName)) {
            return foodData.get(itemName);
        }
        return drinkData.getOrDefault(itemName, null);
    }

    // CRUD Functions
    public void addFood(String name, double calories) {
        foodData.put(name, calories);
    }

    public void addDrink(String name, double calories) {
        drinkData.put(name, calories);
    }

    public void removeFood(String name) {
        foodData.remove(name);
    }

    public void removeDrink(String name) {
        drinkData.remove(name);
    }

    public void updateFood(String name, double calories) {
        if (foodData.containsKey(name)) {
            foodData.put(name, calories);
        }
    }

    public void updateDrink(String name, double calories) {
        if (drinkData.containsKey(name)) {
            drinkData.put(name, calories);
        }
    }

    public String getFoodList() {
        StringBuilder result = new StringBuilder("Foods:\n");
        foodData.forEach((key, value) -> result.append(key).append(" - ").append(value).append(" kcal\n"));
        return result.toString();
    }

    public String getDrinkList() {
        StringBuilder result = new StringBuilder("Drinks:\n");
        drinkData.forEach((key, value) -> result.append(key).append(" - ").append(value).append(" kcal\n"));
        return result.toString();
    }
}
