package controller.action;

import controller.action.commands.*;

/**
 * Created by draqo on 24.07.2017.
 */
public enum  CommandEnum {

    DELETEBYID{
        {
            this.command = new DeleteByIdCommand();
        }
    },
    FINDBYID{
        {
            this.command = new FindByIdCommand();
        }

    },
    ADDBOOK{
        {
            this.command = new AddBookCommand();
        }
    },

    SELECTALLFIELDS{
        {
            this.command = new SelectAllFieldsCommand();
        }
    };


   ActionCommand command;
    public ActionCommand getCurrentCommand(){
        return command;
    }


}
