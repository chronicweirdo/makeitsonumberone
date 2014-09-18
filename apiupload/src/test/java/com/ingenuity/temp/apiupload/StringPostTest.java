package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.junit.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by scacoveanu on 9/17/2014.
 */
public class StringPostTest {

    @org.junit.Test
    public void sentLargePost() throws Exception {
        //String contents = "projectname=API_multi_obs_isoforms_b&datasetname=TwoObswithIsoforms&obs1name=Experiment_of_Breast_cancer_30_patients_vs_normal_12&obs2name=Experiment_of_Colon_cancer_vs_normal&geneidtype=refseq&geneid=NM_000610&expvaltype=foldchange&expvalue=-60.783&expvaltype2=pvalue&expval2=3.23E-02&expvaltype3=intensity&expval3=26338.295&obs2expvaltype=foldchange&obs2expval=100&obs2expvaltype2=pvalue&obs2expval2=0.001&obs2expvaltype3=intensity&obs2expval3=1000&geneidtype=refseq&geneid=NM_001001390&expvaltype=foldchange&expvalue=-8.498&expvaltype2=pvalue&expval2=3.53E-01&expvaltype3=intensity&expval3=35973.896&obs2expvaltype=foldchange&obs2expval=200&obs2expvaltype2=pvalue&obs2expval2=0.001&obs2expvaltype3=intensity&obs2expval3=1000&geneidtype=refseq&geneid=NM_001001389&expvaltype=foldchange&expvalue=-5.806&expvaltype2=pvalue&expval2=1.54E-01&expvaltype3=intensity&expval3=37430.501&obs2expvaltype=foldchange&obs2expval=100&obs2expvaltype2=pvalue&obs2expval2=0.001&obs2expvaltype3=intensity&obs2expval3=1000&geneidtype=refseq&geneid=NM_001001392&expvaltype=foldchange&expvalue=-1.2&expvaltype2=pvalue&expval2=7.55E-01&expvaltype3=intensity&expval3=384.726&obs2expvaltype=foldchange&obs2expval=100&obs2expvaltype2=pvalue&obs2expval2=0.001&obs2expvaltype3=intensity&obs2expval3=1000&geneidtype=refseq&geneid=NM_001001391&expvaltype=foldchange&expvalue=46.115&expvaltype2=pvalue&expval2=1.60E-03&expvaltype3=intensity&expval3=368349.354&obs2expvaltype=foldchange&obs2expval=100&obs2expvaltype2=pvalue&obs2expval2=0.001&obs2expvaltype3=intensity&obs2expval3=1000&geneid=NM_001114091&expvaltype=foldchange&expvalue=6.1&expvaltype2=pvalue&expval2=1.90E-03&expvaltype3=intensity&expval3=41000&obs2expvaltype=foldchange&obs2expval=12.1&obs2expvaltype2=pvalue&obs2expval2=0.00001&obs2expvaltype3=intensity&obs2expval3=34555&ipaview=upload&applicationname=MyTest";
        //String contents = "projectname=API_multi_obs_isoforms_b&datasetname=TwoObswithIsoforms&obs1name=Experiment_of_Breast_cancer_30_patients_vs_normal_12&obs2name=Experiment_of_Colon_cancer_vs_normal&geneidtype=refseq&expvaltype=foldchange&expvaltype2=pvalue&expvaltype3=intensity&geneid=NM_000610&expvalue=-60.783&expval2=3.23E-02&expval3=26338.295&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001390&expvalue=-8.498&expval2=3.53E-01&expval3=35973.896&obs2expval=200&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001389&expvalue=-5.806&expval2=1.54E-01&expval3=37430.501&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001392&expvalue=-1.2&expval2=7.55E-01&expval3=384.726&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001391&expvalue=46.115&expval2=1.60E-03&expval3=368349.354&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001114091&expvalue=6.1&expval2=1.90E-03&expval3=41000&obs2expval=12.1&obs2expval2=0.00001&obs2expval3=34555&ipaview=upload&applicationname=MyTest";
        //String contents = "projectname=API_multi_obs_isoforms_b&datasetname=TwoObswithIsoforms&obs1name=Experiment_of_Breast_cancer_30_patients_vs_normal_12&obs2name=Experiment_of_Colon_cancer_vs_normal&geneidtype=refseq&expvaltype=foldchange&expvaltype2=pvalue&expvaltype3=intensity&geneid=NM_000610&expvalue=-60.783&expval2=3.23E-02&expval3=26338.295&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001390&expvalue=-8.498&expval2=3.53E-01&expval3=35973.896&obs2expval=200&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001389&expvalue=-5.806&expval2=1.54E-01&expval3=37430.501&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001392&expvalue=-1.2&expval2=7.55E-01&expval3=384.726&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001391&expvalue=46.115&expval2=1.60E-03&expval3=368349.354&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001114091&expvalue=6.1&expval2=1.90E-03&expval3=41000&obs2expval=12.1&obs2expval2=0.00001&obs2expval3=34555&ipaview=upload&applicationname=MyTest&obs2absent=&obs2absent=&obs2absent=&obs2absent=&obs2absent=&obs2override=&obs2override=&obs2override=&obs2override=&obs2override=";
        //String contents = "projectname=API_multi_obs_isoforms_b&datasetname=TwoObswithIsoforms&obs1name=Experiment_of_Breast_cancer_30_patients_vs_normal_12&obs2name=Experiment_of_Colon_cancer_vs_normal&geneidtype=refseq&expvaltype=foldchange&expvaltype2=pvalue&expvaltype3=intensity&geneid=NM_000610&expvalue=-60.783&expval2=3.23E-02&expval3=26338.295&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001390&expvalue=-8.498&expval2=3.53E-01&expval3=35973.896&obs2expval=200&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001389&expvalue=-5.806&expval2=1.54E-01&expval3=37430.501&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001392&expvalue=-1.2&expval2=7.55E-01&expval3=384.726&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001391&expvalue=46.115&expval2=1.60E-03&expval3=368349.354&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001114091&expvalue=6.1&expval2=1.90E-03&expval3=41000&obs2expval=12.1&obs2expval2=0.00001&obs2expval3=34555&ipaview=upload&applicationname=MyTest&absent2=-&absent2=-&absent2=-&absent2=-&absent2=-&absent2=-&override2=-&override2=-&override2=-&override2=-&override2=-&override2=-";
        //String contents = "projectname=API_multi_obs_isoforms_b&datasetname=TwoObswithIsoforms&obs1name=Experiment_of_Breast_cancer_30_patients_vs_normal_12&obs2name=Experiment_of_Colon_cancer_vs_normal&geneidtype=refseq&expvaltype=foldchange&expvaltype2=pvalue&expvaltype3=intensity&geneid=NM_000610&expvalue=-60.783&expval2=3.23E-02&expval3=26338.295&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001390&expvalue=-8.498&expval2=3.53E-01&expval3=35973.896&obs2expval=200&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001389&expvalue=-5.806&expval2=1.54E-01&expval3=37430.501&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001392&expvalue=-1.2&expval2=7.55E-01&expval3=384.726&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001391&expvalue=46.115&expval2=1.60E-03&expval3=368349.354&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001114091&expvalue=6.1&expval2=1.90E-03&expval3=41000&obs2expval=12.1&obs2expval2=0.00001&obs2expval3=34555&ipaview=upload&applicationname=MyTest&absent2=&absent2=&absent2=&absent2=&absent2=&absent2=&override2=&override2=&override2=&override2=&override2=&override2=&genecolname=genecol&expvalname=expval&expval2name=expval2&expval3name=expval3&overridename=override&absentname=absent";
        String contents = "projectname=API_multi_obs_isoforms_b&datasetname=TwoObswithIsoforms&obs1name=Experiment_of_Breast_cancer_30_patients_vs_normal_12&obs2name=Experiment_of_Colon_cancer_vs_normal&geneidtype=refseq&expvaltype=foldchange&expvaltype2=pvalue&expvaltype3=intensity&geneid=NM_000610&expvalue=-60.783&expval2=3.23E-02&expval3=26338.295&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001390&expvalue=-8.498&expval2=3.53E-01&expval3=35973.896&obs2expval=200&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001389&expvalue=-5.806&expval2=1.54E-01&expval3=37430.501&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001392&expvalue=-1.2&expval2=7.55E-01&expval3=384.726&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001001391&expvalue=46.115&expval2=1.60E-03&expval3=368349.354&obs2expval=100&obs2expval2=0.001&obs2expval3=1000&geneid=NM_001114091&expvalue=6.1&expval2=1.90E-03&expval3=41000&obs2expval=12.1&obs2expval2=0.00001&obs2expval3=34555&ipaview=projectmanager&applicationname=MyTest&absent2=&absent2=&absent2=&absent2=&absent2=&absent2=&override2=&override2=&override2=&override2=&override2=&override2=&genecolname=genecol&expvalname=expval&expval2name=expval2&expval3name=expval3&overridename=override&absentname=absent";
        sendPost(contents);
    }

    public void sendPost(final String contents) {
        // login
        String serverpath = "https://analysis-stable.ingenuity.com";
        ApiLogin login = new ApiLogin("scacoveanu@ingenuity.com", "test1234", serverpath);
        HttpClient client = login.getClient();

        // send post
        //String apipath = "/pa/api/v2/multiobsupload";
        String apipath = "/pa/api/v1/dataupload";
        PostMethod post = new PostMethod(serverpath + apipath);
        post.getParams().setSoTimeout(0);
        post.setRequestEntity(new RequestEntity() {
            public boolean isRepeatable() {
                return true;
            }

            public void writeRequest(OutputStream out) throws IOException {
                OutputStreamWriter writer = new OutputStreamWriter(out);
                writer.write(contents);
                writer.flush();
            }

            public long getContentLength() {
                return contents.length();
            }

            public String getContentType() {
                return "application/x-www-form-urlencoded";
            }
        });
        try {
            client.executeMethod(post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = Util.getResponseBody(post);
        System.out.println(result);
        GenericApi.openIPA(post);
    }
}
