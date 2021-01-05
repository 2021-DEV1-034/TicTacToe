package com;

public enum Draw {
    X,
    O,
    Empty {
        @Override
        public String toString() {
            return " ";
        }
    }
}
