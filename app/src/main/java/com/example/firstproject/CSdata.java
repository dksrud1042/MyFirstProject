package com.example.firstproject;

public class CSdata {

    private String name;
    private int grade;
    private int allergies;
    private int oily_skin;
    private int dry_skin;
    private int sensitivity_skin;

    public CSdata(String name, int grade, int allergies, int oily_skin, int dry_skin, int sensitivity_skin){
        this.name = name;
        this.grade = grade;
        this.allergies = allergies;
        this.oily_skin = oily_skin;
        this.dry_skin = dry_skin;
        this.sensitivity_skin = sensitivity_skin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAllergies() {
        return allergies;
    }

    public void setAllergies(int allergies) {
        this.allergies = allergies;
    }

    public int getOily_skin() {
        return oily_skin;
    }

    public void setOily_skin(int oily_skin) {
        this.oily_skin = oily_skin;
    }

    public int getDry_skin() {
        return dry_skin;
    }

    public void setDry_skin(int dry_skin) {
        this.dry_skin = dry_skin;
    }

    public int getSensitivity_skin() {
        return sensitivity_skin;
    }

    public void setSensitivity_skin(int sensitivity_skin) {
        this.sensitivity_skin = sensitivity_skin;
    }

    @Override
    public String toString() {
        return "Csvsample{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", allergies=" + allergies +
                ", oily_skin=" + oily_skin +
                ", dry_skin=" + dry_skin +
                ", sensitivity_skin=" + sensitivity_skin +
                '}';
    }
}