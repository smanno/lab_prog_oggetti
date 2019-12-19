package generics;

public class GoogleLamp implements IotDevice<Google> {
    public void turnOn(){};
    public void turnOff(){};

    @Override
    public boolean isEqual(IotDevice<Google> other) {
        return false;
    }
}
