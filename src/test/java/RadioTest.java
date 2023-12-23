import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    @Test
    public void testSetCurrentStationWithinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationOutOfRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation()); // Вернется к минимальному значению
    }

    @Test
    public void testIncreaseVolumeWithinRange() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 110; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeWithinRange() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeAtMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testNextStationWithinRange() {
        Radio radio = new Radio();
        radio.nextStation();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void testNextStationWrapAround() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationWithinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationWrapAround() {
        Radio radio = new Radio();
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }


    @Test
    public void testSetCurrentStationNegative() {
        Radio radio = new Radio();
        radio.setCurrentStation(-5);
        assertEquals(0, radio.getCurrentStation()); // Отрицательные значения должны быть проигнорированы
    }

    @Test
    public void testSetCurrentStationZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation()); // Вернется к минимальному значению
    }
}