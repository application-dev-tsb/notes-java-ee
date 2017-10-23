package com.psicoder.jee.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import lombok.extern.java.Log;

import java.util.concurrent.atomic.AtomicBoolean;

@Log
public class HumanTest {

    @Test
    void shouldPerformCommand() {
        AtomicBoolean atomicSwitch = new AtomicBoolean(false);

        Runnable command = () -> {
            atomicSwitch.set(true);
        };

        Human human = new Human();
        human.obeyCommand(command);

        assertTrue(atomicSwitch.get());
    }
}
