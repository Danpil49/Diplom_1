package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BurgerTestBaseClass {
//    @Mock
//    Bun bun = testBun;
//    @Mock
//    Ingredient mockedIngredientSauce = ingredientsSauce;
//    @Mock
//    Ingredient mockedIngredientFilling = ingredientsFilling;

    @Before
    public void setUp() {
        setUpTestBurgerData();
    }

    @Test
    public void bunSetTest() {
        addBun(burger);
        assertEquals(testBun.hashCode(), burger.bun.hashCode());
    }

    @Test
    public void addIngredientTest() {
        addIngredientsSauceAndFilling(burger);

        List<Ingredient> expectedIngredients =  List.of(ingredientsSauce, ingredientsFilling);

        assertEquals(expectedIngredients.hashCode(), burger.ingredients.hashCode());
    }

    @Test
    public void removeIngredientTest() {
        addIngredientsSauceAndFilling(burger);
        burger.removeIngredient(1);

        List<Ingredient> expectedIngredients =  List.of(ingredientsSauce);

        assertEquals(expectedIngredients.hashCode(), burger.ingredients.hashCode());
    }

    @Test
    public void moveIngredientTest() {
        addBun(burger);
        addIngredientsSauceAndFilling(burger);
        burger.moveIngredient(0,1);

        List<Ingredient> expectedIngredients = List.of(ingredientsFilling, ingredientsSauce);

        assertEquals(expectedIngredients.hashCode(), burger.ingredients.hashCode());
    }

//    @Test
//    public void getPriceTest() {
//        burger.setBuns(bun);
//        burger.addIngredient(mockedIngredientSauce);
//        burger.addIngredient(mockedIngredientFilling);
//
//        Mockito.when(bun.getPrice()).thenReturn(15f);
//        Mockito.when(mockedIngredientSauce.getPrice()).thenReturn(20f);
//        Mockito.when(mockedIngredientFilling.getPrice()).thenReturn(10f);
//
//        float expectedPrice = (float) 60;
//
//        assertEquals(expectedPrice, burger.getPrice(), 0);
//    }
//
//    @Test
//    public void getReceiptTest() {
//        burger.setBuns(bun);
//        burger.addIngredient(mockedIngredientSauce);
//
//        Mockito.when(bun.getName()).thenReturn("black bun");
//        Mockito.when(mockedIngredientSauce.getType()).thenReturn(IngredientType.SAUCE);
//        Mockito.when(mockedIngredientSauce.getName()).thenReturn("hot sauce");
//        Mockito.when(bun.getPrice()).thenReturn(15f);
//        Mockito.when(mockedIngredientSauce.getPrice()).thenReturn(20f);
//
//        String expectedReceipt = String.format(
//                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
//                "black bun",
//                IngredientType.SAUCE.toString().toLowerCase(),
//                "hot sauce",
//                "black bun",
//                (float) 50);
//
//        assertEquals(expectedReceipt, burger.getReceipt());
//    }
}
