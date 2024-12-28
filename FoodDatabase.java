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
        // Foods
        foodData.put("Nasi Goreng", 350.0); // Fried rice
        foodData.put("Sate Ayam", 200.0); // Chicken satay
        foodData.put("Rendang", 400.0); // Spicy beef stew
        foodData.put("Bakso", 150.0); // Meatball soup
        foodData.put("Gado-Gado", 250.0); // Mixed vegetables with peanut sauce
        foodData.put("Tempe Goreng", 160.0); // Fried tempeh
        foodData.put("Ayam Goreng", 300.0); // Fried chicken
        foodData.put("Mie Goreng", 450.0); // Fried noodles
        foodData.put("Pempek", 200.0); // Fried fish cake with vinegar sauce
        foodData.put("Martabak Manis", 500.0); // Sweet thick pancake

        // Drinks
        drinkData.put("Es Teh Manis", 120.0); // Sweet iced tea
        drinkData.put("Jus Alpukat", 180.0); // Avocado juice
        drinkData.put("Es Jeruk", 100.0); // Orange juice
        drinkData.put("Air Mineral", 0.0); // Water
        drinkData.put("Kopi Susu", 150.0); // Coffee with milk
        drinkData.put("Susu Coklat", 200.0); // Chocolate milk
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
        } else if (drinkData.containsKey(itemName)) {
            return drinkData.get(itemName);
        } else {
            return null;
        }
    }
}
