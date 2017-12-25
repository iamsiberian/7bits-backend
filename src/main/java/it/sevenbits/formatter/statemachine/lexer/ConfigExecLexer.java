package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.State;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Class-loader configuration files for the lexer
 *
 * @author Minyukhin Ilya
 */
public class ConfigExecLexer implements ICreateCommand {

    private CommandRepository commands;
    private StateTransitions transitions;

    /**
     * The basic constructor that initializes the commands & transitions maps
     */
    public ConfigExecLexer() {
        commands = new CommandRepository();
        transitions = new StateTransitions();

        InputStream file = Lexer.class.getResourceAsStream("/config/statemachinelexer/lexer.yaml");

        Yaml yaml = new Yaml();
        List statesDefs = (List) yaml.load(file);
        for (Object stateDefObject : statesDefs) {
            Map stateDef = (Map) stateDefObject;
            String stateName = stateDef.get("state").toString();
            List actionsDefs = (List) stateDef.get("actions");
            for (Object actionDefObject : actionsDefs) {
                Map actionDef = (Map) actionDefObject;

                Object inputObject = actionDef.get("input");
                Character input;
                if (inputObject == null) {
                    input = null;
                } else {
                    input = inputObject.toString().charAt(0);
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
                    commands.put(new State(stateName), input, ICreateCommand.createCommand(command));
                    transitions.put(new State(stateName), input, transition);
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
