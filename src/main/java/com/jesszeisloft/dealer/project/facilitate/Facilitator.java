package com.jesszeisloft.dealer.project.facilitate;

import com.google.inject.Inject;
import com.jesszeisloft.dealer.project.client.DealerRaterClient;
import com.jesszeisloft.dealer.project.eval.Evaluator;

public class Facilitator {
    @Inject
    private DealerRaterClient client;
    @Inject
    private Evaluator evaluator;

    public void facilitate() {
        String[] allReviews = client.getReviews();
        String[] topReviews = evaluator.evaluateReviews(allReviews);
    }
}
