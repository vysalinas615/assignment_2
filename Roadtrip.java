import java.util.*;
import java.io.*;

public class Roadtrip
{
	static int aSize = 144;
	static int rSize = 522;
	static String[][] attractionsList = new String[aSize][2];
	static String[][] roadsList = new String[rSize][4];
	
	public void addToList(int row, String[] item, String[][] twoD_array, int aSize)
	{
		if (row < aSize)
	    {
	    	twoD_array[row][0] = item[0];
	    	twoD_array[row][1] = item[1];
	    }
	}

	public void addToLargerList(int row, String[] item, String[][] twoD_array, int size)
	{
		if (row < size)
	    {
	    	twoD_array[row][0] = item[0];
	    	twoD_array[row][1] = item[1];
	    	twoD_array[row][2] = item[2];
	    	twoD_array[row][3] = item[3];
	    }
	}

	public void printTwoDArray(int row, int col, int size, String[][] twoD_array)
	{
		System.out.print("{");
		for (row=1; row<size+2; row++)
		{
			if (row>size-1)
			{
				break;
			}

			System.out.print("{");
			for (int c=0;c<col;c++)
			{

				System.out.print("["+twoD_array[row][c]+"]");
			}
			System.out.print("}");
			System.out.println();
		}
		System.out.print("}\n");
	}

	/*public void addAllCities(int size, )
	{
		int i = 0;
		while (i<size)
		{

		}
	}*/

	/*public void findMileage(int col, int size, String[][] twoD_array, String source)
	{
		for (int row=1; row<size+2; row++)
		{
			if (row>size-1)
			{
				break;
			}

			for (int c=0;c<col;c++)
			{

				if (twoD_array[row][c] == "");
			}
			System.out.print("}");
			System.out.println();
		}
		System.out.print("}\n");
	}*/

	public static void main(String[] args) throws IOException
	{
		String line;
        BufferedReader in;
        BufferedReader in2;
        int size = 0;
        int row = 0;
        int col = 0;
        String sourceVertex;
        String targetVertex;
        String[] attractionsToVisit;
        String[] someStrings = new String[2];
        String[] someStrings2 = new String[4];
        Roadtrip obj = new Roadtrip();
        Roadtrip obj2 = new Roadtrip();
        Hashtable<String, String> attractionHT = new Hashtable<>();

         in = new BufferedReader(new FileReader("attractions.csv"));
         line = in.readLine();
         col = 2;
   
         while(line != null)
         {
	    	someStrings = (line.split(","));
	    	row++;
	    	size++;

	    	obj.addToList(row, someStrings, attractionsList, aSize);

	    	line = in.readLine();
	    }
         
        System.out.println();
        //aList.remove(0);
        size--;
        //this removes the attraction, location line and readjuststhe size afer removing those items

        //prints the 2d array of attractions (It starts at 2 in order to skip the null, and atrraction, location lines)
        obj.printTwoDArray(row, col, size, attractionsList);
        System.out.println();

        //adds the attractions and their respective cities to a hashtable. The attraction is the key and the city is the value
        int p = 1;
        while (p<size)
        {
        	attractionHT.put(attractionsList[p][0], attractionsList[p][1]);
        	p++;
        }
        System.out.println("Mappings of the hashtable: " + attractionHT);

        //reads the roads file
        in2 = new BufferedReader(new FileReader("roads.csv"));
        line = in2.readLine();
        row=0;
        size=0;
        col=4;
        System.out.println();
   
        while(line != null)
        {
	    	//System.out.println("LINE:"+line);
	    	someStrings2 = (line.split(","));
	    	//System.out.println("LINE:"+someStrings2);
	    	row++;
	    	size++;

	    	obj2.addToLargerList(row, someStrings2, roadsList, rSize);
	    	//remember this one has 4 items associated with each line instead of 2

	    	line = in2.readLine();
	    }
	    System.out.println();
	    obj2.printTwoDArray(row, col, rSize, roadsList);

	    //Now add the cities as verticies to the weighted graph 
	    //WeightedGraph myGraph = new WeightedGraph();
	    int cityVerticies = size;
	    //Graph myGraph = new Graph(verticies);

	    //PLEASE ADD A CITY NAME FOLLOWED BY THE STATE IN THE sourceVertex VARIABLE
	    sourceVertex = "San Francisco CA";
	    targetVertex = "San Jose CA";
	    //attractionsList = {}

	    //myGraph.addEdge(sourceVertex, targetVertex, )

	}
}