package com.psicoder.jee.junit5;

import lombok.Value;
import lombok.extern.java.Log;

import java.util.concurrent.atomic.AtomicInteger;

@Log
@Value
public class Human {

    AtomicInteger health = new AtomicInteger(10);

    public void obeyCommand(Runnable command) {
        log.info("Performing Command!!!");
        command.run();
    }

    public String sayHello(String name) {
        return String.format("Hello %s", name);
    }

    public boolean isAlive() {
        return health.get() > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public void kick() {
        this.health.getAndDecrement();
    }
}
