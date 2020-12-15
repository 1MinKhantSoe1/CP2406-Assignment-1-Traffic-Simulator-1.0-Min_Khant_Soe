public class Car
{

    String id; // unique identifier
    static float length; // number of segments occupied, 1 for ease of prototype.
    private static float breadth;
    private int speed; //segments moved per turn
    private int position; // position on current road
    private Road current_road; // current Road object
    private static final int stopped = 0; //car speed is 0m/s
    private static final int next_road_index = 0;
    private static final int start_position = 1;



    public Car(String id, Road current_road)
    {
        this.id = "car_" + id;
        this.current_road = current_road;
        length = 1f; // cars made 1m long for prototype.
        breadth = length * 0.5f;
        speed = 0;
        position = 1;
        this.current_road.getcars_on_road().add(this); //add this car to the road its on.
    }

    public Car()
    {
        id = "000";
        length = 1f;
        breadth = length * 0.5f;
        speed = 0;
        position = 1;
    }

    public void move()
    {
        this.speed = this.current_road.getspeed_limit(); //set speed limit to that of current_road

        if (!this.current_road.getlights_on_road().isEmpty() && this.position == this.current_road.getlights_on_road().get(0).getPosition() && this.current_road.getlights_on_road().get(0).getState().equals("red"))
        {
            this.speed = stopped;
        }
        else
            {
            this.speed = this.current_road.getspeed_limit();
            if (this.current_road.getLength() == this.getPosition() && !this.current_road.getconnected_roads().isEmpty())
            {

                this.current_road.getcars_on_road().remove(this);
                this.current_road = this.current_road.getconnected_roads().get(next_road_index);
                this.current_road.getcars_on_road().add(this);
                this.position = start_position;

            }

            else if (this.current_road.getLength() > this.getPosition())
            {
                this.position = (this.position + this.speed);
            }

            else
                {
                this.speed = stopped;
            }
        }
    }

    public void printCarStatus()
    {
        System.out.printf("%s going:%dm/s on %s at position:%s%n", this.getId(), this.getSpeed(), this.getcurrent_road().
                getId(), this.getPosition());
    }

    public float getLength()
    {
        return length;
    }

    public void setLength(float length)
    {
        Car.length = length;
    }

    public float getBreadth()
    {
        return breadth;
    }

    public void setBreadth(float breadth)
    {
        Car.breadth = breadth;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public Road getcurrent_road()
    {
        return current_road;
    }

    public void setcurrent_road(Road current_road)
    {
        this.current_road = current_road;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}

