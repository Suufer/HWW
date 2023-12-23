public class Radio {
    private static final int MIN_STATION = 0;
    private static final int MAX_STATION = 9;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= MIN_STATION && station <= MAX_STATION) {
            this.currentStation = station;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < MAX_VOLUME) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > MIN_VOLUME) {
            currentVolume--;
        }
    }

    public void nextStation() {
        if (currentStation == MAX_STATION) {
            currentStation = MIN_STATION;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == MIN_STATION) {
            currentStation = MAX_STATION;
        } else {
            currentStation--;
        }
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }
}
