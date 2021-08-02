package com.jesszeisloft.dealer.project.util.impl;

import com.jesszeisloft.dealer.project.util.Constants;
import com.jesszeisloft.dealer.project.util.PrinterUtil;

import java.util.List;
import java.util.stream.IntStream;

public class PrinterUtilImpl implements PrinterUtil {

    @Override
    public void printReviews(List<String> reviews) {
        IntStream.range(0, Math.min(Constants.NUM_TOP_REVIEWS, reviews.size())).forEach(
                r -> System.out.println((r + 1) + ". " + reviews.get(r))
        );
    }
}
