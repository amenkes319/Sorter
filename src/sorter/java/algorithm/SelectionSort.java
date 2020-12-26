package sorter.java.algorithm;

import javafx.scene.shape.Rectangle;

public class SelectionSort
{
	public static void sort(Rectangle[] a)
	{
		for (int i = 0; i < a.length - 1; i++) 
        {
            int min = i; 
            for (int j = i+1; j < a.length; j++)
            {
                if (a[j].getHeight() < a[min].getHeight()) 
                {
                	min = j;
                }
            }
  
            double temp = a[min].getHeight(); 
            a[min].setHeight(a[i].getHeight()); 
            a[i].setHeight(temp); 
        } 
	}
}
