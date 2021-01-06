package com;

import org.springframework.stereotype.Component;

public interface Player {
    Position play(Board board);
}
