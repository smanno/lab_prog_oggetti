package Abstraction.Liskov;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Date;

public class MessageWithImage extends PhoneMessage {
    @Getter @Setter
    Image img;

    public MessageWithImage(String recipient, String sender, Date sendDate, String content, Image img){
        super(recipient, sender, sendDate, content);
        this.img = img;
    }
}
