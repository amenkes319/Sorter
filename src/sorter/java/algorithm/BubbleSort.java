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

public class BubbleSort extends Sort
{
	public static final BubbleSort INSTANCE = new BubbleSort();

	public void sort(ObservableList<Node> list)
	{
		timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>()
		{
			int i = 0;
			int j = 0;
			int lastJ = 0;

			@Override
			public void handle(ActionEvent event)
			{
				((Rectangle) list.get(lastJ)).setFill(Color.WHITE);
				((Rectangle) list.get(lastJ + 1)).setFill(Color.WHITE);
				
				Rectangle rect1 = (Rectangle) list.get(j);
				Rectangle rect2 = (Rectangle) list.get(j + 1);

				rect1.setFill(Color.GREEN);
				rect2.setFill(Color.GREEN);
				
				if (rect1.getHeight() > rect2.getHeight())
				{
					double temp = rect1.getHeight();
					rect1.setHeight(rect2.getHeight());
					rect2.setHeight(temp);
				}
				
				lastJ = j;

				if (++j == list.size() - i - 1)
				{
					i++;
					j = 0;
				}
				if (i == list.size() - 1)
				{
					((Rectangle) list.get(lastJ)).setFill(Color.WHITE);
					((Rectangle) list.get(lastJ + 1)).setFill(Color.WHITE);
					
					stop();
				}
			}
		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
