package pro.kensait.java.advanced.lesson4_2_6.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import pro.kensait.java.advanced.lesson4_2_6.sales.Sales;

public class SalesTask implements Callable<Map<String, Integer>> {
    private List<Sales> salesList;
    private String productType;

    public SalesTask(List<Sales> salesList, String productType) {
        this.salesList = salesList;
        this.productType = productType;
    }

    @Override
    public Map<String, Integer> call() throws Exception {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for (Sales s : salesList) {
            if (s.getProductName().startsWith(productType)) {
                String pid = s.getProductName().replace("-", "");
                try { Thread.sleep(1); } catch(Exception e) {}
                Integer sum = resultMap.get(pid);
                if (sum != null) {
                    resultMap.put(pid, sum + s.getCount());
                } else {
                    resultMap.put(pid, s.getCount());
                }
            }
        }
        return resultMap;
    }
}