package com.ingenuity.test.api;

import com.ingenuity.analysis.api.v1.service.AnalysisSummaryDataProvider;
import org.junit.Test;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class ProviderTest {

    @Test
    public void instantiateProvider() throws Exception {
        String serviceUrl = "https://analysis-stable.ingenuity.com/pa/";
        String serviceEndpoint = "ipa/analysissummary";
        Class interfaceClass = AnalysisSummaryDataProvider.class;

        //RequestExecutor

        HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
        factory.setServiceUrl(serviceUrl + serviceEndpoint);
        factory.setServiceInterface(interfaceClass);
        //factory.setHttpInvokerRequestExecutor(requestExecutor);
    }
}
