package com.psicoder.jee.junit5;

import lombok.extern.java.Log;

@Log
public class Human {

    public void obeyCommand(Runnable command) {
        log.info("Performing Command!!!");
        command.run();
    }
}
