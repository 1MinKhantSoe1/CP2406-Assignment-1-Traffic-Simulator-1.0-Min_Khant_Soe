import java.util.Random;

public class Traffic_Light
{
    private String id;
    private static final String green = "green";
    private static final String red = "red";
    private static final double change_green = 0.5; // 50/50 chance of changing state.
    private String state;
    private int position;
    private Road road_attached_to;

    public Traffic_Light(String id, Road road)
    {
        this.id = "light_" + id;
        state = red;
        this.road_attached_to = road;
        position = this.road_attached_to.getLength(); // always places the traffic light at the end of the road_attached_to.
        this.road_attached_to.getlights_on_road().add(this); // adds this light to the road it belongs to.
    }

    public void operate(int seed)
    {
        Random random = new Random(seed);
        double probability = random.nextDouble();

        if (probability > change_green)
        {
            this.setState(green);
        }

        else
            {
            this.setState(red);
        }
    }

    public void print_light_status()
    {
        System.out.printf("%s is:%s on %s at position:%s%n", this.getId(), this.getState(), this.getroad_attached_to().getId(), this.getPosition());
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Road getroad_attached_to()
    {
        return road_attached_to;
    }

    public void setroad_attached_to(Road road_attached_to) {
        this.road_attached_to = road_attached_to;
    }

    public int getPosition()
    {
        return position;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }
}
