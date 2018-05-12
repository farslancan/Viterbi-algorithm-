package viterbiv1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.*;

public class viterbideneme {

	public static void main(String[] args) throws IOException {
		
		
		
		//// DFDFFGGGFFFGGKDDFA dizi
		String s = new String("-DFDFFGGGF");
		String[] input = {"-","D","F","D","F","F","C"};

		
		 List<Double> mmatchdizi = new ArrayList<Double>();
		 List<Double> minsertdizi = new ArrayList<Double>();
		 List<Double> mdeletedizi = new ArrayList<Double>();
		 
		 List<Double> imatchdizi = new ArrayList<Double>();
		 List<Double> iinsertdizi = new ArrayList<Double>();
		 List<Double> ideletedizi = new ArrayList<Double>();
		 
		 List<Double> dmatchdizi = new ArrayList<Double>();
		 List<Double> dinsertdizi = new ArrayList<Double>();
		 List<Double> ddeletedizi = new ArrayList<Double>();
		 
		
		 double[][] moran = new double[][]{
			 { 0,0, 0, 0, 0, 0, 0, 0, 0,0, 0 },
			  { 0,0, (double)1/5, 0, (double)1/5, 0,(double) 2/5, 0, 0,(double) 1/5, 0 },
			  { 0,(double)1/6, (double)1/6, 0, (double)2/6, 0, (double)1/6, 0, 0, (double)1/6, 0 },
			  { 0,0, (double)1/6, 0, (double)2/6, 0, 0,(double) 2/6, 0, (double)1/6, 0 },
			  { 0,0, (double)1/6, 0, (double)2/6, 0, 0,(double) 1/6, 0,(double) 2/6, 0 },
			  { 0,(double)1/5, 0, 0,(double) 1/5, 0, (double)2/5,(double) 1/5, 0, 0, 0 },
			  { 0,0,(double) 1/6, 0,(double) 2/6, 0, 0, 0, 0,(double) 2/6,(double) 1/6 },
			  { 0,0, (double)2/7, 0,(double) 2/7, (double)1/7, 0,(double) 1/7, 0, 0,(double) 1/7 },
			  { 0,(double)1/7, (double)1/7, 0, (double)4/7, 0, 0, (double)1/7, 0, 0, 0 },
			  { 0,0,(double) 1/7, 0, (double)2/7, 0,(double) 1/7, (double)1/7, 0, (double)1/7, (double)1/7 },
			  { 0,0, 0, 0, (double)1/7,(double) 1/7, (double)1/7, 0, 0, (double)3/7, 0 },
			  { 0,(double)1/6, 0, 0,(double) 3/6, 0,(double) 1/6, 0, 0,(double) 1/6, 0 },
			  { 0,0, 0, 0,(double) 2/6,(double) 2/6,(double) 1/6,(double) 1/6, 0, 0, 0 },
			  { 0,0, 0, 0, 0, 0,(double) 1/6, 0, (double)1/6, (double)3/6,(double) 1/6 },
			  { 0,0, 0, 0,(double)2/5, 0, 0, 0, 0,(double) 1/5,(double) 2/5 },
			};

        
			
		 //// match match
		 mmatchdizi.add((double) 1.000); mmatchdizi.add((double) 5/8);mmatchdizi.add((double) 4/5);
		 mmatchdizi.add((double) 6/6);mmatchdizi.add((double) 6/6);mmatchdizi.add((double) 5/6);
		 mmatchdizi.add((double) 5/5);mmatchdizi.add((double) 6/6);mmatchdizi.add((double) 7/7 );
		 mmatchdizi.add((double) 7/7 );mmatchdizi.add((double) 6/7 );mmatchdizi.add((double) 6/7 );
		 mmatchdizi.add((double) 5/6 );mmatchdizi.add((double) 1/6 );mmatchdizi.add((double)5/6 );
		 //// match insert
		 minsertdizi.add((double) 0.000); minsertdizi.add((double) 0.000);minsertdizi.add((double) 0.000);
		 minsertdizi.add((double) 0.000);minsertdizi.add((double) 0.000);minsertdizi.add((double) 0.000);
		 minsertdizi.add((double) 0.000);minsertdizi.add((double) 0.000);minsertdizi.add((double) 0.000);
		 minsertdizi.add((double) 0.000);minsertdizi.add((double) 0.000);minsertdizi.add((double) 0.000);
		 minsertdizi.add((double) 0.000);minsertdizi.add((double) 3/3);minsertdizi.add((double) 0.000);
		 //// match delete
		 mdeletedizi.add((double) 0.000);mdeletedizi.add((double) 0.000);mdeletedizi.add((double)2/3);
		 mdeletedizi.add((double) 0.000);mdeletedizi.add((double) 0.000);mdeletedizi.add((double) 0.000);
		 mdeletedizi.add((double) 1/3);mdeletedizi.add((double) 1/2);mdeletedizi.add((double) 0.000);
		 mdeletedizi.add((double) 0.000);mdeletedizi.add((double) 1/1);mdeletedizi.add((double) 0.000);
		 mdeletedizi.add((double) 1/2);mdeletedizi.add((double) 2/2);mdeletedizi.add((double) 0.000);
	     //// insert match
		 imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);
		 imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);
		 imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);
		 imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);
		 imatchdizi.add((double) 3/6);imatchdizi.add((double) 0.000);imatchdizi.add((double) 0.000);
		 //// insert insert
		 iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);
		 iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);
		 iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);
		 iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);
		 iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);iinsertdizi.add((double) 0.000);
		 //// insert delete
	     ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);
	     ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);
	     ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);
	     ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);
	     ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);ideletedizi.add((double) 0.000);
	     //// delete match
	     dmatchdizi.add((double) 0.000);dmatchdizi.add((double) 3/8);dmatchdizi.add((double) 1/5);
	     dmatchdizi.add((double) 0.000);dmatchdizi.add((double) 0.000);dmatchdizi.add((double) 1/6 );
	     dmatchdizi.add((double) 0.000);dmatchdizi.add((double) 0.000);dmatchdizi.add((double) 0.000);
	     dmatchdizi.add((double) 0.000);dmatchdizi.add((double) 1/7);dmatchdizi.add((double) 1/7 );
	     dmatchdizi.add((double) 1/6 );dmatchdizi.add((double) 2/6 );dmatchdizi.add((double) 1/6 );
	     //// delete insert
	     dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);
	     dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);
	     dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);
	     dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);
	     dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);dinsertdizi.add((double) 0.000);
	     //// delete delete 
	     ddeletedizi.add((double) 0.000);ddeletedizi.add((double) 0.000);ddeletedizi.add((double) 1/3);
	     ddeletedizi.add((double) 2/2);ddeletedizi.add((double) 2/2);ddeletedizi.add((double) 2/2);
	     ddeletedizi.add((double) 2/3);ddeletedizi.add((double) 1/2);ddeletedizi.add((double) 1/1);
	     ddeletedizi.add((double) 1/1);ddeletedizi.add((double) 0.000);ddeletedizi.add((double) 1/1);
	     ddeletedizi.add((double) 1/2);ddeletedizi.add((double) 0.000);ddeletedizi.add((double) 2/2);
//// Viterbi begins
	     
	     double[][] mviterbi = new double[mmatchdizi.size()*3][input.length];
	     mviterbi[0][0]=(double)1.000;
	     mviterbi[1][0]=(double)0.000;
	     mviterbi[2][0]=(double)0.000;
	     for(int i=1;i<input.length;i++)
	     {mviterbi[0][i]=(double)0.000;
	     mviterbi[1][i]=(double)0.000;
	     mviterbi[2][i]=(double)0.000;
	     }
	     //// viterbi first initialization ends
	     /// real viterbi begins
	     for(int i=3;i<mmatchdizi.size()*3;i++)
	     {
	    /*match*/	// Math.max(Math.max(scoreDiag, scoreLeft), scoreUp); bu for yapýsýna girmiyor.????
	    	 if(i%3==0){
	    		 mviterbi[i][0]=(double)0.000;
	    	 for(int j=1;j<input.length;j++)
		     {  
	    		
	    		 if(input[j].equals("A")){mviterbi[i][j]= (moran[i/3][1])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("B")){mviterbi[i][j]=(moran[i/3][2])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("C")){mviterbi[i][j]= (moran[i/3][3])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("D")){mviterbi[i][j]= (moran[i/3][4])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("E")){mviterbi[i][j]=(moran[i/3][5])*Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("F")){mviterbi[i][j]= (moran[i/3][6])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("G")){mviterbi[i][j]=(moran[i/3][7])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("H")){mviterbi[i][j]= (moran[i/3][8])*Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("K")){mviterbi[i][j]= (moran[i/3][9])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		else if(input[j].equals("L")){mviterbi[i][j]= (moran[i/3][10])* Math.max(Math.max(((mviterbi[i-3][j-1])*mmatchdizi.get(i/3)),((mviterbi[i-2][j-1])*minsertdizi.get(i/3))),((mviterbi[i-1][j-1])*mdeletedizi.get(i/3)) );}	 
	    		//else {mviterbi[i][j]=(double)1.000;}

		     }
	    }
	    /*insert*/	 
	    	 if(i%3==1){
	    		 for(int j=0;j<input.length;j++)
			     {  
	    		   mviterbi[i][j]= (1/10)* Math.max(((mviterbi[i-4][j])*imatchdizi.get(i/3)) ,( (mviterbi[i-3][j])*iinsertdizi.get(i/3)));
			     }
			     }
	    /*delete*/	 
	    	 if(i%3==2){
	    		 for(int j=0;j<input.length;j++)
			     {
	    			 mviterbi[i][j]= Math.max(((mviterbi[i-5][j])*dmatchdizi.get(i/3)) ,( (mviterbi[i-3][j])*ddeletedizi.get(i/3)) );
			     }
			     }
	    	 }
	    
	    //// ends viterbi
	     for (int i=0;i<mmatchdizi.size()*3;i++) {
	    	 for(int j=0;j<input.length;j++)
		         System.out.print(mviterbi[i][j] + "\t");
		     System.out.println();
		 }
	     System.out.println("\n");
	     double max = mviterbi[0][input.length-1];
	     for (int i=1;i<mviterbi.length;i++) {

	    	 if (mviterbi[i][input.length-1] > max){ // check the column elements instead of row elements
	                max = mviterbi[i][input.length-1]; // get the column values 
	            }
		 } System.out.println(max + "      ");

	     
	     //// max ends
	}
	}

