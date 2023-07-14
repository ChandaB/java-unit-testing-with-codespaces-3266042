import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HairSalonTest {

    HairSalon hairSalon = new HairSalon();

    @Test
    public void testGetOpeningDays() {
        String[] expected = { "Monday", "Tuesday" };
        String[] actualStrings = hairSalon.getOpeningDays();

        assertArrayEquals(expected, actualStrings);

    }

    @Test
    public void testSalonIsOpenOnMonday() {

        boolean actual = hairSalon.isOpen("Monday");
        // Could have also just put the method in the brackets instead of creating a
        // variable actual
        assertTrue(actual);
    }

    @Test
    public void testSalonIsClosedOnWednesday() {

        boolean actual = hairSalon.isOpen("Wednesday");

        assertFalse(actual);

    }

    @Test
    public void testExceptionIsThrownIfWeekdayDoesNotEndInDay() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hairSalon.isOpen("Mon"));
        String expected = "Only weekdays are valid entries.";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

}
