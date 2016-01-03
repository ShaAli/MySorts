//Shanjeed Ali
//APCS1 pd10

import java.util.ArrayList;

public class MySorts {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for(int i=0;i<data.size()-1;i++){
	    for(int c=data.size()-1;c>0;c--){
		int a=data.get(c).compareTo(data.get(c-1));
		if (a<0){
		    //switch if data.get(c) is less than data.get(c-1)
		    Comparable old=data.set(c-1,data.get(c));
		    data.set(c, old);
		}
	    }
	}
    }//end bubbleSortV -- O(?)

    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	ArrayList<Comparable> newdata=new ArrayList<Comparable>();
	newdata=input;
	//replicate input and sort the copy
	bubbleSortV(newdata);
	return newdata;	
    }//end bubbleSort -- O(?)

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
        for (int i=0; i<data.size()-1; i++){
	    boolean doswap=false;
	    int newpos=0;
	    Comparable min=data.get(i);
	    for(int c=i+1; c<data.size(); c++){
		if (data.get(c).compareTo(min)<0){
		    min=data.get(c);
		    newpos=c;
		    doswap=true;
		}
	    }
	    if (doswap){
		swap(newpos,i,data);
		doswap=false;
	    }
	}
    }//end selectionSort -- O(?)

    public static void swap(int index1, int index2, ArrayList<Comparable> data){
	Comparable old=data.set(index1,data.get(index2));
	data.set(index2,old);
    }

    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> output= new ArrayList<Comparable>();
	output=input;
	selectionSortV(output);
	return output;
    }//end selectionSort -- O(?)


    public static void main( String [] args ) {
    }//end main

}//end class
