package com.example.gaeunlee.babysitter.dto;

import java.util.List;

public class Children {

    private int child_no;
    private int mother_no;
    private String first_name;
    private String last_name;
    private String gender;
    private String birthday;
    private String photo;
    private String toilet;
    private String child_interest;
    private String bath_time;
    private String bed_time;
    private String note;






    public int getMother_no() {
        return mother_no;
    }

    public void setMother_no(int mother_no) {
        this.mother_no = mother_no;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBed_time() {
        return bed_time;
    }

    public void setBed_time(String bed_time) {
        this.bed_time = bed_time;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getChild_interest() {
        return child_interest;
    }

    public void setChild_interest(String child_interest) {
        this.child_interest = child_interest;
    }

    public String getBath_time() {
        return bath_time;
    }

    public void setBath_time(String bath_time) {
        this.bath_time = bath_time;
    }

    public int getChild_no() {
        return child_no;
    }

    public void setChild_no(int child_no) {
        this.child_no = child_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }





    private List<Meal> meal;

    public List<Meal> getMeal() {
        return meal;
    }

    public void setMeal(List<Meal> meal) {
        this.meal = meal;
    }





    private List<Allergies> allergies;

    public List<Allergies> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergies> allergies) {
        this.allergies = allergies;
    }





    private List<Interest> interest;

    public List<Interest> getInterest() {
        return interest;
    }

    public void setInterest(List<Interest> interest) {
        this.interest = interest;
    }





    private List<Sitter> sitter;

    public List<Sitter> getSitter() {
        return sitter;
    }

    public void setSitter(List<Sitter> sitter) {
        this.sitter = sitter;
    }

    public Children() {
    }

    public Children(int child_no, String first_name, String gender, String birthday, String child_interest, String bath_time, String bed_time, String note) {

        this.child_no =child_no;
        this.first_name = first_name;
        this.gender = gender;
        this.birthday = birthday;
        this.child_interest = child_interest;
        this.bath_time = bath_time;
        this.bed_time = bed_time;
        this.note=note;

    }



}