package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.KanBugTracker;
import seedu.address.model.ReadOnlyKanBugTracker;
import seedu.address.model.bug.Bug;
import seedu.address.model.bug.Description;
import seedu.address.model.bug.Name;
import seedu.address.model.bug.State;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code KanBugTracker} with sample data.
 */
public class SampleDataUtil {
    public static Bug[] getSampleBugs() {
        return new Bug[] {
            new Bug(new Name("Bug 1"), new State("backlog"),
                new Description("Description of bug 1"),
                getTagSet("JavaFX")),
            new Bug(new Name("Bug 2"), new State("backlog"),
                new Description("Description of bug 2"),
                getTagSet("JavaFX", "frontend")),
        };
    }

    public static ReadOnlyKanBugTracker getSampleKanBugTracker() {
        KanBugTracker sampleAb = new KanBugTracker();
        for (Bug sampleBug : getSampleBugs()) {
            sampleAb.addBug(sampleBug);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
