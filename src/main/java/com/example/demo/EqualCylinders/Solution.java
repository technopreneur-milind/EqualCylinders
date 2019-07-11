package com.example.demo.EqualCylinders;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
       int heightH1=0, heightH2=0, heightH3=0;
       Queue<Integer> queue1 = new LinkedList<Integer>();
       Queue<Integer> queue2 = new LinkedList<Integer>();
       Queue<Integer> queue3 = new LinkedList<Integer>();
       for(int i : h1)
        {
            queue1.add(i);
            heightH1+=i;
        }
        for(int i : h2)
        {
            queue2.add(i);
            heightH2+=i;
        }
        for(int i : h3)
        {
            queue3.add(i);
            heightH3+=i;
        }
       int minHeight = Math.min(heightH1,Math.min(heightH2,heightH3));
       while(heightH1 != heightH2 || heightH1 != heightH3)
       {
           while(heightH1 > minHeight)
            heightH1 -= queue1.remove();
           minHeight = Math.min(heightH1,Math.min(heightH2,heightH3));
           while(heightH2 > minHeight)
            heightH2 -= queue2.remove();
           minHeight = Math.min(heightH1,Math.min(heightH2,heightH3));
           while(heightH3 > minHeight)
            heightH3 -= queue3.remove();   
           minHeight = Math.min(heightH1,Math.min(heightH2,heightH3)); 
       }
      return minHeight;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/milindtechnopreneur/Technopreneur/EqualCylinders_out.txt"));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
