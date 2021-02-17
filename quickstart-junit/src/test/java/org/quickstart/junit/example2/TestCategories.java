package org.quickstart.junit.example2;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@SuiteClasses({AA.class, BB.class}) // Note that Categories is a kind of Suite
public class TestCategories {
    // Will run A.b and B.c, but not A.a
}
