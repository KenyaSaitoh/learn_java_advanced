package pro.kensait.java.lesson6_2_5.sales;

import java.util.List;

public class SalesSumLambdaMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();
        long sum = salesList.parallelStream()
                .filter(s -> s.getProductId().startsWith("A"))
                .mapToInt(s -> s.getSalesCount())
                .sum();

        System.out.println(sum);
    }
}