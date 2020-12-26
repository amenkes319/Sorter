package sorter.java.algorithm;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class InsertionSort extends Sort
{
	public void sort(Rectangle[] a)
	{
        for (int i = 1; i < a.length; ++i)
        { 
            double key = a[i].getHeight(); 
            int j = i - 1; 
  
            while (j >= 0 && a[j].getHeight() > key)
            { 
                a[j + 1].setHeight(a[j--].getHeight());
            } 
            
            a[j + 1].setHeight(key); 
        } 
	}

	@Override
	public void sort(ObservableList<Node> list)
	{
	}
}
