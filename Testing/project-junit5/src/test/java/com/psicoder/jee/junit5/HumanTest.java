package com.psicoder.jee.junit5;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log
public class HumanTest {

    private static Human human;

    @BeforeAll
    static void initAll() {
        human = new Human();
    }

    @Test
    void shouldPerformCommand() {
        AtomicBoolean atomicSwitch = new AtomicBoolean(false);

        Runnable command = () -> {
            atomicSwitch.set(true);
        };

        human.obeyCommand(command);

        assertTrue(atomicSwitch.get());
    }

    @ParameterizedTest
    @ValueSource(strings = { "Rick", "Morty" })
    void shouldSayHelloBasedOnName(String name) {
        assertEquals("Hello " + name, human.sayHello(name));
    }

    @RepeatedTest(12)
    void tryRepeated(RepetitionInfo info) {
        human.kick();

        if (info.getCurrentRepetition() > 9) {
            assertTrue(human.isDead());
        } else {
            assertTrue(human.isAlive());
        }
    }
}
