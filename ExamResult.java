/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ExamResult {

    private Exam e;
    private Student s;
    private int mark;
    private ArrayList<String> studentAnswers;

    public ExamResult(Exam e, Student s, int mark, ArrayList<String> studentAnswers) {
        this.e = e;
        this.s = s;
        this.mark = mark;
        this.studentAnswers = studentAnswers;
    }

    public ExamResult(Exam e, Student s, int mark) {
        this.e = e;
        this.s = s;
        this.mark = mark;
    }

    public String getStudentAnswers(int i) {
        return studentAnswers.get(i);
    }

    public void setStudentAnswers(ArrayList<String> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public Exam getE() {
        return e;
    }

    public void setE(Exam e) {
        this.e = e;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

}
