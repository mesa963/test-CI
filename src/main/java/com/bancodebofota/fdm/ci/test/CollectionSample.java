/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebofota.fdm.ci.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Jamm
 */
public class CollectionSample {
    
private boolean printNumbers; //flag to print numbers on the console
    private int size; //amount of numbers to iterate
    private List<String> arrayList = null; //source of data

    /**
     * Constructor to create instances of member fields
     * @size is the amount of numbers to transverse
     * @printNumbers is the flag to print the value on the console
     */
    public CollectionSample(int size, boolean printNumbers) {
        arrayList = new ArrayList();
        this.size = size;
        this.printNumbers = printNumbers;
    }

    /**
     * Init data depending of the size field
     */
    public void initArray() {
        arrayList.clear();
        for (int i = 0; i < size; i++) {
            arrayList.add(i + "");
        }
    }

    /**
     * Ordering values as String
     * Uses a anonymous comparator implementation
     * sort using Collection utils and print if
     * the field printNumbers has been set to true
     *
     */
    public void oderArrayWithComparator() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o2, String o1) {
                return o1.compareTo(o2);
            }
        };

        Collections.sort(this.arrayList, comparator);

        System.out.println("oderArrayWithComparator");
        for (String s : this.arrayList) {
            if (printNumbers) {
                System.out.println(s);
            }
        }
    }

    /**
     * Ordering values as Integer
     * Uses a anonymous comparator implementation
     * sort using Collection utils and print if
     * the field printNumbers has been set to true
     *
     */
    public void oderArrayWithComparatorInteger() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2).compareTo(Integer.valueOf(o1));
            }
        };
        Collections.sort(this.arrayList, comparator);

        System.out.println("oderArrayWithComparatorInteger");
        for (String s : this.arrayList) {
            if (printNumbers) {
                System.out.println(s);
            }
        }
    }

    /**
     * Ordering values as String
     * Uses a anonymous comparator implementation
     * sort using stream and print if
     * the field printNumbers has been set to true
     */
    public void orderingDataWithLambdaExpressionAndComparatorAsString() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        System.out.println("orderingDataWithLambdaExpressionAndComparatorAsString");
        this.arrayList.stream().sorted(comparator).forEach(val -> {
            if (printNumbers) {
                System.out.println(val);
            }
        });
    }

    /**
     * Ordering values as Integer
     * Uses a anonymous comparator implementation
     * sort using stream and print if
     * the field printNumbers has been set to true
     */
    public void orderingDataWithLambdaExpressionAndComparatorAsInteger() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2).compareTo(Integer.valueOf(o1));
            }
        };
        System.out.println("orderingDataWithLambdaExpressionAndComparatorAsInteger");
        this.arrayList.stream().sorted(comparator).forEach(val -> {
            if (printNumbers) {
                System.out.println(val);
            }
        });
    }

    /**
     * Ordering values as String
     * Uses a lambda expression as comparator implementation
     * sort using stream and print if
     * the field printNumbers has been set to true
     */
    public void orderingDataWithPureLambdaExpressionString() {

        System.out.println("orderingDataWithPureLambdaExpressionString");
        this.arrayList.stream().sorted((o1, o2) -> o2.compareTo(o1)).forEach(val -> {
            if (printNumbers) {
                System.out.println(val);
            }
        });
    }

    /**
     * Ordering values as Integer
     * Uses a lambda expression as comparator implementation
     * sort using stream and print if
     * the field printNumbers has been set to true
     */
    public void orderingDataWithPureLambdaExpressionInteger() {
        System.out.println("orderingDataWithPureLambdaExpressionInteger");
        this.arrayList.stream().sorted((o1, o2) -> Integer.valueOf(o2).compareTo(Integer.valueOf(o1))).forEach(val -> {
            if (printNumbers) {
                System.out.println(val);
            }
        });
    }

    /**
     * Ordering values as String
     * Uses Comparator.reverseOrder as comparator implementation
     * sort using stream and print if
     * the field printNumbers has been set to true
     */
    public void orderingDataWithPureLambdaExpressionStringWithReverseOrder() {

        System.out.println("orderingDataWithPureLambdaExpressionStringWithReverseOrder");
        this.arrayList.stream().sorted(Comparator.reverseOrder()).forEach(val -> {
            if (printNumbers) {
                System.out.println(val);
            }
        });
    }

    /**
     * Ordering values as Integer
     * Uses Comparator.reverseOrder as comparator implementation
     * sort using stream and print if
     * the field printNumbers has been set to true
     */
    public void orderingDataWithPureLambdaExpressionIntegerWithReverseOrder() {
        System.out.println("orderingDataWithPureLambdaExpressionIntegerWithReverseOrder");
        this.arrayList.stream().sorted(Comparator.reverseOrder()).forEach(val -> {
            if (printNumbers) {
                System.out.println(val);
            }
        });
    }

    /**
     *
     * invoke all the calls to the methods and measures the time in milliseconds every implementation
     * spend to execute
     */
    public static void main(String[] args) {
        /**
         * param size and printNumbers can be modified to have a better analisys in terms of amount of time
         * spent by each implementation
         */
        CollectionSample collectionSample = new CollectionSample(1000000, false);
        long startTime = 0L;
        long endTime = 0L;


        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.oderArrayWithComparator();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.oderArrayWithComparatorInteger();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.orderingDataWithLambdaExpressionAndComparatorAsString();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.orderingDataWithLambdaExpressionAndComparatorAsInteger();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.orderingDataWithPureLambdaExpressionString();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.orderingDataWithPureLambdaExpressionInteger();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.orderingDataWithPureLambdaExpressionIntegerWithReverseOrder();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        collectionSample.initArray();
        startTime = System.currentTimeMillis();
        collectionSample.orderingDataWithPureLambdaExpressionStringWithReverseOrder();
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");


    }
}
