package sorter.java;

import java.util.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sorter.java.algorithm.BubbleSort;

public class Controller
{
	private enum Algorithm
	{
		BEAD_SORT("Bead Sort"), BLOCK_SORT("Block Sort"), BUBBLE_SORT("Bubble Sort"), COCKTAIL_SORT("Cocktail Sort"),
		COMB_SORT("Comb Sort"), FLASH_SORT("Flash Sort"), GNOME_SORT("Gnome Sort"), HEAP_SORT("Heap Sort"),
		INSERTION_SORT("Insertion Sort"), LINEAR_SORT("Linear Sort"), MERGE_SORT("Merge Sort"), QUICK_SORT("Quick Sort"),
		RADIX_SORT("Radix Sort"), SELECTION_SORT("Selection Sort"), SHELL_SORT("Shell Sort"), SMOOTH_SORT("Smooth Sort");
		
		String string;

		private Algorithm(String string)
		{
			this.string = string;
		}
		
		public static Algorithm toEnum(String string)
		{
			for (Algorithm algo : Algorithm.values())
			{
				if (string.equals(algo.toString()))
					return algo;
			}
			
			return null;
		}
		
		public String toString()
		{
			return string;
		}
	}
	
	private Scene scene;
	
	@FXML
	private HBox hboxCenter;
	
	@FXML
	private Button btnRandom, btnStart, btnStop;
	
	@FXML
	private Slider slderSize;
	
	@FXML
	private ChoiceBox<String> dropSorter;
	
	public Controller()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\resources\\sorter.fxml"));
			loader.setController(this);
			scene = new Scene(loader.load());
			
			init();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void show(Stage stage)
	{
		stage.setScene(scene);
		stage.show();
	}
	
	private void init()
	{
		for (Algorithm algo : Algorithm.values())
			dropSorter.getItems().add(algo.toString());
		
		slderSize.setMin(10);
		slderSize.setMax(100);
		slderSize.setValue(20);
		fillRects(slderSize.getValue());
		
		slderSize.valueProperty().addListener(new ChangeListener<Number>() 
		{
            public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) 
            {
            	fillRects(newVal.intValue());
            }
        });
		
		btnStart.setOnAction(e ->
		{
			BubbleSort.sort(hboxCenter.getChildren());
//			Algorithm algo = null;
//			if (dropSorter.getValue() != null)
//			{
//				algo = Algorithm.toEnum(dropSorter.getValue());
//				System.out.println(algo.name());
//			}
		});
	}
	
	private void fillRects(double max)
	{
		hboxCenter.getChildren().clear();
    	for (int i = 0; i < max; i++)
    	{
    		double width = Math.pow(Math.E, -.03 * (max - 150)) + 10;
    		double height = 7.5*i + 50;
    		hboxCenter.getChildren().add(new Rectangle(width, height));
    	}
    	
    	FXCollections.shuffle(hboxCenter.getChildren());
	}
}
