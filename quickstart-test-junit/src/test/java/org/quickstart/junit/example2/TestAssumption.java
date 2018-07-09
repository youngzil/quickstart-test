package org.quickstart.junit.example2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TestAssumption {

    @Test
    public void filenameIncludesUsername() throws IOException {
        assumeThat(File.separatorChar, is('\\'));// 注意和if的区别
        File f = new File("");
        // System.out.println(f.getCanonicalPath());
        assertThat(f.getCanonicalPath(), is("C:\\Users\\hui\\workspace\\junitdemo"));
    }

}
