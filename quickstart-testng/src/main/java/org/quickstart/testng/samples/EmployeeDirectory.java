package org.quickstart.testng.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDirectory {

    private List<IPerson> directory;

    public EmployeeDirectory() {
        directory = new ArrayList<>();
    }

    public void add(IPerson person) {
        directory.add(person);
    }

    public void delete(IPerson person) {
        directory.remove(person);
    }

    public IPerson getFirstPerson() {
        return directory.get(0);
    }

    public List<String> getAllNames() {
        List<String> names = directory.stream().map(IPerson::getFullName).collect(Collectors.toList());
        return names;
    }

    public int size() {
        return directory.size();
    }

}
