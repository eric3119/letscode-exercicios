package formatters;

import model.Message;

public class LowerCase implements Formatter {

    @Override
    public void format(Message message) {
        String text = message.getMessage();
        message.setMessage(text.toLowerCase());
    }

}
