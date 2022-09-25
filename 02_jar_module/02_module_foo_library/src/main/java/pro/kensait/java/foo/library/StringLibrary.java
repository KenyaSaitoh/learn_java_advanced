package pro.kensait.java.foo.library;

import pro.kensait.java.foo.internal.Common;

public class StringLibrary {
    public int getStrLengthSum(String str1, String str2) {
        Common common = new Common();
        return common.add(str1.length(), str2.length());
    }
}