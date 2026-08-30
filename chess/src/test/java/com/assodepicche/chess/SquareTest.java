import com.assodepicche.chess.board.Square;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SquareTest {
    @Test
    void invalidSquareFileShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Square.from('a', 9));
    }

    @Test
    void invalidSquareRankShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Square.from('i', 0));
    }
}
