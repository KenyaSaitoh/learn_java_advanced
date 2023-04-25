package pro.kensait.java.advanced.lsn_4_1_5.predicate;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        User alice = new User(1, 25);
        boolean flag = checkUserSpeck(alice, user -> user.isAdult());
        System.out.println(flag);
    }

    static boolean checkUserSpeck(User user, Predicate<User> userSpec) { //【1】
        return userSpec.test(user); //【2】
    }
}