package com.jesszeisloft.dealer.project.config;

import com.google.inject.AbstractModule;
import com.jesszeisloft.dealer.project.client.DealerRaterPageScraper;
import com.jesszeisloft.dealer.project.client.impl.DealerRaterPageScraperImpl;
import com.jesszeisloft.dealer.project.eval.Evaluator;
import com.jesszeisloft.dealer.project.eval.impl.EvaluatorImpl;
import com.jesszeisloft.dealer.project.facilitate.FacilitatorFactory;

public class DealerModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(Evaluator.class).to(EvaluatorImpl.class);
        bind(DealerRaterPageScraper.class).to(DealerRaterPageScraperImpl.class);
        requestStaticInjection(FacilitatorFactory.class);
    }
}
