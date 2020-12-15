import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {


        Scanner sim_controller = new Scanner(System.in);

        int road_spawns = 2;
        int car_spawns = 1;
        int light_spawns = 1;


        //Create objects:
        System.out.println("Object Creation:\n---------------------");
        System.out.println("Roads:");
        ArrayList<Road> roads = new ArrayList<>();
        for (int i = 0; i < road_spawns; i++)
        {

            System.out.println("Please input parameters for road_" + i + "...");
            System.out.print("Length:");
            int lengthInput = sim_controller.nextInt();
            int speedLimitInput = 1; // force speed limit to be 1 for prototype.
            roads.add(new Road(Integer.toString(i), speedLimitInput, lengthInput, new int[]{0, 0}));

        }

        System.out.println("\nRoads;");

        for (Road road : roads)
        {
            road.print_road_info();
        }

        System.out.println("\nCars;");
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < car_spawns; i++)
        {
            cars.add(new Car(Integer.toString(i), roads.get(0))); // all created cars will begin on road_0.
            cars.get(i).printCarStatus();
        }

        System.out.println("\nTraffic Lights;");

        ArrayList<Traffic_Light> lights = new ArrayList<>();

        for (int i = 0; i < light_spawns; i++)
        {
            lights.add(new Traffic_Light(Integer.toString(i), roads.get(0))); // all created lights will begin on road_0.
            lights.get(i).print_light_status();
        }

        System.out.println();


        // set locations and connections:
        System.out.println("Settings:");
        roads.get(1).setstart_location(new int[]{roads.get(0).getLength() + 1, 0}); // place road_1 to a position at the end of road_0.
        roads.get(1).print_road_info();
        roads.get(0).getconnected_roads().add(roads.get(1)); // connect road_0 to road_1
        System.out.println();


        //Simulation loop:
        System.out.println("Simulation:");
        Random random = new Random();
        int time = 0;
        System.out.print("Set time scale in milliseconds:");
        int speedOfSim = sim_controller.nextInt();
        int carsFinished = 0;

        while (carsFinished < cars.size())
        {

            for (Traffic_Light light : lights)
            {
                light.operate(random.nextInt());
                light.print_light_status();
            }

            for (Car car : cars)
            {
                car.move();
                car.printCarStatus();

                if (car.getcurrent_road().getconnected_roads().isEmpty() && (car.getSpeed() == 0))
                {
                    carsFinished = carsFinished + 1;
                }
            }

            time = time + 1;
            System.out.println(time + " Seconds have passed.\n");

            try
            {
                Thread.sleep(speedOfSim); // set speed of simulation.
            }

            catch (InterruptedException sim)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}

