package pro.kensait.java.advanced.lesson6_2_5.collection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pro.kensait.java.advanced.lesson6_2_5.sales.Sales;
import pro.kensait.java.advanced.lesson6_2_5.sales.SalesHolder;

public class Main_Map {
    public static void main(String[] args) {
        List<Sales> salesList = SalesHolder.getSalesList();
        Map<Integer, Integer> resultMap = salesList.stream()
                .filter(sales -> sales.getProductName().startsWith("A"))
                .collect(Collectors.toMap(
                        Sales::getId,
                        Sales::getCount,
                        (oldVal, newVal) -> newVal));
        System.out.println(resultMap);
    }
}