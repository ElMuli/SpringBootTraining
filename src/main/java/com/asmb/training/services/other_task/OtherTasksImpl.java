package com.asmb.training.services.other_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class OtherTasksImpl implements OtherTasksInterface{

    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void startUselessParallelProcess() {

        try {

            log.info("Waiting 5 seconds until other tasks are completed...");
            Thread.sleep(5000L);
            log.info("Resuming aplication");

            firstUselessFunction();

            secondUselessFunction();

            log.info("Final Atomic Value: {}", atomicInteger.get());


        }catch (Exception e){
            log.error("An unexpected error ocurred: {}", e.getMessage());
        }

    }


    private void firstUselessFunction(){


        // Generation of a random number
        int x = obtainRandomNumber(10, 50);

        for (int i = 0; i<x; i++){
            atomicInteger.incrementAndGet();
        }


    }

    private void secondUselessFunction(){


        // Generation of a random number
        int x = obtainRandomNumber(5, 20);

        for (int i = 0; i<x; i++){
            atomicInteger.incrementAndGet();
        }

    }

    private Integer obtainRandomNumber(Integer min, Integer max){

        return (int) (Math.random() * max - min + 1);
    }
}
