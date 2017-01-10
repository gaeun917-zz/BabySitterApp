package com.example.gaeunlee.babysitter.sitter;

import com.example.gaeunlee.babysitter.dto.Sitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SitterDataProvider {

    public static List<Sitter> sitterList = new ArrayList<>();

    public static Map<String, Sitter> sitterMap = new HashMap<>();

    static {

        addProduct(
                1,
                "Bubble Gum",
                "female",
                35,
                "I am newly graduated, I am newly graduated, I am newly graduated ",
                "University of San Francisco ",
                "professional dancer",
                "I am Buble gum I have experience with 6 yesrs old boys  ",
                "creative",
                "fun",
                "atheletic"
        );

        addProduct(
                2,
                "Bubble Gum",
                "male",
                22,
                "I am newly graduated, I am newly graduated, I am newly graduated ",
                "State University of California, San Diego ",
                "professional dancer",
                "I am Buble gum I have experience with 6 yesrs old boys  ",
                "artistic",
                "discipline",
                "atheletic"
        );


        addProduct(
                3,
                "Bubble Gum",
                "female",
                25,
                "I am newly graduated, I am newly graduated, I am newly graduated ",
                "New York University",
                "professional dancer",
                "I am Buble gum I have experience with 6 yesrs old boys  ",
                "understanding",
                "patient",
                "atheletic"
        );

    }



    //차일드 맵 완성
    private static void addProduct(int sitter_no, String name, String gender, int age, String bio, String school, String skills, String profile, String sitter_quality1, String sitter_quality2, String sitter_quality3) {
        Sitter item = new Sitter(sitter_no, name, gender, age, bio, school, skills, profile, sitter_quality1, sitter_quality2, sitter_quality3);
        sitterList.add(item);
        sitterMap.put(name, item);
    }



    // for 문 돌려서 리스트에 이름을 구함
    public static List<String> getFirstName() {
        List<String> list = new ArrayList<>();
        //for 구문 (Childre dto: 위에 정의한 list<Children>)
        for (Sitter sitter : sitterList) {
            list.add(sitter.getName());
        }
        return list;
    }



    //
    public static List<Sitter> getFilteredList(String searchString) {

        List<Sitter> filteredList = new ArrayList<>();
        for (Sitter sitter : sitterList) {
            if (sitter.getName().contains(searchString))
                filteredList.add(sitter);
        }

        return filteredList;

    }

}
