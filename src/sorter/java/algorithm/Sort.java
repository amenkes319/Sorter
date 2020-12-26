package sorter.java.algorithm;

import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import sorter.java.Controller;

public abstract class Sort
{
	protected Timeline timeline;
	
	public abstract void sort(ObservableList<Node> list);

	public void stop()
	{
		timeline.stop();
		Controller.INSTANCE.enable();
	}
}
