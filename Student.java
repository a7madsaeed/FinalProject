/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author HP
 */
public class Student extends User {

    private static int id;
    private int universityId;
    private double avg;

    public Student(String username, String password, String name, String birthday,
            Gender gender) {
        super(username, password, name, birthday, gender);
        if (gender == Gender.male) {

            this.universityId = 120220000;
            this.universityId += id++;
        } else {
            this.universityId = 220220000;
            this.universityId += id++;
        }
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

}
