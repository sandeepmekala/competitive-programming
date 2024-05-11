package com.trial;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test obj = new Test();
        System.out.println(obj.tranform("CBACD"));
    }

    // Test1: CBACD -> CBA -> C
    // Output: C
    // Test 2: CABABD -> CABD -> CD -> ""
    // Output: ""
    // Test 3: ACBDACBD -> ACBDACBD
    // Output: ACBDACBD
    public String tranform(String S) {}


}
