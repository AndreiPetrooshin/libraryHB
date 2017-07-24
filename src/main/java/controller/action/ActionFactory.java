package controller.action;


import controller.action.commands.ActionCommand;
import controller.action.commands.EmptyCommand;

/**
 * Created by draqo on 24.07.2017.
 */

public class ActionFactory{


    public static ActionCommand defineCommand(String action) {
        ActionCommand command = new EmptyCommand();
        if(action==null){
            return  command;
        }
        try {
            String act = action.toUpperCase();
            CommandEnum currentEnum = CommandEnum.valueOf(act);
            command = currentEnum.getCurrentCommand();
        }
        catch (IllegalArgumentException e){
            throw e;
        }
        return command;

    }
}
