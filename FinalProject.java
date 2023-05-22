/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */

public class FinalProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        users.add(new Admin("ahmad", "1234", "ahmad saeed", "22/1/2004", Gender.male));

        users.add(new Teacher("jaffer", "112233", "jaffer agah", "22/2/1997", Gender.male, 2000, "Eng"));
        users.add(new Teacher("MohDalo", "112233", "Mohammed Al-Dalo", "1/1/1998", Gender.male, 1000, "Eng"));
        users.add(new Teacher("EtafHadda", "112233", "Etaf Abu Hadda", "1/1/1999", Gender.female, 3500, "Eng"));
        users.add(new Teacher("HashemSaqqa", "112233", "Hashem Al-Saqqa", "1/1/2000", Gender.male, 1500, "IT"));

        users.add(new Student("s1", "123456", "ahmed ali", "1/1/2000", Gender.male));
        users.add(new Student("s2", "123456", "Heba Ahmed", "1/1/2001", Gender.female));
        users.add(new Student("s3", "123456", "Dalia Mohammed", "1/1/2002", Gender.female));

        String[] ans1 = {"String", "int", "double", "char"};
        String[] ans2 = {"String", "Object", "number", "Exception"};

        ArrayList<Question> q = new ArrayList<>();
        q.add(new YesOrNo("Does Java can build GUI?", 2, null, true));
        q.add(new YesOrNo("Java doesn't support OOP?", 2, "image2.jpg", false));
        q.add(new Multiplechoice("Which Type is not primitive?", 2, null, ans1, ans1[0]));
        q.add(new Multiplechoice("Which class is super class for all classes?", 2, null, ans2, ans2[1]));
        q.add(new Fillblank("What is the keywords that used to call super class constructor?", 2, null, "super"));
        q.add(new Fillblank("What is the keywords that used to inherit from a class?", 2, null, "extends"));

        ArrayList<Exam> exam = new ArrayList<>();
        exam.add(new Exam("math", 4, 4, false, true, true, q, Utils.searchByName(users, "jaffer")));
        exam.add(new Exam("english", 4, 2, true, false, true, q, Utils.searchByName(users, "MohDalo")));
        exam.add(new Exam("physic", 2, 2, true, true, false, q, Utils.searchByName(users, "jaffer")));

        ArrayList<ExamResult> examResult = new ArrayList<>();

//        examResult.add(new ExamResult(exam.get(0), (Student) users.get(5), 5));
//        examResult.add(new ExamResult(exam.get(1), (Student) users.get(5), 6));
//        examResult.add(new ExamResult(exam.get(2), (Student) users.get(5), 3));
//        examResult.add(new ExamResult(exam.get(0), (Student) users.get(6), 2));
//        examResult.add(new ExamResult(exam.get(1), (Student) users.get(6), 6));
//        examResult.add(new ExamResult(exam.get(2), (Student) users.get(6), 5));
//        examResult.add(new ExamResult(exam.get(0), (Student) users.get(7), 3));
//        examResult.add(new ExamResult(exam.get(1), (Student) users.get(7), 6));
//        examResult.add(new ExamResult(exam.get(2), (Student) users.get(7), 4));
        String username, password;
        do {
            System.out.println("Enter your username(to logout enter -1):");
            username = sc.nextLine();
            System.out.println("Enter your password:");
            password = sc.nextLine();

            boolean ValidUsername = false, CorrectPassword = false;
            int UserType = -1;
            User loggedUser = null;
            for (int j = 0; j < users.size(); j++) {
                if (users.get(j).getUsername().equals(username)) {
                    ValidUsername = true;
                    if (users.get(j).getPassword().equals(password)) {
                        CorrectPassword = true;
                        loggedUser = users.get(j);
                        if (users.get(j) instanceof Admin) {
                            UserType = 0;
                        } else if (users.get(j) instanceof Teacher) {
                            UserType = 1;
                        } else if (users.get(j) instanceof Student) {
                            UserType = 2;
                        }
                    }

                }
            }

            if (ValidUsername
                    && CorrectPassword
                    || username.equalsIgnoreCase("admin")
                    && password.equalsIgnoreCase("admin")) {
                String choose;
                if (UserType == 0 || username.equalsIgnoreCase("admin")) {
                    if (username.equalsIgnoreCase("admin")) {
                        System.out.println("welcome Admin");
                    } else {
                        System.out.println("welcome " + username);
                    }

                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("please choose what you would like to do:-");
                        System.out.println("enter 0 to logout");
                        System.out.println("enter 1 to add teachers");
                        System.out.println("enter 2 to add students");
                        System.out.println("enter 3 to view all teachers");
                        System.out.println("enter 4 to view all students");
                        System.out.print("=>");
                        choose = sc.nextLine();
                        switch (choose) {
                            case "0" -> {
                                System.out.println("Thank you for using our program");
                                System.out.println("Made By Ahmad & Aser");
                            }
                            case "1" -> {
//                                add teacher 
                                Utils.addTeacher(users);
                            }
                            case "2" -> {
//                                add student 
                                Utils.addStudent(users);
                            }
                            case "3" -> {
//                                view teacher 
                                Utils.viewTeacher(users);
                            }
                            case "4" -> {
//                                view student 
                                Utils.viewStudent(users);

                            }
                            default -> {
                                System.out.println("////////////////////////////");
                                System.out.println("-------Invalid inputs-------");
                                System.out.println("////////////////////////////");
                            }
                        }
                    } while (!choose.equals("0"));
                } else if (UserType == 1) {
//                    teacher 
                    System.out.println("welcome " + username);
                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("please choose what you would like to do:-");
                        System.out.println("enter 0 to logout");
                        System.out.println("enter 1 to add students");
                        System.out.println("enter 2 to view all students");
                        System.out.println("enter 3 to add questions");
                        System.out.println("enter 4 to edit questions");
                        System.out.println("enter 5 to view all questions");
                        System.out.println("enter 6 to add exam");
                        System.out.println("enter 7 to view all exams");
                        System.out.println("enter 8 to view exam's results");
                        System.out.println("enter 9 to view student's exam result");
//                        System.out.println("enter 1 to export exams to a text file");
                        System.out.print("=>");
                        choose = sc.nextLine();
                        switch (choose) {
                            case "0" -> {
                                System.out.println("Thank you for using our program");
                                System.out.println("Made By Ahmad & Aser");
                            }
                            case "1" -> {
//                                add student 
                                Utils.addStudent(users);
                            }
                            case "2" -> {
//                                view student  
                                Utils.viewStudent(users);
                            }
                            case "3" -> {
//                                add question
                                String QuestionType;
                                do {
                                    System.out.println("what kind of question:");
                                    System.out.println("enter 0 to cancel");
                                    System.out.println("enter 1 to add yes or no question");
                                    System.out.println("enter 2 to add multiple choice question");
                                    System.out.println("enter 3 to add Fill the blank question");
                                    System.out.print("=>");
                                    QuestionType = sc.nextLine();
                                    switch (QuestionType) {
                                        case "0" -> {
                                            System.out.println("ok");
                                        }
                                        case "1" -> {
                                            Utils.addQuestionYesOrNo(q);
                                        }
                                        case "2" -> {
                                            Utils.addQuestionMultipleChoice(q);
                                        }
                                        case "3" -> {
                                            Utils.addQuestionFillBlank(q);
                                        }
                                        default -> {
                                            System.out.println("////////////////////////////");
                                            System.out.println("-------Invalid inputs-------");
                                            System.out.println("////////////////////////////");
                                        }
                                    }
                                } while (!QuestionType.equals("0"));
                            }
                            case "4" -> {
                                // edit question
                                Utils.editQuestion(q);

                            }
                            case "5" -> {
//                                view student 
                                Utils.viewQuestion(q);

                            }
                            case "6" -> {
                                Utils.addExam(exam, q, (Teacher) loggedUser);
                            }
                            case "7" -> {
                                Utils.viewExam(exam, (Teacher) loggedUser);
                            }
                            case "8" -> {
                                Utils.viewExamResultForTeacher(examResult, exam, (Teacher) loggedUser);
                            }
                            case "9" -> {

                            }
                            default -> {
                                System.out.println("////////////////////////////");
                                System.out.println("-------Invalid inputs-------");
                                System.out.println("////////////////////////////");
                            }
                        }
                    } while (!choose.equals("0"));
                } else if (UserType == 2) {
                    //student
                    System.out.println("welcome " + username);
                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("please choose what you would like to do:-");
                        System.out.println("enter 0 to logout");
                        System.out.println("enter 1 to solve exam");
                        System.out.println("enter 2 to view exam results");
                        System.out.println("enter 3 to view exam result details");
                        System.out.println("enter 4 to edit information");
                        System.out.println("enter 5 to export results to a text file");
                        System.out.println("enter 6 to view rank in average of exams result");
                        System.out.println("enter 7 to export an exam to a JSON file");
                        System.out.print("=>");
                        choose = sc.nextLine();
                        switch (choose) {
                            case "0" -> {
                                System.out.println("Thank you for using our program");
                                System.out.println("Made By Ahmad & Aser");
                            }
                            case "1" -> {
                                String examNumber;
                                boolean valid = false;
                                System.out.println("choose the exam you want to solve: ");
                                System.out.println("enter 0 to cancel");
                                for (int j = 0; j < exam.size(); j++) {
                                    System.out.println("enter " + (j + 1) + " to solve " + exam.get(j).getName());

                                }
                                do {
                                    System.out.print("=>");
                                    examNumber = sc.nextLine();
                                    if (Utils.isNumeric(examNumber)) {
                                        valid = true;
                                    }
                                } while (!valid);
                                if (!examNumber.equals("0")) {

                                    Utils.solveExam(examResult, exam.get(Integer.parseInt(examNumber) - 1), (Student) loggedUser);
                                }
                            }
                            case "2" -> {
                                Utils.viewExamResultForStudent(examResult, (Student) loggedUser);
                            }
                            case "3" -> {
                                Utils.viewExamResultDetails(examResult, (Student) loggedUser);
                            }
                            case "4" -> {
                                Utils.editInformation(users, (Student) loggedUser);
                            }
                            case "5" -> {

                            }
                            case "6" -> {
                                Utils.viewRank(examResult, users);
                            }
                            default -> {
                                System.out.println("////////////////////////////");
                                System.out.println("-------Invalid inputs-------");
                                System.out.println("////////////////////////////");
                            }
                        }
                    } while (!choose.equals("0"));
                }

            } else if (!ValidUsername && !username.equalsIgnoreCase("-1")) {
                System.out.println("*username does not exist*");

            } else if (ValidUsername && !username.equalsIgnoreCase("-1")
                    && !CorrectPassword) {
                System.out.println("*incorrect password*");

            } else if (username.equalsIgnoreCase("-1")) {
                System.out.println("*Thank you for using our program*");
            } else {
                System.out.println("*Invalid inputs*");
            }
        } while (!username.equalsIgnoreCase("-1"));
    }

}
