import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Traffic_Light_Test
{
    Road road = new Road("0", 1, 5, new int[]{0, 0});
    Traffic_Light light = new Traffic_Light("0", road);

    @Test
    void testOperate()
    {
        light.operate(3515);
        assertEquals("green", light.getState());
    }

    @Test
    void getState()
    {
        assertEquals("red", light.getState());
    }

    @Test
    void getRoad()
    {
        assertEquals(road, light.getroad_attached_to());
    }

    @Test
    void getPosition()
    {
        assertEquals(5, light.getPosition());
    }

    @Test
    void getId()
    {
        assertEquals("light_0", light.getId());
    }
}