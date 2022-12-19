package pro.kensait.java.advanced.lsn_8_1_1;

public class Main_ClassLoader_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=== プラットフォーム・クラスローダ ===");
        ClassLoader classLoader1 = ClassLoader.getPlatformClassLoader();
        System.out.println("本体 => " + classLoader1);
        ClassLoader parent1 = classLoader1.getParent();
        System.out.println("親 => " + parent1);
        System.out.println("=== システム・クラスローダ ===");
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
        System.out.println("本体 => " + classLoader2);
        ClassLoader parent2 = classLoader2.getParent();
        System.out.println("親 => "  + parent2);
        System.out.println("=== コンテキスト・クラスローダ ===");
        ClassLoader classLoader3 = Thread.currentThread().getContextClassLoader();
        System.out.println("本体 => " + classLoader3);
        ClassLoader parent3 = classLoader3.getParent();
        System.out.println("親 => " + parent3);
    }
}