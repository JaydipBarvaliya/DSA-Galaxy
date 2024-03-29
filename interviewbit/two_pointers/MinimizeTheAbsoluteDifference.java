package com.interviewbit.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/minimize-the-absolute-difference/
 * <p>
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 * <p>
 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
 * <p>
 * Example :
 * <p>
 * Input:
 * <p>
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 * Output:
 * <p>
 * 1
 * Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 *
 * @author jaydip on 2019-08-05
 * Copyright (c) 2019, data-structures.
 * All rights reserved.
 */
public class MinimizeTheAbsoluteDifference {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 6));

        System.out.println(solveSimply(A, B, C));

        A = new ArrayList<>(Arrays.asList(-1));
        B = new ArrayList<>(Arrays.asList(-2));
        C = new ArrayList<>(Arrays.asList(-3));

        System.out.println(solveSimply(A, B, C));


        A = new ArrayList<>(Arrays.asList(-33, 13, 49, 72, 75, 75, 116, 161, 176, 190, 237, 241, 286, 308, 333, 343, 360, 370, 374, 377, 423, 424, 459, 468, 492, 495, 520, 569, 592, 615, 621, 643, 689, 721, 734, 747, 754, 763, 806, 812, 817, 841, 856, 858, 883, 915, 955, 955, 974, 1009, 1034, 1075, 1112, 1146, 1183, 1203, 1213, 1239, 1263, 1277, 1291, 1305, 1331, 1339, 1380, 1400, 1449, 1486, 1520, 1537, 1581, 1617, 1624, 1658, 1701, 1720, 1735, 1754, 1800, 1815, 1857, 1874, 1909, 1926, 1953, 1957, 1983, 1984, 2006, 2010, 2048, 2049, 2097, 2103, 2134, 2173));
        B = new ArrayList<>(Arrays.asList(-515, -486, -443, -428, -426, -422, -414, -409, -384, -380, -371, -361, -354, -345, -338, -336, -321, -294, -292, -275, -260, -217, -209, -170, -148, -105, -97, -86, -85, -52, -9, 40, 69, 79, 115, 155, 158, 166, 199, 199, 247, 252, 289, 291, 298, 342, 367, 384, 415, 426, 460, 487, 509, 512, 538, 584, 601, 601, 615, 650, 659, 669, 708, 755, 775, 788, 806, 819, 831, 868, 876, 916, 951, 974, 1014, 1029, 1030, 1045, 1080, 1088, 1094, 1098, 1136, 1165, 1203, 1233, 1242, 1265, 1289, 1314, 1350, 1387, 1424, 1425, 1426, 1441, 1454, 1457, 1458, 1483, 1513, 1528, 1532, 1579, 1623, 1635, 1668, 1713, 1760, 1786, 1799, 1807, 1833, 1856, 1869, 1911, 1939, 1947, 1974, 2005, 2046, 2068, 2111, 2115, 2160, 2199, 2244, 2256, 2282, 2296, 2328, 2371, 2404, 2450, 2465, 2497, 2524, 2564, 2602, 2642, 2681, 2714, 2733, 2733, 2780, 2826, 2833));
        C = new ArrayList<>(Arrays.asList(78, 111, 141, 153, 154, 197, 238, 259, 294, 295, 313, 338, 374, 382, 404, 433, 453, 482, 501, 538, 539, 570, 595, 604, 628, 670, 710, 724, 754, 761, 766, 806, 854, 863, 872, 878, 888, 935, 953, 963, 1010, 1033, 1050, 1064, 1088, 1123, 1134, 1180, 1219, 1242, 1277, 1312));

        System.out.println(solveSimply(A, B, C));


    }

    public static int solveSimply(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i = A.size() - 1, j = B.size() - 1, k = C.size() - 1;

        int minDifference = Math.abs(maximumOfThree(A.get(i), B.get(j), C.get(k)) - minimumOfThree(A.get(i), B.get(j), C.get(k)));

        while (i != -1 && j != -1 && k != -1) {
            minDifference = Math.min(minDifference, Math.abs(maximumOfThree(A.get(i), B.get(j), C.get(k)) - minimumOfThree(A.get(i), B.get(j), C.get(k))));

            int max = maximumOfThree(A.get(i), B.get(j), C.get(k));

            if (max == A.get(i)) {
                i--;
            } else if (max == B.get(j)) {
                j--;
            } else if (max == C.get(k)) {
                k--;
            }
        }
        return minDifference;
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int minimumDistance = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                for (int k = 0; k < C.size(); k++) {
                    minimumDistance = Math.min(minimumDistance, Math.abs(
                            maximumOfThree(A.get(i), B.get(j), C.get(k))
                                    - minimumOfThree(A.get(i), B.get(j), C.get(k))));
                }
            }
        }
        return minimumDistance;
    }

    public static int maximumOfThree(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int minimumOfThree(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
