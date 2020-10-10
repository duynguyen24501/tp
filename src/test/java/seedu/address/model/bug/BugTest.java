package seedu.address.model.bug;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_HOMEPAGE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_HOMEPAGE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STATE_HOMEPAGE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalBugs.ALICE;
import static seedu.address.testutil.TypicalBugs.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.BugBuilder;

public class BugTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Bug bug = new BugBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> bug.getTags().remove(0));
    }

    @Test
    public void isSameBug() {
        // same object -> returns true
        assertTrue(ALICE.isSameBug(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameBug(null));

        // different phone and state -> returns false
        Bug editedAlice = new BugBuilder(ALICE).withState(VALID_STATE_HOMEPAGE).build();
        assertFalse(ALICE.isSameBug(editedAlice));

        // different name -> returns false
        editedAlice = new BugBuilder(ALICE).withName(VALID_NAME_HOMEPAGE).build();
        assertFalse(ALICE.isSameBug(editedAlice));

        // same name, same state, different attributes -> returns true
        editedAlice = new BugBuilder(ALICE).withDescription(VALID_DESCRIPTION_HOMEPAGE)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameBug(editedAlice));

        // same name, same phone, same state, different attributes -> returns true
        editedAlice = new BugBuilder(ALICE)
                          .withDescription(VALID_DESCRIPTION_HOMEPAGE).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameBug(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Bug aliceCopy = new BugBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different bug -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Bug editedAlice = new BugBuilder(ALICE).withName(VALID_NAME_HOMEPAGE).build();
        assertFalse(ALICE.equals(editedAlice));

        // different state -> returns false
        editedAlice = new BugBuilder(ALICE).withState(VALID_STATE_HOMEPAGE).build();
        assertFalse(ALICE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new BugBuilder(ALICE).withDescription(VALID_DESCRIPTION_HOMEPAGE).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new BugBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
    }
}
