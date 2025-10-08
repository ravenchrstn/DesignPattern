package com.designpattern.benchmarks;

import org.openjdk.jmh.annotations.*;
import com.designpattern.builders.entities.UserBuilder;
import com.designpattern.builders.valueobjects.FullNameBuilder;
import com.designpattern.models.entities.User;
import com.designpattern.models.valueobjects.FullName;
import com.designpattern.utils.ResourceMonitor;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class MyBenchmark {

    @State(Scope.Thread)
    public static class BuilderPatternState {
        @Setup(Level.Iteration)
        public void setup() {
            ResourceMonitor.setCpuUsages(new ArrayList<>());
            ResourceMonitor.setMemoryUsages(new ArrayList<>());
        }
    }

    @State(Scope.Thread)
    public static class NormalState {
        @Setup(Level.Iteration)
        public void setup() {
            ResourceMonitor.setCpuUsages(new ArrayList<>());
            ResourceMonitor.setMemoryUsages(new ArrayList<>());
        }
    }
    
    @Benchmark
    public void testBuilderPattern() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new UserBuilder()
                        // .setUserId(1)
                        .setName(
                            new FullNameBuilder()
                                .setFirstName("Raven")
                                // .setLastName("Christian")
                                .build()
                        )
                        // .setAge(20)
                        // .setAddress(
                        //     new AddressBuilder()
                        //         .setStreetName("Kembangan")
                        //         .setBuildingNumber("21")
                        //         .setPostalCode("20192")
                        //         .setCity("Jakarta Barat")
                        //         .setState("Indonesia")
                        //         .build()
                        // )
                        .build()
            );
        }
        ResourceMonitor.logAll("builderPattern");
    }

    @Benchmark
    public void testNormal() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // users.add(new User(1, new FullName("Raven", "Christian"), 20, new Address("Kembangan", "21", "20192", "Jakarta Barat", "Indonesia")));
            // users.add(new User(0, new FullName("Raven", "Christian"), 0, null)); // kita harus specify apa nilai default untuk setiap tipe data dari parameter constructor yang seharusnya tidak perlu dilakukan
            users.add(new User(0, new FullName("Raven", ""), 0, null)); // pada class FullName, juga dibuat 2 constructor, satu untuk menampung 2 parameter yang isinya firstName dan lastName, sisanya untuk menampung firstName, middleName, dan lastName
        }
        ResourceMonitor.logAll("normal");
    }
}
