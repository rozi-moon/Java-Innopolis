package homework05;

import java.util.Objects;

public class Television {
    private Integer channel;
    private String model;
    private Integer volume;
    private boolean isOn;

    public Television(Integer channel, String model, Integer volume, boolean isOn) {
        this.channel = channel;
        this.model = model;
        this.volume = volume;
        this.isOn = isOn;
    }

    @Override
    public String toString() {
        return "Television{" +
                "channel=" + channel +
                ", model='" + model + '\'' +
                ", volume=" + volume +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return isOn == that.isOn && Objects.equals(channel, that.channel) && Objects.equals(model, that.model) && Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channel, model, volume, isOn);
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
