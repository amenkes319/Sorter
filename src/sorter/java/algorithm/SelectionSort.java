package sorter.java.algorithm;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SelectionSort extends Sort
{
	public static final SelectionSort INSTANCE = new SelectionSort();
	public void sort(ObservableList<Node> list)
	{
		timeline = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>()
		{
			int i = 0;
			int j = i+1;
			int lastJ = 0;

			int min = i;

			@Override
			public void handle(ActionEvent event)
			{
				((Rectangle) list.get(lastJ)).setFill(Color.WHITE);
				
				Rectangle rect1 = (Rectangle) list.get(min);
				Rectangle rect2 = (Rectangle) list.get(j);

				rect1.setFill(Color.RED);
				rect2.setFill(Color.RED);
				
                if (rect2.getHeight() < rect1.getHeight()) 
                {
                	min = j;
                	rect1.setFill(Color.WHITE);
                	rect1 = (Rectangle) list.get(min);
                	rect1.setFill(Color.GREEN);
                }
				
				lastJ = j;

				if (++j == list.size())
				{
					Rectangle rect3 = (Rectangle) list.get(i);
		            double temp = rect1.getHeight(); 
		            rect1.setHeight(rect3.getHeight()); 
		            rect3.setHeight(temp);
		            rect3.setFill(Color.GREEN);
		            
					i++;
					j = i+1;
					min = i;
				}
				if (i == list.size() - 1)
				{
					((Rectangle) list.get(lastJ)).setFill(Color.GREEN);
					
					stop();
				}
			}
		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
