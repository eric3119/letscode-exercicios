import java.util.List;

import formatters.CamelCase;
import formatters.LowerCase;
import formatters.RemoveAccent;
import formatters.UpperCase;
import message.SendMessage;
import message.SendMessageEmail;
import model.Message;

public class Main {
    public static void main(String[] args) {
        SendMessage sendMessage = new SendMessageEmail(List.of(
                new CamelCase()
                // new LowerCase()
                // new UpperCase()
                // new RemoveAccent()
                ));

        Message message = new Message()
            .setSubject("subject")
            .setMessage("Lorem ipsum dolor sit amet, qui minim labore adipisicing minim sint cillum sint consectetur cupidatat.");

        sendMessage.sendMessage(message);
    }
}
