package com.designpatterns.mgrinf.singleton;

import org.openjdk.jmh.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

@State(Scope.Benchmark)
@Threads(1)
public class SingletonDesignPatternBenchmarkTest {
    public static Long startTime;
    public static SingletonEnum singleton;
    public static SingletonLazy singletonLazy;
    public static SingletonLazyDoubleCheck singletonLazy2;

//    public static final int CYCLES = 1000000;

    //TODO do testów wydajności użyć zewnętrznego profilera !

    @Param("100")
    public int CYCLES;

    @Setup(Level.Invocation)
    public void setupInvokation() throws Exception {
        // executed before each invocation of the benchmark
    }

    @Setup(Level.Iteration)
    public void setupIteration() throws Exception {
        // executed before each invocation of the iteration
        resetTime();
    }

    @Test
    public void benchmark() throws Exception {
        String[] argv = {};
        org.openjdk.jmh.Main.main(argv);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testSingletonReflectionAndSerialization() throws Exception {

        System.out.println("Hello world of Singletons!");

        //Serialization
        System.out.println("Checking singleton serialization.");
        SerializeSingleton serial = new SerializeSingleton();
        boolean resultSerialization = serial.checkSingletonSerialization();
        System.out.println("Serialization validated with result: " + String.valueOf(resultSerialization).toUpperCase());

        //Reflection
        System.out.println("Checking singleton by reflection.");
        ReflectSingleton reflect = new ReflectSingleton();
        boolean resultReflection = false;
        try {
            resultReflection = reflect.testSingletonWithReflection();
        } catch (Exception e) {
            System.out.println("Exception during Reflection testing. E: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Reflection validated with result: " + String.valueOf(resultReflection).toUpperCase());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testSingletonPublicStatic() {
        System.out.println("Testing SingletonPublicStatic performance");
        SingletonPublicStatic singleton = SingletonPublicStatic.INSTANCE;
        int hc2 = singleton.hashCode();

        for (int i = 1; i <= CYCLES - 1; i++) {
            singleton = SingletonPublicStatic.INSTANCE;
            singleton.setValue(i);
        }
        System.out.println("SingletonPublicStatic time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singleton.getValue());
        assertTrue(singleton.hashCode() == hc2, "FAIL -> Instance not equals!");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testSingletonEnum() {
        System.out.println("Testing SingletonEnum performance");
        singleton = SingletonEnum.INSTANCE;
        int hc = singleton.hashCode();
        for (int i = 1; i <= CYCLES - 1; i++) {
            singleton = SingletonEnum.INSTANCE;
            singleton.setValue(i);
        }
        System.out.println("SingletonEnum time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singleton.getValue());
        assertTrue(singleton.hashCode() == hc, "FAIL -> Instance not equals!");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testSingletonLazyDoubleCheck() {
        System.out.println("Testing SingletonLazyDoubleCheck performance");
        singletonLazy2 = SingletonLazyDoubleCheck.getInstance();
        int hc2 = singletonLazy2.hashCode();

        for (int i = 1; i <= CYCLES - 1; i++) {
            singletonLazy2 = SingletonLazyDoubleCheck.getInstance();
            singletonLazy2.setValue(i);
        }
        System.out.println("SingletonLazyDoubleCheck time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singletonLazy2.getValue());
        assertTrue(singletonLazy2.hashCode() == hc2, "FAIL -> Instance not equals!");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(batchSize = -1, iterations = 1, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testSingletonLazy() {
        System.out.println("Testing SingletonLazy performance");
        singletonLazy = SingletonLazy.getInstance();
        int hc1 = singletonLazy.hashCode();
        for (int i = 1; i <= CYCLES - 1; i++) {
            singletonLazy = SingletonLazy.getInstance();
            singletonLazy.setValue(i);
        }
        System.out.println("SingletonLazy time efficiency: " + (System.currentTimeMillis() - startTime));
        System.out.println("Current value: " + singletonLazy.getValue());
        assertTrue(singletonLazy.hashCode() == hc1, "FAIL -> Instance not equals!");
    }

    public static void resetTime() {
        startTime = System.currentTimeMillis();
    }
}


