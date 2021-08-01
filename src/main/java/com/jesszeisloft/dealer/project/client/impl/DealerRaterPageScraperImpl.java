package com.jesszeisloft.dealer.project.client.impl;

import com.jesszeisloft.dealer.project.client.DealerRaterPageScraper;
import com.jesszeisloft.dealer.project.util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DealerRaterPageScraperImpl implements DealerRaterPageScraper {
    private static final String DEALER_REVIEW_PAGE_URL =
            Constants.DEALER_RATE_BASE_URL + Constants.MCKAIG_CHEVROLET_REVIEW_ENDPOINT + Constants.PAGE;

    @Override
    public List<String> getReviews() {
        List<String> allReviews = new ArrayList<>();

        IntStream.range(1, Constants.TOTAL_PAGES + 1).forEach(r -> {
            try {
                allReviews.addAll(fetchReviewForPage(r));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return allReviews;
    }

    private List<String> fetchReviewForPage(int pageNum) throws IOException {
        Document doc = Jsoup.connect(DEALER_REVIEW_PAGE_URL + pageNum).get();
        Elements elements = doc.select(Constants.REVIEW_CSS_QUERY);
        return elements.stream().map(Element::text).collect(Collectors.toList());
    }
}
