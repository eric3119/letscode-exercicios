package formatters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Message;

public class CamelCase implements Formatter {

    @Override
    public void format(Message message) {
        String text = message.getMessage();

        List<String> words = Arrays.asList(text.split(" ")).stream().map(
                word -> word.trim().toLowerCase()).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1);
            builder.append(word);
        }

        message.setMessage(Character.toLowerCase(builder.charAt(0)) + builder.substring(1));
    }

}
