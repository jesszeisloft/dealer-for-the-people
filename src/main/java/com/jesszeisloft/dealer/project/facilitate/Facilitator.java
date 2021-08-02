package com.jesszeisloft.dealer.project.facilitate;

import com.google.inject.Inject;
import com.jesszeisloft.dealer.project.scraper.DealerRaterPageScraper;
import com.jesszeisloft.dealer.project.eval.ReviewEvaluator;
import com.jesszeisloft.dealer.project.util.PrinterUtil;

import java.util.List;

public class Facilitator {
    @Inject
    private DealerRaterPageScraper client;

    @Inject
    private ReviewEvaluator reviewEvaluator;

    @Inject
    private PrinterUtil printerUtil;

    /**
     * Facilitates the fetching, evaluating, and outputting of reviews
     */
    public void facilitate() {
        List<String> allReviews = client.getReviews();
        List<String> topReviews = reviewEvaluator.evaluateReviews(allReviews);
        printerUtil.printTopReviews(topReviews);
    }
}
