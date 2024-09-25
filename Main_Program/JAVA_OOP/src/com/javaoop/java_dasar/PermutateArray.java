package com.javaoop.java_dasar;

import java.util.ArrayList;
import java.util.List;

public class PermutateArray {

    public static void main(String[] args) {
        PermutateArray pa = new PermutateArray();

        int[] arr = { 10, 20, 30 };

        List<List<Integer>> permute = pa.permute(arr);

        System.out.println("Permuations of array : [10, 20, 30] are:");
        System.out.println("=========================================");
        for (List<Integer> perm : permute) {
            System.out.println(perm);
        }

    }

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr) {

        // Base case
        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++) {

                if (resultList.contains(arr[i])) {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(arr[i]);
                // Explore
                permuteHelper(list, resultList, arr);
                // Unchoose element
                resultList.remove(resultList.size() - 1);
            }
        }
    }

}