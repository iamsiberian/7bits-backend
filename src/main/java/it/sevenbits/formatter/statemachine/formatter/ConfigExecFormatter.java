package it.sevenbits.formatter.statemachine.formatter;


import it.sevenbits.formatter.statemachine.State;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Class for the config loading
 *
 * @author Minyukhin Ilya
 */
public class ConfigExecFormatter implements ICreateCommand {
    private CommandRepository commands;
    private StateTransitions transitions;

    /**
     * The basic constructor that initializes the commands & transitions maps
     */
    public ConfigExecFormatter() {
        commands = new CommandRepository();
        transitions = new StateTransitions();

        InputStream file = Formatter.class.getResourceAsStream("/config/statemachineformatter/formatter.yaml");

        Yaml yaml = new Yaml();
        List statesDefs = (List) yaml.load(file);
        for (Object stateDefObject : statesDefs) {
            Map stateDef = (Map) stateDefObject;
            String stateName = stateDef.get("state").toString();
            List actionsDefs = (List) stateDef.get("actions");
            for (Object actionDefObject : actionsDefs) {
                Map actionDef = (Map) actionDefObject;

                //String tokenName = actionDef.get("input").toString();

                Object inputObject = actionDef.get("input");
                String tokenName;
                if (inputObject == null) {
                    tokenName = null;
                } else {
                    tokenName = inputObject.toString();
                }

                String command = actionDef.get("command").toString();

                State transition;
                Object nextstate = actionDef.get("nextstate");
                if (nextstate == null) {
                    transition = null;
                } else {
                    transition = new State(nextstate.toString());
                }

                try {
                    commands.put(new State(stateName), tokenName, ICreateCommand.createCommand(command));
                    transitions.put(new State(stateName), tokenName, transition);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    public CommandRepository getRepository() {
        return commands;
    }

    public StateTransitions getTransitions() {
        return transitions;
    }
}
