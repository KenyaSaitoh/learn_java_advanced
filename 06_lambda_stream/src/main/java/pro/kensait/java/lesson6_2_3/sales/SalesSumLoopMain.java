package pro.kensait.java.lesson6_2_3.sales;

import java.util.List;

public class SalesSumLoopMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();
        long sum = 0L;
        for (Sales s : salesList) {
            if (s.getProductId().startsWith("A")) {
                sum = sum + s.getSalesCount();
            }
        }

        System.out.println(sum);
    }
}