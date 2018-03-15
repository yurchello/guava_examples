package yurchello.guava.examples.io;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class IOTest {

    @Test(expectedExceptions = Exception.class)
    public void ioTest() throws IOException {
        File file = new File("");
        URL url = new URL("");

        ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();

        // Count distinct word occurrences in a file
        Multiset<String> wordOccurrences = HashMultiset.create(
                Splitter.on(CharMatcher.WHITESPACE)
                        .trimResults()
                        .omitEmptyStrings()
                        .split(Files.asCharSource(file, Charsets.UTF_8).read()));

        // SHA-1 a file
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha1());

        // Copy the data from a URL to a file
        Resources.asByteSource(url).copyTo(Files.asByteSink(file));
    }
}
