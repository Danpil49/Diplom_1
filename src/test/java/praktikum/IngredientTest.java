package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters()
    public static Object[][] setUpData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Black sauce", 50f},
                {IngredientType.FILLING, "Beacon", 150f},
        };
    }

    @Test
    public void ingredientCreationTest() {
        Ingredient testIngredient = new Ingredient(type, name, price);
        assertEquals(type, testIngredient.getType());
        assertEquals(name, testIngredient.getName());
        assertEquals(price, testIngredient.getPrice(), 0f);
    }
}
