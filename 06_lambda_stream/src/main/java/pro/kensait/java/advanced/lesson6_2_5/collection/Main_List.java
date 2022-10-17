package pro.kensait.java.advanced.lesson6_2_5.collection;

import java.util.List;
import java.util.stream.Collectors;

import pro.kensait.java.advanced.lesson6_2_5.sales.Sales;
import pro.kensait.java.advanced.lesson6_2_5.sales.SalesHolder;

public class Main_List {
    public static void main(String[] args) {
        List<Sales> salesList = SalesHolder.getSalesList();
        List<Sales> resultList = salesList.stream()
                .filter(sales -> sales.getProductName().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(resultList);
    }
}