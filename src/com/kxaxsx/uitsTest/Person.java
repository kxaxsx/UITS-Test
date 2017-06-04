package com.kxaxsx.uitsTest;

import java.time.LocalDate;

public class Person implements Comparable {

    private String name;
    private String middleName;
    private String lastName;
    private LocalDate birthday;

    /**
     * Constructs a person object.
     *
     * @param name       customers name
     * @param middleName customers middle name
     * @param lastName   customers last name
     * @param birthday   customers birthday
     */
    public Person(String name, String middleName, String lastName, LocalDate birthday) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    /**
     * Returns the name of this person.
     *
     * @return the name of this person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this person.
     *
     * @param name this person's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the middle name of this person.
     *
     * @return the middle name of this person
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name of this person.
     *
     * @param middleName this person's name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Returns the last name of this person.
     *
     * @return the last name of this person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of this person.
     *
     * @param lastName this person's name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a birthday of this person.
     *
     * @return a birthday of this person
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Sets a birthday of this person.
     *
     * @param birthday birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person.
     */
    @Override
    public String toString() {
        return lastName + ' ' + name + ' ' + ' '
                + middleName +
                ", birthday: " + birthday;
    }

    /**
     * Compares this person with the specified person for order.
     * First comparison by the last name, if its the same,
     * then by the name and at last by the middle name
     * Returns a negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o other person to compare
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
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
