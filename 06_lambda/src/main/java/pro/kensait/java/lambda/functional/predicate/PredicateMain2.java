package pro.kensait.java.lambda.functional.predicate;

import java.util.function.Predicate;

public class PredicateMain2 {

    public static void main(String[] args) {
        new PredicateMain2().process();
    }

    private void process() {
        // Userオブジェクトを生成する
        User alice = new User(1, 25);

        // ユーザ仕様をチェックする（ラムダ式を渡す）
        boolean flag1 = checkUserSpeck(alice, (User user) -> user.isAdult());
        System.out.println(flag1);
 
        // ユーザ仕様をチェックする（メソッド参照を渡す）
        boolean flag2 = checkUserSpeck(alice, User::isAdult);
        System.out.println(flag2);

        // ユーザ仕様をチェックする（UserSpecオブジェクトを渡す）
        boolean flag3 = checkUserSpeck(alice, new Predicate<User>() {
            public boolean test(User user) {
                return user.isAdult();
            }
        });
        System.out.println(flag3);
    }

    private boolean checkUserSpeck(User user, Predicate<User> userSpec) {
        return userSpec.test(user);
    }
}