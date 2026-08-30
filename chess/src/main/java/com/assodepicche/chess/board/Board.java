package com.assodepicche.chess.board;

public class Board {
    public static final int PAWNS_PER_PLAYER = 8;

    private Square[] squares = null;

    private Board(Square[] squares) {
        this.squares = squares;
    }

    public static Board initialState() {
        Square[] squares = new Square[64];

        int index = 0;

        for (int file = 0; file < 8; ++file) {
            for (int rankOffset = 0; rankOffset < 8; ++rankOffset) {
                Square square = Square.from((char)(97 + rankOffset), file + 1);

                squares[index++] = square;
            }
        }

        for (int offset = 0; offset < PAWNS_PER_PLAYER; ++offset) {
            Piece.make(Piece.Color.BLACK, Piece.Type.PAWN, squares[8 + offset]);

            Piece.make(Piece.Color.WHITE, Piece.Type.PAWN, squares[48 + offset]);
        }

        return new Board(squares);
    }

    public void move(int source, int destination) {
        squares[source].getPiece().move(squares[destination]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < squares.length; ++index) {
            builder.append(squares[index].toString() + " ");

            if ((index + 1) % 8 == 0) {
                builder.append('\n');
            }
        }

        return builder.toString();
    }
}
