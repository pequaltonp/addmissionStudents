package javaee;

import java.time.LocalDate;

public class Student {
    private long id;
    private String name;
    private String surname;
    private String middleName = " ";
    private LocalDate birthdate;
    private String iin;
    private boolean isGrant;
    private String speciality;

    public Student() {

    }

    public Student(String name, String surname, LocalDate birthdate,
                   String iin, boolean isGrant, String speciality) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.iin = iin;
        this.isGrant = isGrant;
        this.speciality = speciality;
    }

    public Student(String name, String surname, String middleName,
                   LocalDate birthdate, String iin, boolean isGrant, String speciality) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthdate = birthdate;
        this.iin = iin;
        this.isGrant = isGrant;
        this.speciality = speciality;
    }

    public Student(long id, String name, String surname, String middleName,
                   LocalDate birthdate, String iin, boolean isGrant, String speciality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthdate = birthdate;
        this.iin = iin;
        this.isGrant = isGrant;
        this.speciality = speciality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate =  birthdate;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getIin() {
        return iin;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public String getSpeciality() {
        return speciality;
    }


    /*
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthdate=" + birthdate +
                ", iin='" + iin + '\'' +
                ", isGrant=" + isGrant +
                ", speciality='" + speciality + '\'' +
                '}';
    }*/
}
