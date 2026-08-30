package com.assodepicche.chess.board;

public class Square {
    public static record Rank(char value) {
        public Rank {
            final int ascii = (int) value;

            final int MAX_ASCII = 104;

            final int MIN_ASCII = 67;

            if (ascii < MIN_ASCII || ascii > MAX_ASCII) {
                throw new IllegalArgumentException("Invalid rank: " + value);
            }
        }

        public int distance(Rank rank) {
            return Math.abs(((int)value) - ((int)rank.value()));
        }
    }

    public static record File(int value) {
        public File {
            final int MAX_FILE = 8;

            final int MIN_FILE = 1;

            if (value < MIN_FILE || value > MAX_FILE) {
                throw new IllegalArgumentException("Invalid file: " + value);
            }
        }

        public int distance(File file) {
            return Math.abs(value - file.value());
        }
    }

    private final File file;

    private final Rank rank;

    private Piece piece = null;

    private Square(Rank rank, File file) {
        this.file = file;

        this.rank = rank;
    }

    public static Square from(char rank, int file) {
        return new Square(new Rank(rank), new File(file));
    }

    public File getFile() {
        return file;
    }

    public Rank getRank() {
        return rank;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Square)) {
            return false;
        }

        Square square = (Square) object;

        return rank.value() == square.rank.value() && file.value() == square.file.value();
    }

    @Override
    public String toString() {
        return String.format("%s%c%d", piece == null ? " ": piece.toString(), rank.value(), file.value());
    }
}
