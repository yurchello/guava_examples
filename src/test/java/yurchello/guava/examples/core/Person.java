package yurchello.guava.examples.core;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private String lastName;
    private String middleName;
    private String firstName;
    private int zipCode;

    @Override
    public int compareTo(Person other) {
        return ComparisonChain.start()
                .compare(lastName, other.lastName)
                .compare(firstName, other.firstName)
                .compare(middleName, other.middleName, Ordering.natural().nullsLast())
                .compare(zipCode, other.zipCode)
                .result();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return Objects.equals(lastName, other.lastName)
                && Objects.equals(middleName, other.middleName)
                && Objects.equals(firstName, other.firstName)
                && zipCode == other.zipCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, middleName, firstName, zipCode);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("lastName", lastName)
                .add("middleName", middleName)
                .add("firstName", firstName)
                .add("zipCode", zipCode)
                .toString();
    }

    public String toString2() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .addValue( lastName)
                .addValue( middleName)
                .addValue( firstName)
                .addValue(zipCode)
                .toString();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
