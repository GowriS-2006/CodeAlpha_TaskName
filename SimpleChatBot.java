import java.awt.*;
import java.util.*;
import javax.swing.*;

public class SimpleChatBot extends JFrame {
    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;
    Map<String, String> responses;

    public SimpleChatBot() {
        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField = new JTextField();
        sendButton = new JButton("Send");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);

        responses = new HashMap<>();
        responses.put("hello", "Hi! How can I help you?");
        responses.put("name", "I am your AI Chatbot.");
        responses.put("weather", "I hope it’s sunny today!");
        responses.put("time", "Please check your clock.");
        responses.put("bye", "Goodbye! Take care!");

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    void sendMessage() {
        String user = inputField.getText().toLowerCase().trim();
        if (user.isEmpty()) return;
        chatArea.append("You: " + user + "\n");
        chatArea.append("Bot: " + getReply(user) + "\n\n");
        inputField.setText("");
    }

    String getReply(String msg) {
        for (String key : responses.keySet()) {
            if (msg.contains(key)) return responses.get(key);
        }
        return "Sorry, I didn’t understand that.";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleChatBot().setVisible(true));
    }
}
