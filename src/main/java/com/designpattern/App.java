package com.designpattern;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class App {
    public static void main(String[] args) {
        Options opt = new OptionsBuilder()
                        .include("com.designpattern.benchmarks.MyBenchmark")
                        .forks(2)
                        .build();
        try {
            new Runner(opt).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
