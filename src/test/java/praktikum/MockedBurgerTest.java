package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MockedBurgerTest extends BurgerTestBaseClass{
    @Mock
    Bun testBun;
    @Mock
    Ingredient ingredientsSauce;
    @Mock
    Ingredient ingredientsFilling;

    @Before
    public void setUp() {
        setUpTestBurgerData();
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(testBun);
        burger.addIngredient(ingredientsSauce);
        burger.addIngredient(ingredientsFilling);

        Mockito.when(testBun.getPrice()).thenReturn(15f);
        Mockito.when(ingredientsSauce.getPrice()).thenReturn(20f);
        Mockito.when(ingredientsFilling.getPrice()).thenReturn(10f);

        float expectedPrice = (float) 60;

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(testBun);
        burger.addIngredient(ingredientsSauce);

        Mockito.when(testBun.getName()).thenReturn("black bun");
        Mockito.when(ingredientsSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientsSauce.getName()).thenReturn("hot sauce");
        Mockito.when(testBun.getPrice()).thenReturn(15f);
        Mockito.when(ingredientsSauce.getPrice()).thenReturn(20f);

        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                "black bun",
                IngredientType.SAUCE.toString().toLowerCase(),
                "hot sauce",
                "black bun",
                (float) 50);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
