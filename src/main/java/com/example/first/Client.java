package com.example.first;

public class Client {
    private String firstName;
    private String midName;
    private String lastName;
    int age;

    public Client(String firstName, String midName, String lastName, int age) {
        this.firstName = firstName;
        this.midName = midName;
        this. lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + midName + ", " + String.valueOf(age);
    }

    public static class Builder {
        private String firstName;
        private String midName;
        private String lastName;
        int age;

        public  Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public  Builder midName(String midName) {
            this.midName = midName;
            return this;
        }
        public  Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public  Builder age(int age) {
            this.age = age;
            return this;
        }
        public Client build() {
            return new Client(firstName,midName,lastName,age);
        }
    }
}
