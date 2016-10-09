package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {
//		A<ArrayList<String>> list = new A<ArrayList<String>>();
	    System.out.println(getFormatAvgScore(0));
	    System.out.println(getFormatAvgScore(5));
	}

	public static String getFormatAvgScore(long avgScore){
        DecimalFormat df = new DecimalFormat("####.0");
        float f = (float)(((avgScore+5.0)/10)*100);
        int avg = (int)f;
        String formatAvgScore = df.format(f);
        if(avg-f==0){
            formatAvgScore = String.valueOf(avg);
        }
        return formatAvgScore;
    }
}
