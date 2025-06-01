package com.lld.tictactoe.model;

public class Pair<T,U> {
    private T row;
    private U column;

    public Pair(T row, U column) {
        this.row = row;
        this.column = column;
    }
}
