package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void bunCreationTest() {
        Bun testBun = new Bun("Orange bun", 500);
        String bunName = "Orange bun";
        float bunPrice = 500;
        float delta = 0;
        assertEquals("bunName", bunName, testBun.getName());
        assertEquals(bunPrice, testBun.getPrice(), delta);
    }
}