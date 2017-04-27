package tools;

import components.enums.Commande;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Controls {
    private static final String PRESSED = "pressed ";
    private static final String RELEASED = "released ";
    private JComponent component;
    private Map<String, Commande> pressedKeys = new HashMap<String, Commande>();
    private Timer timer;
    private Commande current = Commande.NEUTRAL;


    public Controls(JComponent component) {
        super();
        this.component = component;
    }

    public Commande getCurrent() {
        return current;
    }

    public void addAction(String name, Commande cmd) {

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

    public void handleKeyEvent(String key, Commande command) {
        if (command == null) {
            if (current == pressedKeys.remove(key))
                for (Commande tmp : pressedKeys.values()) {
                    current = tmp;
                    break;
                }
        } else
            pressedKeys.put(key, command);

        if (pressedKeys.size() == 1) {
            if (current == Commande.NEUTRAL)
                current = command;
        }
        if (pressedKeys.size() == 0) {
            current = Commande.NEUTRAL;
        }
    }

    private class myAction extends AbstractAction implements ActionListener {
        private Commande command;

        public myAction(String name, Commande cm) {
            super(name);

            this.command = cm;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            handleKeyEvent((String) getValue(NAME), command);
        }

    }


}
