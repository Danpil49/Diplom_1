package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest extends BurgerTestBaseClass {
    @Before
    public void setUp() {
        setUpTestBurgerData();
    }

    @Test
    public void bunSetTest() {
        addBun(burger);
        assertEquals("Add bun to burger failed", testBun.hashCode(), burger.bun.hashCode());
    }

    @Test
    public void addIngredientTest() {
        addIngredientsSauceAndFilling(burger);

        List<Ingredient> expectedIngredients =  List.of(ingredientsSauce, ingredientsFilling);

        assertEquals("Add ingredients to burger failed", expectedIngredients.hashCode(), burger.ingredients.hashCode());
    }

    @Test
    public void removeIngredientTest() {
        addIngredientsSauceAndFilling(burger);
        burger.removeIngredient(1);

        List<Ingredient> expectedIngredients =  List.of(ingredientsSauce);

        assertEquals("Remove ingredients from burger failed", expectedIngredients.hashCode(), burger.ingredients.hashCode());
    }

    @Test
    public void moveIngredientTest() {
        addBun(burger);
        addIngredientsSauceAndFilling(burger);
        burger.moveIngredient(0,1);

        List<Ingredient> expectedIngredients = List.of(ingredientsFilling, ingredientsSauce);

        assertEquals("Move ingredients failed", expectedIngredients.hashCode(), burger.ingredients.hashCode());
    }
}
