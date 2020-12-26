package sorter.java.algorithm;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class BubbleSort
{
	public static void sort(ObservableList<Node> list)
	{
		
		for (int i = 0; i < list.size() - 1; i++)
		{
			for (int j = 0; j < list.size() - i - 1; j++)
			{
				Rectangle rect1 = (Rectangle) list.get(j);
				Rectangle rect2 = (Rectangle) list.get(j+1);
				if (rect1.getHeight() > rect2.getHeight())
				{
					double temp = rect1.getHeight();
					rect1.setHeight(rect2.getHeight());
					rect2.setHeight(temp);
				}
			}
		}
	}
}
