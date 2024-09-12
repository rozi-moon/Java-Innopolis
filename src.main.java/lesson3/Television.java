package lesson3;

public class Television {
    private Integer channel;
    private String model;
    private String color;
    public Television(Integer channel, String model, String color) {
        this.channel = channel;
        this.model = model;
        this.color = color;


    }

    @Override
    public String toString() {
        return "Television{" +
                "channel=" + channel +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
