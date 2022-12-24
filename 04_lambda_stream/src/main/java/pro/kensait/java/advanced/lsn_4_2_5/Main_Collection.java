package pro.kensait.java.advanced.lsn_4_2_5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_Collection {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            List<Sales> salesList = SalesHolder.getSalesList();
            List<Sales> resultList = salesList.stream()
                    .filter(sales -> sales.getProductName().startsWith("A"))
                    .collect(Collectors.toList());
            System.out.println(resultList);
        }
        {
            System.out.println("***** snippet_2 *****");
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
}