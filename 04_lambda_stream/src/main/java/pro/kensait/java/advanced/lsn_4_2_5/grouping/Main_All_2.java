package pro.kensait.java.advanced.lsn_4_2_5.grouping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pro.kensait.java.advanced.lsn_4_2_5.sales.Sales;
import pro.kensait.java.advanced.lsn_4_2_5.sales.SalesHolder;

public class Main_All_2 {
    public static void main(String[] args) {
        List<Sales> salesList = SalesHolder.getSalesList();
        Map<String, Integer> resultMap = salesList.stream()
                .filter(sales -> sales.getProductName().startsWith("A"))
                .map(sales -> {
                    String newName = sales.getProductName().replace("-", "");
                    try { Thread.sleep(1); } catch(Exception e) {}
                    return new Sales(sales.getId(), newName, sales.getCount());
                    })
                .collect(Collectors.groupingBy(
                        Sales::getProductName,
                        Collectors.summingInt(Sales::getCount)));

        for (String key : resultMap.keySet()) {
            System.out.println(key + " => " + resultMap.get(key));
        }
    }
}