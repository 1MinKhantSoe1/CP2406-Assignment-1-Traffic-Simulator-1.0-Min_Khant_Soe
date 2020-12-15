import java.util.ArrayList;

public class Road
{

    private String id;
    private int speed_limit;
    private int length;
    private int[] start_location;
    private int[] end_location;
    private ArrayList<Car> cars_on_road = new ArrayList<>();
    private ArrayList<Traffic_Light> lights_on_road = new ArrayList<>();
    private ArrayList<Road> connected_roads = new ArrayList<>();

    public Road(String id, int speed_limit, int length, int[] start_location)
    {

        this.id = "road_" + id;
        this.speed_limit = speed_limit;
        this.length = length;
        this.start_location = start_location;
        this.end_location = new int[]{this.length + this.start_location[0], 0}; //only works for horizontal roads;
    }


    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getspeed_limit()
    {
        return speed_limit;
    }

    public void setspeed_limit(int speed_limit)
    {
        this.speed_limit = speed_limit;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public String printstart_location()
    {
        return start_location[0] + "," + start_location[1];
    }

    public void setstart_location(int[] start_location)
    {
        this.start_location = start_location;
        this.end_location = new int[]{this.length + this.start_location[0], 0}; //only works for horizontal roads;
    }

    public String printend_location()
    {
        return end_location[0] + "," + end_location[1];
    }

    public void print_road_info()
    {
        System.out.printf("%s limit of:%dm/s is %dm long at location:%s to %s%n", this.getId(), this.getspeed_limit(), this.getLength(), this.printstart_location(), this.printend_location());
    }

    public void setend_location(int[] end_location)
    {
        this.end_location = end_location;
    }

    public int[] getstart_location()
    {
        return start_location;
    }

    public int[] getend_location()
    {
        return end_location;
    }

    public ArrayList<Car> getcars_on_road()
    {
        return cars_on_road;
    }

    public void setcars_on_road(ArrayList<Car> cars_on_road)
    {
        this.cars_on_road = cars_on_road;
    }

    public ArrayList<Traffic_Light> getlights_on_road()
    {
        return lights_on_road;
    }

    public void setlights_on_road(ArrayList<Traffic_Light> lights_on_road)
    {
        this.lights_on_road = lights_on_road;
    }

    public ArrayList<Road> getconnected_roads()
    {
        return connected_roads;
    }

    public void setconnected_roads(ArrayList<Road> connected_roads)
    {
        this.connected_roads = connected_roads;
    }
}

