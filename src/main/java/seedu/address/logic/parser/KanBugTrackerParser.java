package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_EXTRA_ARGUMENTS;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddTagCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditTagCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.MoveCommand;
import seedu.address.logic.commands.SearchCommand;
import seedu.address.logic.commands.SwitchCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class KanBugTrackerParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case EditTagCommand.COMMAND_WORD:
            return new EditTagCommandParser().parse(arguments);

        case AddTagCommand.COMMAND_WORD:
            return new AddTagCommandParser().parse(arguments);

        case MoveCommand.COMMAND_WORD:
            return new MoveCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            ensureNoArguments(arguments);
            return new ClearCommand();

        case SearchCommand.COMMAND_WORD:
            return new SearchCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            ensureNoArguments(arguments);
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            ensureNoArguments(arguments);
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            ensureNoArguments(arguments);
            return new HelpCommand();
        case SwitchCommand.COMMAND_WORD:
            ensureNoArguments(arguments);
            return new SwitchCommand();
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private void ensureNoArguments(String arguments) throws ParseException {
        if (!arguments.trim().isEmpty()) {
            throw new ParseException(MESSAGE_EXTRA_ARGUMENTS);
        }
    }



}
