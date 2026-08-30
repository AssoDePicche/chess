package com.assodepicche.chess.board;

public abstract class Piece {
    public enum Color {
        BLACK,
        WHITE,
    };

    public enum Type {
        PAWN,
    };

    private final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public final Color getColor() {
        return color;
    }

    public abstract void move(Square square);

    public static Piece make(Color color, Type type, Square square) {
        return switch (type) {
        case PAWN -> new Pawn(color, square);
        };
    }
}
