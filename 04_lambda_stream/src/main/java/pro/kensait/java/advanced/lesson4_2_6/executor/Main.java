package pro.kensait.java.advanced.lesson4_2_6.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import pro.kensait.java.advanced.lesson4_2_6.sales.Sales;
import pro.kensait.java.advanced.lesson4_2_6.sales.SalesHolder;

public class Main {
    public static void main(String[] args) {
        List<Sales> salesList = SalesHolder.getSalesList();
        List<List<Sales>> splitedListList = splitList(salesList, 5);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<Map<String, Integer>>> taskList =
                new ArrayList<Callable<Map<String, Integer>>>();
        for (List<Sales> splitedList : splitedListList) {
            taskList.add(new SalesTask(splitedList, "A"));
        }

        try {
            List<Future<Map<String, Integer>>> futureList =
                    executor.invokeAll(taskList);
            Map<String, Integer> resultMap = combineFutureList(futureList);
            for (String key : resultMap.keySet()) {
                System.out.println(key + " => " + resultMap.get(key));
            }
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }

        executor.shutdown();
    }

    // すべてのフューチャーを1つに統合する
    private static Map<String, Integer> combineFutureList(
            List<Future<Map<String, Integer>>> futureList)
                    throws InterruptedException, ExecutionException {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for (Future<Map<String, Integer>> futureMap : futureList) {
            Map<String, Integer> map = futureMap.get();
            for (String key : map.keySet()) {
                Integer value = resultMap.get(key);
                if (value != null) {
                    resultMap.put(key, value + map.get(key));
                } else {
                    resultMap.put(key, map.get(key));
                }
            }
        }
        return resultMap;
    }

    private static List<List<Sales>> splitList(List<Sales> salesList,
            int parallelCount) {
        int splitedListCount = Double.valueOf(
                Math.ceil(salesList.size() / parallelCount)).intValue();
        List<List<Sales>> resultList = new ArrayList<List<Sales>>();
        for (int i = 0;; i++) {
            int startPoint = i * splitedListCount;
            int endPoint = startPoint + splitedListCount;
            if (endPoint < salesList.size()) {
                resultList.add(salesList.subList(startPoint, endPoint));
                continue;
            } else if (salesList.size() == endPoint) {
                resultList.add(salesList.subList(startPoint, endPoint));
                break;
            } else if (salesList.size() < endPoint) {
                endPoint = salesList.size();
                resultList.add(salesList.subList(startPoint, endPoint));
                break;
            }
        }
        return resultList;
    }
}