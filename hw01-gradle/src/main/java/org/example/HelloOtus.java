package org.example;


import com.google.common.collect.Lists;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("Arsen", "Yura", "Hakob");
        List<String> reversed = Lists.reverse(names);
        System.out.println(reversed);
    }
}
