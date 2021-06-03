import org.junit.Test;

import static org.junit.Assert.*;

public class TriggerTest {

    @Test
    public void foo() {
        Trigger trigger = new Trigger();
        assertEquals(1, trigger.foo());
    }
}