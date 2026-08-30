package com.assodepicche.chess.board;

public class Pawn extends Piece {
    private boolean isFirstMove = true;

    private Square square;

    public Pawn(Piece.Color color, Square square) {
        super(color);

        this.square = square;

        this.square.setPiece(this);
    }

    @Override
    public void move(Square newSquare) {
        if (isInvalid(newSquare)) {
            String message = String.format("Invalid Pawn Movement: %s -> %s", this.square.toString(), newSquare.toString());

            throw new IllegalArgumentException(message);
        }

        this.isFirstMove = false;

        this.square.setPiece(null);

        this.square = newSquare;

        newSquare.setPiece(this);
    }

    @Override
    public String toString() {
        return "P";
    }

    private boolean isInvalid(Square newSquare) {
        if (newSquare.getPiece() != null) {
            return newSquare.getPiece().getColor().equals(getColor());
        }

        if (this.square.getRank().distance(newSquare.getRank()) != 0) {
            return true;
        }

        return this.square.getFile().distance(newSquare.getFile()) > (isFirstMove ? 2 : 1);
    }
}
