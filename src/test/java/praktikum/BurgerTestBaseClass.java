package praktikum;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class BurgerTestBaseClass {
    protected Bun testBun = null;
    protected Ingredient ingredientsSauce = null;
    protected Ingredient ingredientsFilling = null;
    protected Burger burger;

    public void setUpTestBurgerData() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/test/resources/TestData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            testBun = new Bun((String) jsonObject.get("BunName"), ((Double) jsonObject.get("BunPrice")).floatValue());
            ingredientsSauce = new Ingredient(
                    IngredientType.SAUCE,
                    (String) jsonObject.get("IngredientSauceName"),
                    ((Double) jsonObject.get("IngredientSaucePrice")).floatValue());
            ingredientsFilling = new Ingredient(
                    IngredientType.FILLING,
                    (String) jsonObject.get("IngredientFillingName"),
                    ((Double) jsonObject.get("IngredientFillingPrice")).floatValue());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        burger = new Burger();
    }

    public void addBun(Burger burger) {
        burger.setBuns(testBun);
    }

    public void addIngredientsSauceAndFilling(Burger burger) {
        burger.addIngredient(ingredientsSauce);
        burger.addIngredient(ingredientsFilling);
    }
}
