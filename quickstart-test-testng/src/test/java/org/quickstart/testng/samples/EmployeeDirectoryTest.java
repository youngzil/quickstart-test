package org.quickstart.testng.samples;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class EmployeeDirectoryTest {

    /**
     * Uses Dummy for {@link IPerson}.
     */
    @Test(groups = {"unit"})
    public void addPersonToEmployeeDirectory() {
        IPerson dummy = null;
        EmployeeDirectory directory = new EmployeeDirectory();
        directory.add(dummy);

        assertEquals(directory.size(), 1);
    }

    /**
     * Test for Stub.
     */
    @Test(groups = {"unit"})
    public void checkFirstPersonNameInTheDirectory() {
        IPerson stub = mock(Faculty.class);
        when(stub.getFullName()).thenReturn("I am a Stub");

        EmployeeDirectory directory = new EmployeeDirectory();
        directory.add(stub);
        assertEquals(directory.getAllNames().get(0), "I am a Stub");
    }

    /**
     * Test for Spy.
     */
    @Test(groups = {"unit"})
    public void checkFirstNameFunctionInvocation() {
        IPerson spy = spy(IPerson.class);
        EmployeeDirectory directory = new EmployeeDirectory();
        directory.add(spy);
        directory.getAllNames();
        verify(spy, times(1)).getFullName();
        assertNull(directory.getAllNames().get(0));
    }

    /**
     * Test for Mock.
     */
    @Test(groups = {"unit"})
    public void checkFirstNameFunction() {
        IPerson mock = mock(IPerson.class);
        EmployeeDirectory directory = new EmployeeDirectory();

        System.out.println(mock.getFullName());

        when(mock.getFullName()).thenReturn("I am a mock");
        directory.add(mock);
        directory.getAllNames();

        verify(mock, times(1)).getFullName();
        assertEquals(directory.getAllNames().get(0), "I am a mock");
    }

    /**
     * Test for exceptions.
     */
    @Test(expectedExceptions = {IndexOutOfBoundsException.class}, groups = "unit")
    public void shouldThrowExceptionWhenAccessingFirstPersonOnEmptyDirectory() {
        EmployeeDirectory directory = new EmployeeDirectory();
        directory.getFirstPerson();
    }

}
