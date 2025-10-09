package com.designpattern.benchmarks;

import org.openjdk.jmh.annotations.*;
import com.designpattern.builders.entities.UserBuilder;
import com.designpattern.builders.valueobjects.FullNameBuilder;
import com.designpattern.factories.LuxuryVehicleFactory;
import com.designpattern.factories.interfaces.VehicleFactory;
import com.designpattern.factories.SportVehicleFactory;
import com.designpattern.models.entities.LuxuryBike;
import com.designpattern.models.entities.LuxuryCar;
import com.designpattern.models.entities.SportCar;
import com.designpattern.models.entities.User;
import com.designpattern.models.valueobjects.FullName;
import com.designpattern.utils.ResourceMonitor;
import com.designpattern.models.interfaces.Car;
import com.designpattern.models.interfaces.Bike;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class MyBenchmark {

    @Benchmark
    public void testFactoryMethod() {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();

        // ceritanya ada masuk factory dari parameter
        LuxuryVehicleFactory lvf = new LuxuryVehicleFactory();
        for (int i = 0; i < 30; i++) {
            ArrayList<String> carFeatures = new ArrayList<>();
            carFeatures.add("Extra Fast");
            cars.add(lvf.createCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true));

            ArrayList<String> bikeFeatures = new ArrayList<>();
            bikeFeatures.add("Extra Fast");
            bikes.add(lvf.createBike("Mio", "AYT25", "Red", 2021, false, false, 400, bikeFeatures));
        }
        ResourceMonitor.logAll("methodFactory");
    }

    @Benchmark
    public void testWithoutFactoryMethod() {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ArrayList<String> carFeatures = new ArrayList<>();
            carFeatures.add("Extra Fast");

            // kita harus mengetahui mobil apa yang ingin dibuat, bisa melalui String vehicleType dan dilakukan if-else
            cars.add(new LuxuryCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true));

            ArrayList<String> bikeFeatures = new ArrayList<>();
            bikeFeatures.add("Extra Fast");
            bikes.add(new LuxuryBike("Mio", "AYT25", "Red", 2021, false, false, 400, bikeFeatures));
        }
        ResourceMonitor.logAll("withoutMethodFactory");
    }

    @Benchmark
    public void testAbstractFactory() {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();

        // ceritanya kita terima VehicleFactory saja tanpa tahu implementasinya (itu mobil tipe apa)
        VehicleFactory factory = new LuxuryVehicleFactory();
        for (int i = 0; i < 30; i++) {
            ArrayList<String> carFeatures = new ArrayList<>();
            carFeatures.add("Extra Fast");
            cars.add(factory.createCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true));

            ArrayList<String> bikeFeatures = new ArrayList<>();
            bikeFeatures.add("Extra Fast");
            bikes.add(factory.createBike("Mio", "AYT25", "Red", 2021, false, false, 400, bikeFeatures));
        }
        ResourceMonitor.logAll("abstractFactory");
    }

    @Benchmark
    public void testWithoutAbstractFactory() {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            // kita gatau apa yang mau dibuat sehingga mungkin bisa menggunakan String vehicleType dan dilakukan if-else
            ArrayList<String> carFeatures = new ArrayList<>();
            carFeatures.add("Extra Fast");
            cars.add(new LuxuryCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true));

            ArrayList<String> bikeFeatures = new ArrayList<>();
            bikeFeatures.add("Extra Fast");
            bikes.add(new LuxuryBike("Mio", "AYT25", "Red", 2021, false, false, 400, bikeFeatures));
        }
        ResourceMonitor.logAll("withoutAbstractFactory");
    }

    @Benchmark
    public void testSingleton() {
        SportVehicleFactory svf = SportVehicleFactory.getInstance();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();
        // ArrayList<LuxuryVehicleFactory> lvfs = new ArrayList<>();
        
        // for (int i = 0; i < 10; i++) {
        //     // dianggap seperti ada pembuatan
        //     lvfs.add(new LuxuryVehicleFactory());
        // }
        for (int i = 0; i < 30; i++) {
            ArrayList<String> carFeatures = new ArrayList<>();
            carFeatures.add("Extra Fast");
            cars.add(svf.createCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true));

            ArrayList<String> bikeFeatures = new ArrayList<>();
            bikeFeatures.add("Extra Fast");
            bikes.add(svf.createBike("Mio", "AYT25", "Red", 2021, false, false, 400, bikeFeatures));
        }
        ResourceMonitor.logAll("singleton");

    }

    @Benchmark
    public void testWithoutSingleton() {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();
        ArrayList<LuxuryVehicleFactory> lvfs = new ArrayList<>();
        
        for (int i = 0; i < 30; i++) {
            // dianggap seperti ada pembuatan berkali-kali di file yang lain
            lvfs.add(new LuxuryVehicleFactory());
        }

        for (int i = 0; i < 30; i++) {
            ArrayList<String> carFeatures = new ArrayList<>();
            carFeatures.add("Extra Fast");
            cars.add(lvfs.get(i).createCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true));

            ArrayList<String> bikeFeatures = new ArrayList<>();
            bikeFeatures.add("Extra Fast");
            bikes.add(lvfs.get(i).createBike("Mio", "AYT25", "Red", 2021, false, false, 400, bikeFeatures));
        }
        ResourceMonitor.logAll("withoutSingleton");
    }

    @Benchmark
    public void testPrototype() {
        ArrayList<String> carFeatures = new ArrayList<>();
        carFeatures.add("Extra Fast");
        Car car = new SportCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true);
        ArrayList<Car> copiedCars = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Car copiedCar = car.carClone();
            copiedCars.add(copiedCar);
        }
        ResourceMonitor.logAll("prototype");
    }

    @Benchmark
    public void testWithoutPrototype() {
        ArrayList<String> carFeatures = new ArrayList<>();
        carFeatures.add("Extra Fast");
        Car car = new SportCar("Toyota", "AWG12", "White", 2025, 6, carFeatures, 2000.0, true);
        
        ArrayList<Car> copiedCars = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            // dibuat dengan menyalin ulang semua nilainya
            ArrayList<String> copiedCarFeature = new ArrayList<>(car.getFeatures());
            Car copiedCar = new SportCar(car.getBrand(), car.getModel(), car.getColor(), car.getYear(), car.getNumberOfDoors(), copiedCarFeature, 0, false);
            copiedCars.add(copiedCar);
        }
        ResourceMonitor.logAll("withoutPrototype");
    }
    
    @Benchmark
    public void testBuilderPattern() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
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
    public void testWithoutBuilderPattern() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            // users.add(new User(1, new FullName("Raven", "Christian"), 20, new Address("Kembangan", "21", "20192", "Jakarta Barat", "Indonesia")));
            // users.add(new User(0, new FullName("Raven", "Christian"), 0, null)); // kita harus specify apa nilai default untuk setiap tipe data dari parameter constructor yang seharusnya tidak perlu dilakukan
            users.add(new User(0, new FullName("Raven", ""), 0, null)); // pada class FullName, juga dibuat 2 constructor, satu untuk menampung 2 parameter yang isinya firstName dan lastName, sisanya untuk menampung firstName, middleName, dan lastName
        }
        ResourceMonitor.logAll("withoutBuilderPattern");
    }
}
