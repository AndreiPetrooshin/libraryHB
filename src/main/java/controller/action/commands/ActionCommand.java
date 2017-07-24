package controller.action.commands;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by draqo on 24.07.2017.
 */
public interface ActionCommand {

    void execute(HttpServletRequest request);
}
