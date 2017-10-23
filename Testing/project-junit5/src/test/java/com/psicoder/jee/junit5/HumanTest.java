package com.psicoder.jee.junit5;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
