package it.corso.java.web.beans;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class ReadFile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private File file;
	private ArrayList<Integer> day;
	private ArrayList<Integer> maxT;
	private ArrayList<Integer> minT;
	private ArrayList<Integer> diff;
	
	
	public ArrayList<Integer> calculateRange(ArrayList<Integer> maxT, ArrayList<Integer> minT) {

        for (int i = 0; i < day.size(); i++) {

            System.out.println( day.get(i) + "  " + maxT.get(i) + "  " + minT.get(i));

            diff.add(maxT.get(i) - minT.get(i));

            //System.out.println("diff "+diff);

        }
        

        return diff;
    }
	

    public int dayWithMin(int min) {


        for(int i=0; i<day.size(); i++) {

            min = Collections.min(diff);
            if(day.indexOf(day.get(i))==diff.indexOf(min)){
                //System.out.println("index of "+diff.indexOf(min));
                int g = day.get(i);
                System.out.println("Il giorno con la escursione minima è: "+g);
                return  g;
            }
        }
        System.out.println("min"+min);
        return min;
    }



	
	
	
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
	public ArrayList<Integer> getDay() {
		return day;
	}
	public void setDay(ArrayList<Integer> day) {
		this.day = day;
	}
	public ArrayList<Integer> getMaxT() {
		return maxT;
	}
	public void setMaxT(ArrayList<Integer> maxT) {
		this.maxT = maxT;
	}
	public ArrayList<Integer> getMinT() {
		return minT;
	}
	public void setMinT(ArrayList<Integer> minT) {
		this.minT = minT;
	}
	public ArrayList<Integer> getDiff() {
		return diff;
	}
	public void setDiff(ArrayList<Integer> diff) {
		this.diff = diff;
	}
	


	
}
