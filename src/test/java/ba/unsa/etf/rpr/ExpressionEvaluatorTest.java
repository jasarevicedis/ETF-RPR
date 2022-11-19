package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
    /**
     * check some errors
     */
    @Test
    void Test1() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate(" ");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( )");
        });

    }

    /**
     * bad input
     */
    @Test
    void Test2() {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> ex.evaluate ("BAD"));
    }

    /**
     * bad input
     */
    @Test
    void Test3() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("(3*4 )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("(5*2)-3");
        });
    }

    /**
     * big expression
     */
    @Test
    void Test4() {
        Assertions.assertEquals(18,ExpressionEvaluator.evaluate("( 2 + ( ( 2 + 2 ) * ( 2 * 2 ) ) )"));
    }

    /**
     * simple expressions
     */
    @Test
    void Test5() {
        Assertions.assertEquals(4, ExpressionEvaluator.evaluate("( 2 * 2 )"));
        Assertions.assertEquals(1, ExpressionEvaluator.evaluate("( 2 / 2 )"));
        Assertions.assertEquals(0, ExpressionEvaluator.evaluate("( 2 - 2 )"));
        Assertions.assertEquals(4, ExpressionEvaluator.evaluate("( 2 + 2 )"));

    };


}