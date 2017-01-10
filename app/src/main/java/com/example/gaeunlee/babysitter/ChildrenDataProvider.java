package com.example.gaeunlee.babysitter;

import com.example.gaeunlee.babysitter.dto.Children;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ChildrenDataProvider {

    public static List<Children> childList = new ArrayList<>();

    public static Map<String, Children> childrenMap = new HashMap<>();

    static {

        addProduct(
                1,
                "Jake",
                "boy",
                "2000,01,03",
                "music and dance, art and craft",
                "6:00",
                "8:00",
                "very adventureous"
        );

        addProduct(
                2,
                "TreeTrunk",
                "girl",
                "2001-02-03",
                "cooking, art and craft",
                "5",
                "9",
                "very sensitive"
        );

        addProduct(
                3,
                "Finn",
                "boy",
                "2010-01-05",
                "puzzle, movie, art and craft",
                "4",
                "8:00",
                "very mutual"
        );

    }



    //차일드 맵 완성
    private static void addProduct(int child_no, String first_name, String gender, String birthday, String child_interest, String bath_time, String bed_time, String note) {
        Children item = new Children(child_no,first_name, gender, birthday, child_interest,bath_time,bed_time, note);
        childList.add(item);
        childrenMap.put(first_name, item);
    }

    // for 문 돌려서 리스트에 이름을 구함
    public static List<String> getFirstName() {
        List<String> list = new ArrayList<>();
        //for 구문 (Childre dto: 위에 정의한 list<Children>)
        for (Children children : childList) {
            list.add(children.getFirst_name());
        }
        return list;
    }



    //
    public static List<Children> getFilteredList(String searchString) {

        List<Children> filteredList = new ArrayList<>();
        for (Children children : childList) {
            if (children.getFirst_name().contains(searchString))
                filteredList.add(children);
        }

        return filteredList;

    }

}
