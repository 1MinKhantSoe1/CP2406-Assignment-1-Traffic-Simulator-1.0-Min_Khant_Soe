import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoadTest
{

    Road road = new Road("0", 1, 5, new int[]{0, 0});

    @Test
    void getId()
    {
        assertEquals("road_0", road.getId());
    }

    @Test
    void getSpeedLimit()
    {
        assertEquals(1, road.getspeed_limit());
    }

    @Test
    void getLength()
    {
        assertEquals(5, road.getLength());
    }

    @Test
    void getstart_location()
    {
        int[] expected = {0, 0};
        assertArrayEquals(expected, road.getstart_location());
    }

    @Test
    void getend_location()
    {
        int[] expected = {5, 0};
        assertArrayEquals(expected, road.getend_location());
    }

    @Test
    void getCars()
    {
        ArrayList<Car> expected = new ArrayList<>();
        assertEquals(expected, road.getcars_on_road());
    }

    @Test
    void getLights()
    {
        ArrayList<Traffic_Light> expected = new ArrayList<>();
        assertEquals(expected, road.getlights_on_road());
    }

    @Test
    void getconnected_roads()
    {
        ArrayList<Road> expected = new ArrayList<>();
        assertEquals(expected, road.getconnected_roads());
    }
}