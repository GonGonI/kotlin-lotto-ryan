import org.assertj.core.api.Assertions.*
import org.example.calculateFromParts
import org.example.parseExpression
import org.junit.jupiter.api.Assertions.assertThrows

import kotlin.test.Test

class CalcTest {
    @Test
    fun validInputs() {
        assert(calculateFromParts(parseExpression("3 * 4 / 2 + 5 - 1")) == 10)
        assert(calculateFromParts(parseExpression("1 + 3 / 2 * 5 - 2")) == 8)
    }

    @Test
    fun invalidInputs() {
        assertThatNullPointerException().isThrownBy {
            calculateFromParts(parseExpression("2 +"))
        }
        assertThatIndexOutOfBoundsException().isThrownBy {
            val parts = arrayOf("2", "+", "4", "-", "6")
            calculateFromParts(parts.copyOfRange(0, parts.size + 1)) //forcing an index out of bounds
        }
        assertThrows(IllegalArgumentException::class.java) { calculateFromParts(parseExpression("2 p 4 -")) }
        assertThrows(IllegalArgumentException::class.java) { calculateFromParts(parseExpression("2 +4 /")) }
    }
}