package formatters;

import model.Message;

public class RemoveAccent implements Formatter {

    @Override
    public void format(Message message) {
        String text = message.getMessage();
        message.setMessage(text.replaceAll("[^a-zA-Z0-9]", "_"));
    }

}
