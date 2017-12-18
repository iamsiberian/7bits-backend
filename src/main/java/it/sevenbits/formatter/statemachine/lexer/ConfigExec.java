package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.State;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author Minyukhin Ilya
 */
public class ConfigExec implements ICreateCommand {

    //private static final String COMMAND_PACKAGE = "it.sevenbits.formatter.statemachine.lexer.commands";

    private CommandRepository commands;
    private StateTransitions transitions;

    /**
     *
     */
    public ConfigExec() {
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
                String nextstate = actionDef.get("nextstate").toString();

                try {
                    commands.put(new State(stateName), input, createCommand(command));
                    transitions.put(new State(stateName), input, new State(nextstate));
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ICommand createCommand(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (ICommand) Class.forName("it.sevenbits.formatter.statemachine.lexer.commands." + className).newInstance();
    }

    public CommandRepository getRepository() {
        return commands;
    }

    public StateTransitions getTransitions() {
        return transitions;
    }
}
