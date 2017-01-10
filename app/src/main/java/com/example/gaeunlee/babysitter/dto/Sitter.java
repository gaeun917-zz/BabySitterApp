package com.example.gaeunlee.babysitter.dto;

import java.io.Serializable;

public class Sitter implements Serializable {

    private int sitter_no;
    private int booking_no;
    private String name;
    private int sitter_age;
    private String bio;
    private String school;
    private String skills;
    private String email;
    private int rating;

    private String address;
    private String profile;
    private String gender;

    private String sitter_quality;
    private String sitter_quality2;
    private String sitter_quality3;




    public int getSitter_no() {
        return sitter_no;
    }
    public void setSitter_no(int sitter_no) {
        this.sitter_no = sitter_no;
    }
    public int getBooking_no() {
        return booking_no;
    }
    public void setBooking_no(int booking_no) {
        this.booking_no = booking_no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSitter_age() {
        return sitter_age;
    }
    public void setSitter_age(int age) {
        this.sitter_age = sitter_age;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String info) {
        this.email = info;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getSitter_quality() {
        return sitter_quality;
    }
    public void setSitter_quality(String sitter_quality1) {
        this.sitter_quality = sitter_quality1;
    }

    public String getSitter_quality2() {
        return sitter_quality2;
    }
    public void setSitter_quality2(String sitter_quality2) {
        this.sitter_quality2 = sitter_quality2;
    }

    public String getSitter_quality3() {
        return sitter_quality3;
    }
    public void setSitter_quality3(String sitter_quality3) {
        this.sitter_quality3 = sitter_quality3;
    }


    public Sitter() {
    }


    public Sitter(int sitter_no, String name, String gender, int sitter_age, String bio, String school, String skills, String profile, String sitter_quality, String sitter_quality2, String sitter_quality3) {

        this.sitter_no = sitter_no;
        this.name = name;
        this.gender = gender;
        this.sitter_age = sitter_age;
        this.bio = bio;
        this.school = school;
        this.skills = skills;
        this.profile = profile;
        this.sitter_quality = sitter_quality;
        this.sitter_quality2 = sitter_quality2;
        this.sitter_quality3 = sitter_quality3;



    }

}