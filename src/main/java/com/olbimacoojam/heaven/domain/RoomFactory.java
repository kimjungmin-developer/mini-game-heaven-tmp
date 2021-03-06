package com.olbimacoojam.heaven.domain;

import com.olbimacoojam.heaven.game.Game;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RoomFactory {
    private final AtomicInteger id = new AtomicInteger();

    /*구현체를 아직 만들지 않아 익명 클래스로 대체*/
    public Room makeNextRoom() {
        return new Room(id.getAndIncrement(), new Game() {
            @Override
            public void initialize() {
            }
        });
    }
}
