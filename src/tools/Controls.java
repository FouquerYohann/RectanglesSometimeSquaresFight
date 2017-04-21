package tools;

import components.enums.CommandeMovement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Controls {
    private static final String PRESSED = "pressed ";
    private static final String RELEASED = "released ";
    private JComponent component;
    private Map<String, CommandeMovement> pressedKeys = new HashMap<String, CommandeMovement>();
    private Timer timer;
    private CommandeMovement current = CommandeMovement.NEUTRAL;


    public Controls(JComponent component) {
        super();
        this.component = component;
    }

    public CommandeMovement getCurrent() {
        return current;
    }

    public void addAction(String name, CommandeMovement cmd) {

        int offset = name.lastIndexOf(" ");
        String key = (offset == -1) ? name : name.substring(offset + 1);
        String modifiers = name.replace(key, "");

        InputMap inmap = component
                .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actmap = component.getActionMap();

        myAction pressedAct = new myAction(key, cmd);
        String pressedKey = modifiers + PRESSED + key;
        KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(pressedKey);
        inmap.put(pressedKeyStroke, pressedKey);
        actmap.put(pressedKey, pressedAct);

        myAction releasedAct = new myAction(key, null);
        String releasedKey = modifiers + RELEASED + key;
        KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(releasedKey);
        inmap.put(releasedKeyStroke, releasedKey);
        actmap.put(releasedKey, releasedAct);

    }

    public void handleKeyEvent(String key, CommandeMovement command) {
        if (command == null) {
            if (current == pressedKeys.remove(key))
                for (CommandeMovement tmp : pressedKeys.values()) {
                    current = tmp;
                    break;
                }
        } else
            pressedKeys.put(key, command);

        if (pressedKeys.size() == 1) {
            if (current == CommandeMovement.NEUTRAL)
                current = command;
        }
        if (pressedKeys.size() == 0) {
            current = CommandeMovement.NEUTRAL;
        }
    }

    private class myAction extends AbstractAction implements ActionListener {
        private CommandeMovement command;

        public myAction(String name, CommandeMovement cm) {
            super(name);

            this.command = cm;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            handleKeyEvent((String) getValue(NAME), command);
        }

    }


}
