package org.geeksforgeeks.arrays.subarray;

import org.constants.InputType;
import org.domain.objects.GFGIntArrayInputTemplate;
import org.utilities.ReadInputFileUtils;

import java.util.ArrayList;

public class SubArrayWithGivenSum {

    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>(2);
        int curr_sum = arr[0], start = 0, i;

        for (i = 1; i <= n; i++) {
            while (curr_sum > s && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            if (curr_sum == s) {
                res.add(start + 1);
                res.add(i);
                return res;
            }

            if (i < n) {
                curr_sum += arr[i];
            }
        }

        ArrayList<Integer> notFound = new ArrayList<>(1);
        notFound.add(-1);
        return notFound;
    }

    public static void main(String[] args) {
        GFGIntArrayInputTemplate inputObj = (GFGIntArrayInputTemplate) ReadInputFileUtils.readFile("SubArrayWithGivenSum.txt", InputType.INT);
        ArrayList<Integer> result = subArraySum(inputObj.getArr(), inputObj.getInputLength(), inputObj.getRequiredOutputIfAny());
        System.out.println(result.toString());
    }
}
