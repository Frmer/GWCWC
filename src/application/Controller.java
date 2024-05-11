package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.fxml.*;

public class Controller implements Initializable{

//	Data data = new Data();
	@FXML
	private TextField tf1;
	@FXML
	private TextField tf2;
	@FXML
	private CheckBox cb1;
	@FXML
	private Spinner<Integer> spinner1;
	@FXML
	private Label youHaveLbl;
	@FXML
	private Label youNeedWishLbl;
	@FXML
	private Label youNeedPrimoLbl;
	@FXML
	private Button calculateBtn;
	private int tf1Val;
	private int tf2Val;
	
	Vector<Integer> wish_goal_vector = new Vector<>();
	Vector<Integer> wish_test2 = new Vector<>();
	
	public int currentValue = 0;
	public int input = 0;
	public int character_input = 0;
	public int intertwined_input = 0;
	public int wishes_for_character = 4;
	public int guaranteed_wish = 90;
	public int wish_goal = 0;
	public Boolean fiftyfifty = null;
	public int final_wish_goal = 0;
	public int primo_amount_1 = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7);
		
		valueFactory.setValue(1);
		spinner1.setValueFactory(valueFactory);
		
	}
	
	public void calculate(ActionEvent e) {
		input = Integer.parseInt(tf1.getText());
		intertwined_input = Integer.parseInt(tf2.getText());
		if (cb1.isSelected()) {
			fiftyfifty = true;
		} else if (!cb1.isSelected()) {
			fiftyfifty = false;
		}
		System.out.println(cb1.isSelected());
		wishes_for_character = (Integer) spinner1.getValue();
		
//		System.out.println(input);
//		System.out.println(intertwined_input);
//		System.out.println(fiftyfifty);
//		System.out.println(wishes_for_character);
		
			do {
				if (fiftyfifty == true) {
					wish_goal = 90 * 2;
					fiftyfifty = false;
					wishes_for_character--;
				} else if (fiftyfifty == false) {
					wish_goal = 90;
					fiftyfifty = true;
					wishes_for_character--;
				}
				wish_goal_vector.add(wish_goal);
				
			} while (wishes_for_character != 0);
				
			wishes_for_character = (Integer)spinner1.getValue();
			
			final_wish_goal = 0;
			
			primo_amount_1 = (input/160) + intertwined_input;
			
			for (int i = 0; i < wishes_for_character; i++) {
				final_wish_goal += wish_goal_vector.get(i); //masalahnya di rumus ini
				System.out.println(wish_goal_vector.get(i));
				//hasil = 360
				//hasil2 = 720
				
			}
			System.out.println("==================");
		
		String primo_amount_string = String.valueOf(primo_amount_1);
		String needWish = String.valueOf(final_wish_goal - primo_amount_1);
		String needPrimo = String.valueOf((final_wish_goal - primo_amount_1)*160);
		
//		primo_amount_string.getClass().getName();
//		
//		System.out.println(primo_amount_string.getClass().getName());
//		System.out.println(needWish.getClass().getName());
//		System.out.println(needPrimo.getClass().getName());
		
		youHaveLbl.setText("You have : " + primo_amount_string + " wishes");
		youNeedWishLbl.setText("You will need : "+(needWish) +" more wishes to get Character (Maximum)");
		youNeedPrimoLbl.setText("Which means you will need : "+(needPrimo)+" primogems more to get the character (Maximum)");
		
//		spinner1.setValueFactory(null);
//		tf1.setText("");
//		tf2.setText("");
//		cb1.setSelected(false);
//		fiftyfifty = false;
		wish_goal_vector.clear();
		
	}
	
	


	
	
}
