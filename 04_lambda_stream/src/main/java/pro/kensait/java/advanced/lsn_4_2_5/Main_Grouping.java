package pro.kensait.java.advanced.lsn_4_2_5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_Grouping {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            List<Sales> salesList = SalesHolder.getSalesList();
            Map<String, List<Sales>> resultMap = salesList.stream()
                    .filter(sales -> sales.getProductName().startsWith("A"))
                    .collect(Collectors.groupingBy(
                            Sales::getProductName));

            for (String key : resultMap.keySet()) {
                System.out.println(key + " => " + resultMap.get(key));
            }
        }
        {
            System.out.println("***** snippet_2 *****");
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
        {
            System.out.println("***** snippet_3 *****");
            List<Sales> salesList = SalesHolder.getSalesList();
            Map<String, Integer> resultMap = salesList.stream()
                    .filter(sales -> sales.getProductName().startsWith("A"))
                    .collect(Collectors.groupingBy(
                            Sales::getProductName,
                            Collectors.summingInt(Sales::getCount)));

            for (String key : resultMap.keySet()) {
                System.out.println(key + " => " + resultMap.get(key));
            }
        }
    }
}