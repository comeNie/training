package come.comenie.guava.Ranges;

import com.google.common.base.Predicate;
import com.google.common.collect.BoundType;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

import org.junit.Test;

import static com.google.common.collect.BoundType.CLOSED;
import static com.google.common.collect.BoundType.OPEN;
import static com.google.common.collect.DiscreteDomain.integers;
import static org.junit.Assert.*;

/**
 * Created by 波 on 2017/1/11.
 */
public class RangeUtilTest {

    @Test
    public void testOpen() {
        Range<Integer> range =Range.open(4,8);
        checkContains(range);
        assertTrue(range.hasLowerBound());
        assertTrue(range.hasUpperBound());
        assertEquals(BoundType.OPEN,range.lowerBoundType());
        assertEquals(BoundType.OPEN,range.upperBoundType());
        assertEquals(4, (int)range.lowerEndpoint());
        assertEquals(8, (int)range.upperEndpoint());
        assertFalse(range.isEmpty());
    }

    @Test
    public void testOpen_invalid() {
        try {
            Range.open(4, 3);
            fail();
        } catch (IllegalArgumentException expected) {
        }
        try {
            Range.open(3, 3);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    @Test
    public void testClosed() {
        Range<Integer> range = Range.closed(5, 7);
        checkContains(range);
        assertTrue(range.hasLowerBound());
        assertEquals(5, (int) range.lowerEndpoint());
        assertEquals(CLOSED, range.lowerBoundType());
        assertTrue(range.hasUpperBound());
        assertEquals(7, (int) range.upperEndpoint());
        assertEquals(CLOSED, range.upperBoundType());
        assertFalse(range.isEmpty());
        assertEquals("[5‥7]", range.toString());
    }

    @Test
    public void testIsConnected() {
        assertTrue(Range.closed(3, 5).isConnected(Range.open(5, 6)));
        assertTrue(Range.closed(3, 5).isConnected(Range.openClosed(5, 5)));
        assertTrue(Range.open(3, 5).isConnected(Range.closed(5, 6)));
        assertTrue(Range.closed(3, 7).isConnected(Range.open(6, 8)));
        assertTrue(Range.open(3, 7).isConnected(Range.closed(5, 6)));
        assertFalse(Range.closed(3, 5).isConnected(Range.closed(7, 8)));
        assertFalse(Range.closed(3, 5).isConnected(Range.closedOpen(7, 7)));
    }

    @Test
    public void testLessThan() {
        Range<Integer> range = Range.lessThan(5);
        assertTrue(range.contains(Integer.MIN_VALUE));
        assertTrue(range.contains(4));
        assertFalse(range.contains(5));
        assertTrue(range.hasUpperBound());
        assertEquals(5, (int) range.upperEndpoint());
        assertEquals(OPEN, range.upperBoundType());
        assertFalse(range.isEmpty());
        assertEquals("(-\u221e‥5)", range.toString());
    }
    @Test
    public void testClosed_invalid() {
        try {
            Range.closed(4, 3);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    @Test
    public void testEncloses_closed() {
        Range<Integer> range = Range.closed(2, 5);
        assertTrue(range.encloses(range));
        assertTrue(range.encloses(Range.open(2, 5)));
        assertTrue(range.encloses(Range.openClosed(2, 5)));
        assertTrue(range.encloses(Range.closedOpen(2, 5)));
        assertTrue(range.encloses(Range.closed(3, 5)));
        assertTrue(range.encloses(Range.closed(2, 4)));

        assertFalse(range.encloses(Range.open(1, 6)));
        assertFalse(range.encloses(Range.greaterThan(3)));
        assertFalse(range.encloses(Range.lessThan(3)));
        assertFalse(range.encloses(Range.atLeast(3)));
        assertFalse(range.encloses(Range.atMost(3)));
        assertFalse(range.encloses(Range.<Integer>all()));
    }

    @Test
    public void testIntersection_general() {
        Range<Integer> range = Range.closed(4, 8);

        // separate below
        try {
            range.intersection(Range.closed(0, 2));
            fail();
        } catch (IllegalArgumentException expected) {
        }

        // adjacent below
        assertEquals(Range.closedOpen(4, 4),
                range.intersection(Range.closedOpen(2, 4)));

        // overlap below
        assertEquals(Range.closed(4, 6), range.intersection(Range.closed(2, 6)));

        // enclosed with same start
        assertEquals(Range.closed(4, 6), range.intersection(Range.closed(4, 6)));

        // enclosed, interior
        assertEquals(Range.closed(5, 7), range.intersection(Range.closed(5, 7)));

        // enclosed with same end
        assertEquals(Range.closed(6, 8), range.intersection(Range.closed(6, 8)));

        // equal
        assertEquals(range, range.intersection(range));

        // enclosing with same start
        assertEquals(range, range.intersection(Range.closed(4, 10)));

        // enclosing with same end
        assertEquals(range, range.intersection(Range.closed(2, 8)));

        // enclosing, exterior
        assertEquals(range, range.intersection(Range.closed(2, 10)));

        // overlap above
        assertEquals(Range.closed(6, 8), range.intersection(Range.closed(6, 10)));

        // adjacent above
        assertEquals(Range.openClosed(8, 8),
                range.intersection(Range.openClosed(8, 10)));

        // separate above
        try {
            range.intersection(Range.closed(10, 12));
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    @Test
    public void testSpan_general() {
        Range<Integer> range = Range.closed(4, 8);

        // separate below
        assertEquals(Range.closed(0, 8), range.span(Range.closed(0, 2)));
        assertEquals(Range.atMost(8), range.span(Range.atMost(2)));

        // adjacent below
        assertEquals(Range.closed(2, 8), range.span(Range.closedOpen(2, 4)));
        assertEquals(Range.atMost(8), range.span(Range.lessThan(4)));

        // overlap below
        assertEquals(Range.closed(2, 8), range.span(Range.closed(2, 6)));
        assertEquals(Range.atMost(8), range.span(Range.atMost(6)));

        // enclosed with same start
        assertEquals(range, range.span(Range.closed(4, 6)));

        // enclosed, interior
        assertEquals(range, range.span(Range.closed(5, 7)));

        // enclosed with same end
        assertEquals(range, range.span(Range.closed(6, 8)));

        // equal
        assertEquals(range, range.span(range));

        // enclosing with same start
        assertEquals(Range.closed(4, 10), range.span(Range.closed(4, 10)));
        assertEquals(Range.atLeast(4), range.span(Range.atLeast(4)));

        // enclosing with same end
        assertEquals(Range.closed(2, 8), range.span(Range.closed(2, 8)));
        assertEquals(Range.atMost(8), range.span(Range.atMost(8)));

        // enclosing, exterior
        assertEquals(Range.closed(2, 10), range.span(Range.closed(2, 10)));
        assertEquals(Range.<Integer>all(), range.span(Range.<Integer>all()));

        // overlap above
        assertEquals(Range.closed(4, 10), range.span(Range.closed(6, 10)));
        assertEquals(Range.atLeast(4), range.span(Range.atLeast(6)));

        // adjacent above
        assertEquals(Range.closed(4, 10), range.span(Range.openClosed(8, 10)));
        assertEquals(Range.atLeast(4), range.span(Range.greaterThan(8)));

        // separate above
        assertEquals(Range.closed(4, 12), range.span(Range.closed(10, 12)));
        assertEquals(Range.atLeast(4), range.span(Range.atLeast(10)));
    }

    @Test
    public void testApply() {
        Predicate<Integer> predicate = Range.closed(2, 3);
        assertFalse(predicate.apply(1));
        assertTrue(predicate.apply(2));
        assertTrue(predicate.apply(3));
        assertFalse(predicate.apply(4));
    }


    static final DiscreteDomain<Integer> UNBOUNDED_DOMAIN =
            new DiscreteDomain<Integer>() {
                @Override public Integer next(Integer value) {
                    return integers().next(value);
                }

                @Override public Integer previous(Integer value) {
                    return integers().previous(value);
                }

                @Override public long distance(Integer start, Integer end) {
                    return integers().distance(start, end);
                }
            };

    @Test
    public void testCanonical() {
        assertEquals(Range.closedOpen(1, 5),
                Range.closed(1, 4).canonical(integers()));
        assertEquals(Range.closedOpen(1, 5),
                Range.open(0, 5).canonical(integers()));
        assertEquals(Range.closedOpen(1, 5),
                Range.closedOpen(1, 5).canonical(integers()));
        assertEquals(Range.closedOpen(1, 5),
                Range.openClosed(0, 4).canonical(integers()));

        assertEquals(Range.closedOpen(Integer.MIN_VALUE, 0),
                Range.closedOpen(Integer.MIN_VALUE, 0).canonical(integers()));

        assertEquals(Range.closedOpen(Integer.MIN_VALUE, 0),
                Range.lessThan(0).canonical(integers()));
        assertEquals(Range.closedOpen(Integer.MIN_VALUE, 1),
                Range.atMost(0).canonical(integers()));
        assertEquals(Range.atLeast(0), Range.atLeast(0).canonical(integers()));
        assertEquals(Range.atLeast(1), Range.greaterThan(0).canonical(integers()));

        assertEquals(Range.atLeast(Integer.MIN_VALUE), Range.<Integer>all().canonical(integers()));
    }

    @Test
    public void testCanonical_unboundedDomain() {
        assertEquals(Range.lessThan(0), Range.lessThan(0).canonical(UNBOUNDED_DOMAIN));
        assertEquals(Range.lessThan(1), Range.atMost(0).canonical(UNBOUNDED_DOMAIN));
        assertEquals(Range.atLeast(0), Range.atLeast(0).canonical(UNBOUNDED_DOMAIN));
        assertEquals(Range.atLeast(1), Range.greaterThan(0).canonical(UNBOUNDED_DOMAIN));

        assertEquals(Range.all(), Range.<Integer>all().canonical(UNBOUNDED_DOMAIN));
    }



    private static void checkContains(Range<Integer> range) {
        assertFalse(range.contains(4));
        assertTrue(range.contains(5));
        assertTrue(range.contains(7));
        assertFalse(range.contains(8));
    }

}