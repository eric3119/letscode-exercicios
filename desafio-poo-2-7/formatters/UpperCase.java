package formatters;

import model.Message;

public class UpperCase implements Formatter {

    @Override
    public void format(Message message) {
        String text = message.getMessage();
        message.setMessage(text.toUpperCase());
    }
    
}
