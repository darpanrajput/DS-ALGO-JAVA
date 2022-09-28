package com.algorithm.TimeComplexities;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class CalculateTime {

    public static void main(String[] args) {
        Instant startTime=Instant.now();
        justRun();
        Instant stopTime=Instant.now();

        long timeDifference= Duration.between(startTime,stopTime).toMillis();

        System.out.println("Time Taken="+timeDifference);


    }

    public static void justRun(){
        System.out.println("started");
        for (int i = 0; i < 1000000000; i++) {
        }
        System.out.println("Stopped");



//        you can sleep it
       /* try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
