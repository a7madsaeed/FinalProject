/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author HP
 */
public class Question {

    private static int id;
    private int Qid;
    private String name;
    private int mark;
    private String img;

    public Question(String name, int mark, String img) {
        id++;
        this.Qid = id;
        this.name = name;
        this.mark = mark;
        this.img = img;
    }

    public int getQid() {
        return Qid;
    }

    public void setQid(int Qid) {
        this.Qid = Qid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static int getId() {
        return id;
    }
}

class YesOrNo extends Question {

    private boolean correctAnswer;

    public YesOrNo(String name, int mark, String img, boolean correctAnswer) {
        super(name, mark, img);
        this.correctAnswer = correctAnswer;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}

class Multiplechoice extends Question {

    private String[] answers;
    private String correctAnswer;

    public Multiplechoice(String name, int mark, String img, String[] answers, String correctAnswer, String formattedAnswers) {
        super(name, mark, img);
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Multiplechoice(String name, int mark, String img, String[] answers, String correctAnswer) {
        super(name, mark, img);
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getAnswers() {
        System.out.print("[");
        for (int i = 0; i < answers.length; i++) {

            System.out.print(answers[i]);
            if (i != answers.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        return "";

    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}

class Fillblank extends Question {

    private String correctAnswer;

    public Fillblank(String name, int mark, String img, String correctAnswer) {
        super(name, mark, img);
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
