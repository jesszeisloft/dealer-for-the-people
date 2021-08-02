package com.jesszeisloft.dealer.project;

import com.google.inject.Guice;
import com.jesszeisloft.dealer.project.config.DealerModule;
import com.jesszeisloft.dealer.project.facilitate.FacilitatorFactory;

public class DealerApplication {

    public static void main(String[] args) {
        Guice.createInjector(new DealerModule());
        FacilitatorFactory.getInstance().facilitate();
    }
}
