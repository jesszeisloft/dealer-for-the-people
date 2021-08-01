package com.jesszeisloft.dealer.project.facilitate;

import com.google.inject.Inject;
import com.jesszeisloft.dealer.project.client.DealerRaterPageScraper;
import com.jesszeisloft.dealer.project.eval.Evaluator;

import java.util.List;

public class Facilitator {
    @Inject
    private DealerRaterPageScraper client;
    @Inject
    private Evaluator evaluator;

    public void facilitate() {
        List<String> allReviews = client.getReviews();
        List<String> topReviews = evaluator.evaluateReviews(allReviews);
        System.out.println(topReviews);
    }
}
