package pro.kensait.java.advanced.lsn_4_2_5.grouping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pro.kensait.java.advanced.lsn_4_2_5.sales.Sales;
import pro.kensait.java.advanced.lsn_4_2_5.sales.SalesHolder;

public class Main_Count {
    public static void main(String[] args) {
        List<Sales> salesList = SalesHolder.getSalesList();
        Map<String, Long> resultMap = salesList.stream()
                .filter(sales -> sales.getProductName().startsWith("A"))
                .collect(Collectors.groupingBy(
                        Sales::getProductName,
                        Collectors.counting()));

        for (String key : resultMap.keySet()) {
            System.out.println(key + " => " + resultMap.get(key));
        }
    }
}