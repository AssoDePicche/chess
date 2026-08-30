import com.assodepicche.chess.board.Board;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void initialState() {
        Board board = Board.initialState();
    }

    @Test
    void pawnShouldMoveOnlyForward() {
        Board board = Board.initialState();

        assertThrows(IllegalArgumentException.class, () -> board.move(9, 16));
    }


    @Test
    void pawnShouldMoveOneSquareForward() {
        Board board = Board.initialState();

        board.move(8, 16);
    }

    @Test
    void pawnShouldMoveTwoSquaresForwaredAtStart() {
        Board board = Board.initialState();

        board.move(8, 24);
    }

    @Test
    void pawnMovingBackShouldThrowIllegalArgumentException() {
        Board board = Board.initialState();

        assertThrows(IllegalArgumentException.class, () -> board.move(8, 7));
    }

    @Test
    void pawnMovingToASquareThatIsNotFreeShouldThrowIllegalArgumentException() {
        Board board = Board.initialState();

        assertThrows(IllegalArgumentException.class, () -> board.move(8, 9));
    }

    @Test
    void pawnShouldTakeDownPiecesInDiagonal() {
        Board board = Board.initialState();

        board.move(8, 24);

        board.move(49, 33);

        board.move(33, 24);
    }
}
