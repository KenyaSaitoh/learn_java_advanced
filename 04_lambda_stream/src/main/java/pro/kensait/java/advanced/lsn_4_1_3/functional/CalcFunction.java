package pro.kensait.java.advanced.lsn_4_1_3.functional;

@FunctionalInterface //【1】
interface CalcFunction {
    int calc(int x, int y); //【2】
}