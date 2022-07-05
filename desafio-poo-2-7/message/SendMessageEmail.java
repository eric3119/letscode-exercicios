package message;

import java.util.List;

import formatters.Formatter;
import model.Message;

public class SendMessageEmail extends SendMessage {

    private List<Formatter> formatters;

    public SendMessageEmail(List<Formatter> formatters){
        this.formatters = formatters;
    }

    public void sendMessage(Message message) {
        for (Formatter formatter : formatters) {
            formatter.format(message);
        }

        System.out.println("-------------------------------------");
        System.out.println("Mensagem enviada");
        System.out.println(message);
        System.out.println("-------------------------------------");
    }

}