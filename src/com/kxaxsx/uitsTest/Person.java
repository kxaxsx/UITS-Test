package com.kxaxsx.uitsTest;

import java.time.LocalDate;

public class Person implements Comparable {

    private String name;
    private String middleName;
    private String lastName;
    private LocalDate birthday;

    public Person(String name, String middleName, String lastName, LocalDate birthday) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Customer other = (Customer) o;

        //Compare by last name first
        int lastnameCompare = getLastName().compareTo(other.getLastName());

        if (lastnameCompare < 0)
            return -1;
        if (lastnameCompare > 0)
            return 1;

        //if last name is the same, then compare by the name
        int nameCompare = getName().compareTo(other.getName());

        if (nameCompare < 0)
            return -1;
        if (nameCompare > 0)
            return 1;

        //eventually compare by middle name

        int middleNameCompare = getMiddleName().compareTo(other.getMiddleName());

        if (middleNameCompare < 0)
            return -1;
        if (middleNameCompare > 0)
            return 1;

        //Person's last name, name and middle name are the same
        return 0;
    }
}
