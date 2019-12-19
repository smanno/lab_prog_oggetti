package generics;

import java.util.List;

public class Hub<T extends IotProducer> {
    List<IotDevice<T>> devices; // forzo i device della lista ad essere dello stesso tipo della classe

    public void addDevice(IotDevice<T> device) {
        devices.add(device);
    }

    public void sendMessage(String msg, IotDevice<T> receiver){
        for(IotDevice dev:devices){
            if(dev.isEqual(receiver)){
                dev.receive
            }
        }
    }
}
