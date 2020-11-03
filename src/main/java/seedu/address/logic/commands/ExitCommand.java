package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting KanBug Tracker as requested ...";

    @Override
    public CommandResult execute(Model model) {
        ModelManager.setListViewWindow();
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true, false);
    }

}
