package pro.kensait.java.advanced.lsn_4_1_5.methodref;

import java.util.function.Predicate;

public class Main_3 {
    public static void main(String[] args) {
        User alice = new User(1, 25);
        boolean flag = checkUserSpeck(alice, User::isAdult);
        System.out.println(flag);
    }

    static boolean checkUserSpeck(User user, Predicate<User> userSpec) {
        return userSpec.test(user);
    }
}