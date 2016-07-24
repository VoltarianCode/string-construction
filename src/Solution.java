/**
 * Created by Illya on 16-07-24.
 */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //long start = System.currentTimeMillis();

        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String s = in.next();
            String p = "";
            int s_length = s.length();
            int progress = 0;
            int totalCost = 0;
            HashSet<Character> reference = new HashSet<>();
            char s_array[] = s.toCharArray();
            while (progress != s_length) {

                if (progress == 0) {
                    p += s_array[0];
                    reference.add(s_array[0]);
                    totalCost++;
                    progress++;
                } else {
                    if (reference.contains(s_array[progress])) {
                        p += s_array[progress];
                        progress++;
                    } else {
                        p += s_array[progress];
                        reference.add(s_array[progress]);
                        totalCost++;
                        progress++;
                    }

                }
            }

            System.out.println(totalCost);

        }
       // long end = System.currentTimeMillis();
       // System.out.println("Running time: " + (end - start));
    }

}
