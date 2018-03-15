package yurchello.guava.examples.collections;

import com.google.common.collect.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class CollectionAppTest {
    @Test
    public void testMultiset(){
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("d");
        multiset.add("c");
        multiset.add("b");
        multiset.add("c");
        multiset.add("a");
        multiset.forEach(System.out::println);
    }

    @Test
    public void testMultimap(){
        Multimap<Integer, String> multimap = ArrayListMultimap.create();
        multimap.put(2,"aaa");
        multimap.put(1,"bbb");
        multimap.put(1,"ccc");
        System.out.println(multimap.get(1));
    }

    @Test
    public void givenRangeSet() {
        RangeSet<Integer> numberRangeSet = TreeRangeSet.create();

        numberRangeSet.add(Range.closed(0, 2));
        numberRangeSet.add(Range.closed(3, 5));
        numberRangeSet.add(Range.closed(6, 8));

        assertTrue(numberRangeSet.contains(1));
        assertFalse(numberRangeSet.contains(9));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void immutableSet() {
        final Set<String> colours = ImmutableSet.of(
                "red",
                "green",
                "blue");
        colours.remove("green");
    }
}