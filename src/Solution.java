/**
 * Created by Illya on 16-07-24.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
    public static ArrayList getSubstrings(String p){
        ArrayList <String> substrings  = new ArrayList<String>();
        substrings.add(p);

        for (int i = p.length() - 1; i > 0; i--){
            for (int j = 0; (j+i) < p.length(); j++){
                substrings.add(p.substring(j , j+i));
            }
        }
        return substrings;
    }
    */
    public static HashSet<String> getSubstrings(String str) {
        HashSet<String> substrings = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (!substrings.contains(str.substring(j, i + 1))) {
                    substrings.add(str.substring(j, i + 1));
                }
            }
        }
        return substrings;
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String s = in.next();
            String p = "";
            int s_length = s.length();
            int progress = 0;
            int totalCost = 0;
            boolean found = false;
            char array[] = s.toCharArray();
            while (progress != s_length) {

                if (progress == 0) {
                    p += array[0];
                    totalCost++;
                    progress++;
                } else {
                    HashSet<String> substrings = getSubstrings(p);

                    outerloop:
                    for (String str : substrings) {
                        if (s.indexOf(str, progress) == progress) {
                            p += str;
                            progress += str.length();
                            found = true;
                            break outerloop;
                        } else {
                            found = false;
                        }
                    }


                    if (!found) {
                        p += array[progress];
                        totalCost++;
                        progress++;
                    }

                }
            }
            System.out.println(totalCost);
        }
    }
}