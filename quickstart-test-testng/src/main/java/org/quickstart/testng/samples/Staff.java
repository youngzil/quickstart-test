package org.quickstart.testng.samples;

public class Staff implements IPerson {

    private String fullName;

    public Staff(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

}
