package org.chronicweirdo.junk.new8;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by scacoveanu on 8/21/2014.
 *
 * http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 */
public class LambdaExpressions {

    private String[] stringData;

    @Before
    public void setUp() throws Exception {
        stringData = new String[] {"anonymous", "xenofobia", "beauty", "collision", "computer", "decision", "example"};
    }

    @Test
    public void labda1() throws Exception {
        System.out.println(Arrays.toString(stringData));
    }

    @Test
    public void runnableLambda() throws Exception {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable1");
            }
        };

        Runnable runnable2 = () -> System.out.println("Runnable2");

        runnable1.run();
        runnable2.run();
        //(() -> System.out.println("Runnable3")).run();
    }

    @Test
    public void comparatorLambda() throws Exception {
        List<String> stringDataList = Arrays.asList(stringData);
        Collections.sort(stringDataList, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(stringDataList);

        Collections.sort(stringDataList, (s1, s2) -> Character.compare(s1.charAt(1), s2.charAt(1)));
        System.out.println(stringDataList);
    }

    @Test
    public void listenerLambda() throws Exception {
        JButton button = new JButton("Test Button");
        button.addActionListener(e -> System.out.println("button clicked"));
        button.doClick();
    }
}
