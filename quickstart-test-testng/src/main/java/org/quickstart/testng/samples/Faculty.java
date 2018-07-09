package org.quickstart.testng.samples;

public class Faculty implements IPerson {

    private String fullName;

    public Faculty(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

}
