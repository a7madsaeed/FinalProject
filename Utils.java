/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class Utils {

    public static void addStudent(ArrayList<User> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("student:-");

        String StudentUsername, StudentPassword, SGender;
        boolean isDuplicate;
        Gender StudentGender;
//        username validation 
        do {
            System.out.print("username:");
            StudentUsername = sc.nextLine();

            isDuplicate = false;
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i).getUsername().equals(StudentUsername)) {
                    System.out.println("*username already exist*");
                    isDuplicate = true;
                    break;
                }
            }
        } while (isDuplicate);
//password validation  
        do {
            System.out.print("Password: ");
            StudentPassword = sc.nextLine();
            if (StudentPassword.length() < 6) {
                System.out.println("*password must contain at least 6 characters*");
            }
        } while (StudentPassword.length() < 6);
//name 
        System.out.print("name: ");
        String StudentName = sc.nextLine();
//birthday validation 
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        String StudentBirthday;
        boolean validDate = false;
        do {
            System.out.print("birthday (dd/MM/yyyy): ");
            StudentBirthday = sc.nextLine();
            Matcher matcher = pattern.matcher(StudentBirthday);
            if (matcher.matches()) {
                try {
                    LocalDate birthday = LocalDate.parse(StudentBirthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    int year = birthday.getYear();
                    if (year >= 1900 && year <= 2023) {
                        validDate = true;
                    } else {
                        System.out.println("Invalid year. Please enter a year between 1900 and 2023");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy");
            }
        } while (!validDate);

        LocalDate birthday = LocalDate.parse(StudentBirthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

//gender validation
        do {
            System.out.print("gender: ");
            SGender = sc.nextLine();
            if (SGender.equalsIgnoreCase("male")) {
                StudentGender = Gender.male;
                break;
            } else if (SGender.equalsIgnoreCase("female")) {
                StudentGender = Gender.female;
                break;
            } else {
                System.out.println("Invalid gender. Please enter 'male' or 'female'");
            }
        } while (true);

        if (SGender.equalsIgnoreCase("male")) {
            StudentGender = Gender.male;
        } else {
            StudentGender = Gender.female;
        }

        x.add(new Student(StudentUsername, StudentPassword,
                StudentName, StudentBirthday, StudentGender));
    }

    public static Student addStudent(ArrayList<User> x, int u) {
        Scanner sc = new Scanner(System.in);
        System.out.println("edit information:-");
        String StudentPassword, StudentName;
        System.out.println("username: " + x.get(u).getUsername());

//password validation  
        do {
            System.out.print("Password: ");
            StudentPassword = sc.nextLine();
            if (StudentPassword.length() < 6) {
                System.out.println("*password must contain at least 6 characters*");
            }
        } while (StudentPassword.length() < 6);
//name
        do {
            System.out.print("name: ");
            StudentName = sc.nextLine();
        } while (StudentName.length() < 0);
//birthday validation 
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        String StudentBirthday;
        boolean validDate = false;
        do {
            System.out.print("birthday (dd/MM/yyyy): ");
            StudentBirthday = sc.nextLine();
            Matcher matcher = pattern.matcher(StudentBirthday);
            if (matcher.matches()) {
                try {
                    LocalDate birthday = LocalDate.parse(StudentBirthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    int year = birthday.getYear();
                    if (year >= 1900 && year <= 2023) {
                        validDate = true;
                    } else {
                        System.out.println("Invalid year. Please enter a year between 1900 and 2023");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy");
            }
        } while (!validDate);
        LocalDate birthday = LocalDate.parse(StudentBirthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("birthday: " + x.get(u).getBirthday());
        System.out.println("gender: " + x.get(u).getGender());
        if (x.get(u) instanceof Student e) {
            System.out.println("university id: " + e.getUniversityId());
        }
        Student s = new Student(x.get(u).getUsername(), StudentPassword,
                StudentName, StudentBirthday, x.get(u).getGender());
        s.setUid(u);
        if (x.get(u) instanceof Student e) {
            s.setUniversityId(e.getUniversityId());
        }
        return s;
    }

    public static void addTeacher(ArrayList<User> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add teacher:-");

        String TeacherUsername, TeacherPassword;
        boolean isDuplicate;
        do {
            System.out.print("username:");
            TeacherUsername = sc.nextLine();

            isDuplicate = false;
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i).getUsername().equals(TeacherUsername)) {
                    System.out.println("*username already exist*");
                    isDuplicate = true;
                    break;
                }
            }
        } while (isDuplicate);

        do {
            System.out.print("Password: ");
            TeacherPassword = sc.nextLine();
            if (TeacherPassword.length() < 6) {
                System.out.println("*password must contain at least 6 characters*");
            }
        } while (TeacherPassword.length() < 6);

        System.out.print("name: ");
        String TeacherName = sc.nextLine();

        System.out.print("birthday: ");
        String TeacherBirthday = sc.nextLine();

        System.out.print("gender (male/female): ");
        String TGender = sc.nextLine();
        Gender TeacherGender;
        if (TGender.equalsIgnoreCase("male")) {
            TeacherGender = Gender.male;
        } else {
            TeacherGender = Gender.female;
        }
        System.out.print("Specialty: ");
        String TeacherSpecialty = sc.nextLine();
        System.out.print("Salary: ");
        int TeacherSalary = sc.nextInt();
        x.add(new Teacher(TeacherUsername, TeacherPassword,
                TeacherName, TeacherBirthday, TeacherGender,
                TeacherSalary, TeacherSpecialty));
    }

    public static void viewStudent(ArrayList<User> x) {
        System.out.println("username | password | Birthday | gender | university id | name");
        for (int k = 0; k < x.size(); k++) {
            if (x.get(k) instanceof Student) {
                System.out.print(x.get(k).getUsername() + "       | ");
                System.out.print(x.get(k).getPassword() + "   | ");
                System.out.print(x.get(k).getBirthday() + " | ");
                System.out.print(x.get(k).getGender());
                if (x.get(k).getGender().equals(Gender.male)) {
                    System.out.print("   | ");
                } else {
                    System.out.print(" | ");
                }
                if (x.get(k) instanceof Student s) {

                    System.out.print(s.getUniversityId() + "     | ");
                }
                System.out.print(x.get(k).getName() + "\n");

            }
        }
    }

    public static void viewTeacher(ArrayList<User> x) {
        System.out.println("username | password | Birthday | gender | Specialty | name");
        for (int k = 0; k < x.size(); k++) {
            if (x.get(k) instanceof Teacher) {
                System.out.print(x.get(k).getUsername() + "   | ");
                System.out.print(x.get(k).getPassword() + "   | ");
                System.out.print(x.get(k).getBirthday() + " | ");
                System.out.print(x.get(k).getGender());
                if (x.get(k).getGender().equals(Gender.male)) {
                    System.out.print("   | ");
                } else {
                    System.out.print(" | ");
                }
                if (x.get(k) instanceof Teacher t) {

                    System.out.print(t.getSpecialty() + " | ");
                }
                System.out.print(x.get(k).getName() + "\n");

            }
        }
    }

    public static void addQuestionYesOrNo(ArrayList<Question> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add question:-");
        String name;
        int mark;
        do {
            System.out.print("question text:");
            name = sc.nextLine();
            if (name.length() <= 0) {
                System.out.println("*please add text*");
            }
        } while (name.length() <= 0);

        System.out.print("question image (optional):");
        String img = sc.nextLine();
        if (img.length() == 0) {
            img = "none";
        }
        boolean valid = false;
        boolean correctAnswer = false;
        do {

            System.out.print("correct answer:");
            String correctAnswerTxt = sc.nextLine();

            if (correctAnswerTxt.equalsIgnoreCase("yes")
                    || correctAnswerTxt.equalsIgnoreCase("true")) {
                correctAnswer = true;
                valid = true;
            } else if (correctAnswerTxt.equalsIgnoreCase("no")
                    || correctAnswerTxt.equalsIgnoreCase("false")) {
                correctAnswer = false;
                valid = true;
            }
            if (!valid) {
                System.out.println("*INVALID*");
            }
        } while (!valid);

        do {
            System.out.print("question mark:");
            mark = sc.nextInt();
            if (mark <= 0) {
                System.out.println("*mark must be more than 0*");
            }
        } while (mark <= 0);

        YesOrNo e = new YesOrNo(name, mark, img, correctAnswer);
        x.add(e);

    }

    public static YesOrNo addQuestionYesOrNo(ArrayList<Question> x, int y) {
        Scanner sc = new Scanner(System.in);

        System.out.println("add question:-");
        String name;
        int mark;
        do {
            System.out.println("question text" + "(" + x.get(y).getName() + "): ");
            name = sc.nextLine();
            if (name.length() <= 0) {
                System.out.println("*please add text*");
            }
        } while (name.length() <= 0);

        System.out.println("question image (optional)" + "(" + x.get(y).getImg() + "): ");
        String img = sc.nextLine();

        if (img.length() == 0) {
            img = "none";
        }
        boolean valid = false;
        boolean correctAnswer = false;
        do {
            if (x.get(y) instanceof YesOrNo e) {
                System.out.println("correct answer" + "(" + e.getCorrectAnswer() + "): ");
            }
            String correctAnswerTxt = sc.nextLine();

            if (correctAnswerTxt.equalsIgnoreCase("yes")
                    || correctAnswerTxt.equalsIgnoreCase("true")) {
                correctAnswer = true;
                valid = true;
            } else if (correctAnswerTxt.equalsIgnoreCase("no")
                    || correctAnswerTxt.equalsIgnoreCase("false")) {
                correctAnswer = false;
                valid = true;
            }
            if (!valid) {
                System.out.println("*INVALID*");
            }
        } while (!valid);

        do {
            System.out.println("question mark" + "(" + x.get(y).getMark() + "): ");
            mark = sc.nextInt();
            if (mark <= 0) {
                System.out.println("*mark must be more than 0*");
            }
        } while (mark <= 0);

        YesOrNo e = new YesOrNo(name, mark, img, correctAnswer);
        e.setQid(y + 1);
        return e;
    }

    public static void addQuestionMultipleChoice(ArrayList<Question> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add question:-");

        System.out.print("question text:");
        String name = sc.nextLine();

        System.out.print("question image (optional):");
        String img = sc.nextLine();

        System.out.println("question answers (2-6 options separated by '/'):");
        String answersList = sc.nextLine();

        // split using "/", trim each option and add a mark between option and number
        String[] answers = answersList.split("/");
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answers[i].trim();
        }

        while (answers.length < 2 || answers.length > 6) { // validate number of options
            System.out.println("Invalid number of options. Please enter 2-6 options separated by '/':");
            answersList = sc.nextLine();
            answers = answersList.split("/");
            for (int i = 0; i < answers.length; i++) {
                answers[i] = answers[i].trim();
            }
        }
        String formattedAnswers = String.join(" / ", answers);
        boolean valid = false;
        String correctAnswer;
        do {
            System.out.println("correct answer (enter option number):");
            correctAnswer = sc.nextLine();
            for (String answer : answers) {
                if (answer.equalsIgnoreCase(correctAnswer)) {
                    valid = true;
                }
            }
            if (!valid) {
                System.out.println("*Invalid*");
            }
        } while (!valid);
        System.out.print("question mark:");
        int mark = sc.nextInt();
        Multiplechoice e = new Multiplechoice(name, mark, img, answers, correctAnswer, formattedAnswers);
        x.add(e);
    }

    public static Multiplechoice addQuestionMultipleChoice(ArrayList<Question> x, int y) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add question:-");

        System.out.println("question text" + "(" + x.get(y).getName() + "): ");
        String name = sc.nextLine();

        System.out.println("question image (optional)" + "(" + x.get(y).getImg() + "): ");
        String img = sc.nextLine();
        if (x.get(y) instanceof Multiplechoice e) {
            System.out.println("question answers (2-6 options separated by '/')" + "(" + e.getAnswers() + "): ");
        }
        String answersList = sc.nextLine();

        // split using "/", trim each option and add a mark between option and number
        String[] answers = answersList.split("/");
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answers[i].trim();
        }

        while (answers.length < 2 || answers.length > 6) { // validate number of options
            System.out.println("Invalid number of options. Please enter 2-6 options separated by '/':");
            answersList = sc.nextLine();
            answers = answersList.split("/");
            for (int i = 0; i < answers.length; i++) {
                answers[i] = answers[i].trim();
            }
        }
        String formattedAnswers = String.join(" / ", answers);
        boolean valid = false;
        String correctAnswer;
        do {
            if (x.get(y) instanceof Multiplechoice e) {
                System.out.println("correct answer" + "(" + e.getCorrectAnswer() + "): ");
            }
            correctAnswer = sc.nextLine();
            for (String answer : answers) {
                if (answer.equalsIgnoreCase(correctAnswer)) {
                    valid = true;
                }
            }
            if (!valid) {
                System.out.println("*Invalid*");
            }
        } while (!valid);
        System.out.println("question mark" + "(" + x.get(y).getMark() + "): ");
        int mark = sc.nextInt();
        Multiplechoice e = new Multiplechoice(name, mark, img, answers, correctAnswer, formattedAnswers);
        e.setQid(y + 1);
        return e;
    }

    public static void addQuestionFillBlank(ArrayList<Question> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add question:-");

        String name;
        int mark;
        do {
            System.out.print("question text:");
            name = sc.nextLine();
            if (name.length() <= 0) {
                System.out.println("*please add text*");
            }
        } while (name.length() <= 0);

        System.out.print("question image (optional):");
        String img = sc.nextLine();
        if (img.length() == 0) {
            img = "none";
        }
        System.out.print("question correct answer:");
        String correctAnswer = sc.nextLine();

        do {
            System.out.print("question mark:");
            mark = sc.nextInt();
            if (mark <= 0) {
                System.out.println("*mark must be more than 0*");
            }
        } while (mark <= 0);
        Fillblank e = new Fillblank(name, mark, img, correctAnswer);
        x.add(e);
    }

    public static Fillblank addQuestionFillBlank(ArrayList<Question> x, int y) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add question:-");

        String name;
        int mark;
        do {
            System.out.println("question text" + "(" + x.get(y).getName() + "): ");
            name = sc.nextLine();
            if (name.length() <= 0) {
                System.out.println("*please add text*");
            }
        } while (name.length() <= 0);

        System.out.println("question image (optional)" + "(" + x.get(y).getImg() + "): ");
        String img = sc.nextLine();
        if (img.length() == 0) {
            img = "none";
        }
        if (x.get(y) instanceof Fillblank e) {
            System.out.println("question correct answer" + "(" + e.getCorrectAnswer() + "): ");
        }
        String correctAnswer = sc.nextLine();

        do {
            System.out.println("question mark" + "(" + x.get(y).getMark() + "): ");
            mark = sc.nextInt();
            if (mark <= 0) {
                System.out.println("*mark must be more than 0*");
            }
        } while (mark <= 0);
        Fillblank e = new Fillblank(name, mark, img, correctAnswer);
        e.setQid(y + 1);
        return e;
    }

    public static void editQuestion(ArrayList<Question> x) {
        Scanner sc = new Scanner(System.in);
        viewQuestion(x);
        String choose;
        int Qindex = 0;
        do {
            System.out.println("choose the question you want to edit");
            choose = sc.nextLine();
            if (!isNumeric(choose) || choose.equals("0")) {
                System.out.println("*INVALID*");
            } else if (isNumeric(choose)) {
                Qindex = Integer.parseInt(choose);
            }

        } while (!isNumeric(choose) || Qindex > x.size() || Qindex <= 0);
        Qindex--;

        if (x.get(Qindex) instanceof YesOrNo) {
            x.set(Qindex, addQuestionYesOrNo(x, Qindex));
        } else if (x.get(Qindex) instanceof Multiplechoice) {
            x.set(Qindex, addQuestionMultipleChoice(x, Qindex));
        } else if (x.get(Qindex) instanceof Fillblank) {
            x.set(Qindex, addQuestionFillBlank(x, Qindex));
        }
    }

    public static void viewQuestion(ArrayList<Question> x) {
        System.out.println("id | qestion text | mark | qestion type | correct answer");
        for (int i = 0; i < x.size(); i++) {
            System.out.print(x.get(i).getQid() + "  | ");
            System.out.print(x.get(i).getName() + " | ");
            System.out.print(x.get(i).getMark() + " | ");

            if (x.get(i) instanceof YesOrNo m) {
                System.out.print("yes/no |");
                System.out.print(m.getCorrectAnswer() + "\n");
            } else if (x.get(i) instanceof Multiplechoice m) {

                System.out.print("multiplechoice |");
                System.out.print(m.getAnswers() + " | ");

                System.out.print(m.getCorrectAnswer() + "\n");

            } else if (x.get(i) instanceof Fillblank m) {
                System.out.print("fill the blank |");
                System.out.print(m.getCorrectAnswer() + "\n");
            }

        }
    }

    public static void addExam(ArrayList<Exam> x, ArrayList<Question> y, Teacher t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add Exam:-");
        String name;
        int numberOfQuestions, minPassAverage;
        boolean YesOrNo = false, Multiplechoice = false, Fillblank = false, valid;
        do {
            System.out.print("Exam name:");
            name = sc.nextLine();
            if (name.length() <= 0) {
                System.out.println("*Invalid*");
            }
        } while (name.length() <= 0);

        do {
            valid = false;
            System.out.print("containe yes or no?: ");
            String YesOrNoTxt = sc.nextLine();

            if (YesOrNoTxt.equalsIgnoreCase("yes")
                    || YesOrNoTxt.equalsIgnoreCase("true")) {
                YesOrNo = true;
                valid = true;
            } else if (YesOrNoTxt.equalsIgnoreCase("no")
                    || YesOrNoTxt.equalsIgnoreCase("false")) {
                YesOrNo = false;
                valid = true;
            }
            if (valid == false) {
                System.out.println("*Invalid input*");
            }
        } while (!valid);

        do {
            valid = false;
            System.out.print("containe Multiple choice?: ");
            String MultiplechoiceTxt = sc.nextLine();

            if (MultiplechoiceTxt.equalsIgnoreCase("yes")
                    || MultiplechoiceTxt.equalsIgnoreCase("true")) {
                Multiplechoice = true;
                valid = true;
            } else if (MultiplechoiceTxt.equalsIgnoreCase("no")
                    || MultiplechoiceTxt.equalsIgnoreCase("false")) {
                Multiplechoice = false;
                valid = true;
            }
            if (valid == false) {
                System.out.println("*Invalid input*");
            }
        } while (!valid);

        do {
            valid = false;
            System.out.print("containe Fill the blank?: ");
            String FillblankTxt = sc.nextLine();

            if (FillblankTxt.equalsIgnoreCase("yes")
                    || FillblankTxt.equalsIgnoreCase("true")) {
                Fillblank = true;
                valid = true;
            } else if (FillblankTxt.equalsIgnoreCase("no")
                    || FillblankTxt.equalsIgnoreCase("false")) {
                Fillblank = false;
                valid = true;
            }
            if (valid == false) {
                System.out.println("*Invalid input*");
            }
        } while (!valid);

//        do {
//            System.out.print("number of questions: ");
//            numberOfQuestions = sc.nextInt();
//            if (numberOfQuestions <= 0) {
//                System.out.println("*Invalid Inputs");
//            }
//        } while (numberOfQuestions <= 0);
        ArrayList<Question> availableQuestions = new ArrayList<>(y);
        int availableQuestionsCount = 0;
        do {

            System.out.print("Number of questions: ");
            numberOfQuestions = sc.nextInt();

            if (numberOfQuestions <= 0) {
                System.out.println("*Invalid Inputs");
            } else {
                // حساب عدد الأسئلة المتاحة من النوع المحدد

                if (YesOrNo || Multiplechoice || Fillblank) {
                    for (Question availableQuestion : availableQuestions) {
                        if ((availableQuestion instanceof YesOrNo && YesOrNo)
                                || (availableQuestion instanceof Multiplechoice && Multiplechoice)
                                || (availableQuestion instanceof Fillblank && Fillblank)) {
                            availableQuestionsCount++;
                        }
                    }
                }

                // إذا قام المستخدم بإدخال عدد أكبر من المتاح، يتم طلبه من إعادة إدخال العدد من جديد
                if (numberOfQuestions > availableQuestionsCount) {
                    System.out.println("The number of available questions for the selected type is " + availableQuestionsCount);
                    System.out.println("Please enter a number less than or equal to " + availableQuestionsCount + ".");
                }
            }
        } while (numberOfQuestions <= 0 || numberOfQuestions > availableQuestionsCount);

        System.out.print("min pass average: ");
        minPassAverage = sc.nextInt();

        x.add(new Exam(name, numberOfQuestions, minPassAverage, YesOrNo,
                Multiplechoice, Fillblank, y, t));

    }

    public static void viewExam(ArrayList<Exam> x, Teacher t) {
        System.out.println("id | name | number of questions | pass mark | total mark | ");
        for (int i = 0; i < x.size(); i++) {

            if (x.get(i).getT() == t) {

                System.out.print(x.get(i).getEid() + "  | ");
                System.out.print(x.get(i).getName() + " | ");
                System.out.print(x.get(i).getNumberOfQuestions() + " | ");
                System.out.print(x.get(i).getMinPassAverage() + " | ");
                System.out.print(x.get(i).getTotalMarks() + " | ");
                for (int j = 0; j < x.get(i).getQuestions().size(); j++) {
                    System.out.print(x.get(i).getQuestions(j).getName() + ",");
                }
                System.out.print("\n");
            }
        }
    }

    public static boolean solveExam(ArrayList<ExamResult> x, Exam e, Student s) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getE() == e && x.get(i).getS() == s) {
                System.out.println("you have already attempt this exam");
                return false;
            }
        }
        System.out.println("solve exam:-");
        System.out.println("exam name: " + e.getName());
        int mark = 0;
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i < e.getQuestions().size(); i++) {
            System.out.println((i + 1) + "- " + e.getQuestions(i).getName());
            if (e.getQuestions(i) instanceof Multiplechoice c) {
                System.out.println(c.getAnswers());
            }
            System.out.print("your answer: ");
            String answer = sc.nextLine();
            answers.add(answer);
            if (e.getQuestions(i) instanceof YesOrNo c) {
                boolean ans = false;
                boolean valid = false;
                do {
                    if (answer.equalsIgnoreCase("yes")
                            || answer.equalsIgnoreCase("true")) {
                        ans = true;
                        valid = true;
                    } else if (answer.equalsIgnoreCase("no")
                            || answer.equalsIgnoreCase("false")) {
                        ans = false;
                        valid = true;
                    }
                    if (!valid) {
                        System.out.println("*Invalid*");
                        System.out.print("your answer: ");
                        answer = sc.nextLine();
                        answers.set(i, answer);
                    }
                } while (!valid);

                if (ans == c.getCorrectAnswer()) {
                    mark += e.getQuestions(i).getMark();
                }
            } else if (e.getQuestions(i) instanceof Multiplechoice c) {
                if (answer.equalsIgnoreCase(c.getCorrectAnswer())) {
                    mark += e.getQuestions(i).getMark();
                }
            } else if (e.getQuestions(i) instanceof Fillblank c) {
                if (answer.equalsIgnoreCase(c.getCorrectAnswer())) {
                    mark += e.getQuestions(i).getMark();
                }
            }

        }
        System.out.println("grade: " + mark + "/" + e.getTotalMarks());
        x.add(new ExamResult(e, s, mark, answers));
        return true;
    }

    public static void viewExamResultForTeacher(ArrayList<ExamResult> x, ArrayList<Exam> y, Teacher t) {
        Scanner sc = new Scanner(System.in);
        viewExam(y, t);
        String choose;
        do {
            System.out.println("choose exam id:");
            System.out.print("=>");
            choose = sc.nextLine();
        } while (!isNumeric(choose));
        int index = Integer.parseInt(choose);
        index--;
        System.out.println(y.get(index).getName() + " exam results:-");
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getE().getEid() == y.get(index).getEid()) {
//                System.out.print(x.get(i).getE().getName() + " | ");
                System.out.print(x.get(i).getS().getName() + " | ");
                System.out.print(x.get(i).getMark() + "/" + y.get(index).getTotalMarks() + "\n");
            }
        }
    }

    public static void viewExamResultForStudent(ArrayList<ExamResult> x, Student s) {
        System.out.println(s.getName() + " exam's results: ");
        boolean valid = false;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getS() == s) {
                System.out.print(x.get(i).getE().getName() + " | ");
                System.out.print(x.get(i).getMark() + "/" + x.get(i).getE().getTotalMarks() + "\n");
                valid = true;
            }

        }
        if (x.isEmpty() || !valid) {
            System.out.println("there is no exam's to show");
        }
    }

    public static boolean viewExamResultDetails(ArrayList<ExamResult> x, Student s) {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getS() == s) {
                System.out.print(i + 1 + " | ");
                System.out.print(x.get(i).getE().getName() + "\n");
                valid = true;
            }
        }
        if (x.isEmpty() || !valid) {
            System.out.println("there is no exam's to show");
            return false;
        }
        String choose;
        do {
            System.out.println("choose exam id:");
            System.out.print("=>");
            choose = sc.nextLine();
        } while (!isNumeric(choose));
        int index = Integer.parseInt(choose);
        index--;
        System.out.println(x.get(index).getE().getName() + " result details: ");
        System.out.println("grade: " + x.get(index).getMark() + "/" + x.get(index).getE().getTotalMarks());
        for (int i = 0; i < x.get(index).getE().getQuestions().size(); i++) {
            System.out.println((i + 1) + "- " + x.get(index).getE().getQuestions(i).getName());
            if (x.get(index).getE().getQuestions(i) instanceof Multiplechoice c) {
                System.out.println(c.getAnswers());
                System.out.println("your answer: " + x.get(index).getStudentAnswers(i));
                System.out.println("correct answer: " + c.getCorrectAnswer());
                if (x.get(index).getStudentAnswers(i).equalsIgnoreCase(c.getCorrectAnswer())) {
                    System.out.println(c.getMark() + "/" + c.getMark());
                } else {
                    System.out.println(0 + "/" + c.getMark());
                }
            } else if (x.get(index).getE().getQuestions(i) instanceof YesOrNo c) {
                System.out.println("your answer: " + x.get(index).getStudentAnswers(i));
                System.out.println("correct answer: " + c.getCorrectAnswer());
                boolean ans = false;
                if (x.get(index).getStudentAnswers(i)
                        .equalsIgnoreCase("yes")
                        || x.get(index).getStudentAnswers(i)
                                .equalsIgnoreCase("true")) {
                    ans = true;

                } else if (x.get(index).getStudentAnswers(i)
                        .equalsIgnoreCase("no")
                        || x.get(index).getStudentAnswers(i)
                                .equalsIgnoreCase("false")) {
                    ans = false;

                }
                if (ans == c.getCorrectAnswer()) {
                    System.out.println(c.getMark() + "/" + c.getMark());
                } else {
                    System.out.println(0 + "/" + c.getMark());
                }
            } else if (x.get(index).getE().getQuestions(i) instanceof Fillblank c) {
                System.out.println("your answer: " + x.get(index).getStudentAnswers(i));
                System.out.println("correct answer: " + c.getCorrectAnswer());

                if (x.get(index).getStudentAnswers(i).equalsIgnoreCase(c.getCorrectAnswer())) {
                    System.out.println(c.getMark() + "/" + c.getMark());
                } else {
                    System.out.println(0 + "/" + c.getMark());
                }
            }
        }
        return true;
    }

    public static void editInformation(ArrayList<User> x, Student s) {
        x.set(s.getUid(), addStudent(x, s.getUid()));
    }

    public static void viewRank(ArrayList<ExamResult> x, ArrayList<User> y) {
        ArrayList<Student> students = new ArrayList<Student>();
        for (int i = 0; i < y.size(); i++) {
            int count = 0, totalMark = 0;
            double avg = 0.0;
            if (y.get(i) instanceof Student e) {
                students.add(e);
                for (int j = 0; j < x.size(); j++) {
                    if (x.get(j).getS() == e) {
                        totalMark += x.get(j).getMark();
                        count++;
                    }
                }
                try {
                    avg = totalMark / count;
                    e.setAvg(avg);
                } catch (Exception g) {
                    if (totalMark == 0) {

                        System.out.println("student didn't attemp any exam");
                    }
                }
            }
        }

        // Sort the list of Student objects by average in descending order
        try {

            Collections.sort(students, new Comparator<Student>() {
                public int compare(Student s1, Student s2) {
                    return Double.compare(s2.getAvg(), s1.getAvg());
                }
            });
            // Print the top 5 students with the highest average
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + ". " + students.get(i).getName() + " | avg: ");
                students.get(i).getAvg();
                if (students.get(i).getAvg() == 0.0) {
                    System.out.print("there is no data" + "\n");
                } else {
                    System.out.print(students.get(i).getAvg() + "\n");
                }
            }
        } catch (Exception f) {
//            System.out.println("there is no data");
        }
    }

    public static boolean isNumeric(String x) {
        if (x == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(x);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;

    }

    public static Teacher searchByName(ArrayList<User> x, String u) {
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getUsername().equals(u)) {
                Teacher t = (Teacher) x.get(i);
                return t;
            }
        }
        return null;
    }
}
