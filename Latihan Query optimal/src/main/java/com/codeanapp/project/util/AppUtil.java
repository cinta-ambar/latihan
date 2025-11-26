package com.codeanapp.project.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppUtil {
    private AppUtil(){
    }

    public static <T> List<List<T>> splitList(List<T> original, int size){
        if (size <= 0) throw new IllegalArgumentException("Size harus > 0");
        if (original == null || original.isEmpty()) return Collections.emptyList();

        List<List<T>> parts = new ArrayList<>();
        for (int i = 0; i < original.size(); i += size) {
            int end = Math.min(i + size, original.size());
            parts.add(new ArrayList<>(original.subList(i, end)));
        }
        return parts;
    }
}
