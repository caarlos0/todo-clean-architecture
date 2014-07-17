package todo.utils;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static todo.utils.Strings.isNullOrEmpty;

public class StringsTest {

    @Test
    public void testNull() throws Exception {
        assertThat(isNullOrEmpty(null), equalTo(true));
    }

    @Test
    public void testEmpty() throws Exception {
        assertThat(isNullOrEmpty(""), equalTo(true));
    }

    @Test
    public void testSpaces() throws Exception {
        assertThat(isNullOrEmpty("  "), equalTo(true));
    }

    @Test
    public void testNonEmpty() throws Exception {
        assertThat(isNullOrEmpty(" Clean Code "), equalTo(false));
    }
}
