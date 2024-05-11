package application;

import java.util.Scanner;
import java.util.Vector;

public class Data {

	
	Controller controller = new Controller();
	Scanner scan = new Scanner(System.in);
	Vector<Integer> wish_goal_vector = new Vector<>();
	Vector<Integer> wish_test2 = new Vector<>();
	
	public int input = 0;
	public int rate_input = 0;
	public int character_input = 0;
	public int intertwined_input = 0;
	public int wishes_for_character = 4;
	public int guaranteed_wish = 90;
	public int wish_goal = 0;
	public boolean fiftyfifty = true;
	public int final_wish_goal;
	public int primo_amount_1;
	
		{
		do {
			if (fiftyfifty == true) {
				wish_goal = (guaranteed_wish * 2);
				fiftyfifty = false;
				wishes_for_character--;
			} else if (fiftyfifty == false) {
				wish_goal = guaranteed_wish;
				fiftyfifty = true;
				wishes_for_character--;
			}
			
			wish_goal_vector.add(wish_goal);
			
		} while (wishes_for_character != 0);
			
		wishes_for_character = character_input;
		
		final_wish_goal = 0;
		
		primo_amount_1 = (input/160) + intertwined_input;
		
		for (int i = 0; i < wishes_for_character; i++) {
			final_wish_goal += wish_goal_vector.get(i); //masalahnya di rumus ini
			System.out.println(wish_goal_vector.get(i));
			//hasil = 360
			//hasil2 = 720
			
		}
		
	}
}
