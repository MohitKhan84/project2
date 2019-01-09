package Eliza;

//import java.util.Random;

public class QuestionBank {
	
	String [] questions;
	int currQuestionIndex;
	
	public QuestionBank(){
		questions = new String [10]; 
		questions[0]= "Question # 1: Which three words describe you best?";
		questions[1]= "Question # 2: Which is your best feature?";
		questions[2]= "Question # 3: Which common saying or phrase describes you?";
		questions[3]= "Question # 4: What’s the best thing that’s happened to you this week?";
		questions[4]= "Question # 5: Who was your role model when you were a child?";
		questions[5]= "Question # 6: Who was your favorite teacher and why?";
		questions[6]= "Question # 7: What was your favorite subject at school?";
		questions[7]= "Question # 8: What did you want to be when you grew up?";
		questions[8]= "Question # 9: If you could have one wish come true what would it be?";
		questions[9]= "Question # 10: Which would you prefer — three wishes over five years or one wish right now?";
		

		currQuestionIndex = 0;
	}
	
	public String getNextQuestion() {
	
		if (currQuestionIndex+1 < 10)
			currQuestionIndex = 0;
			return "";
			
//do stuff in here to get the next question.. Randomly from the array...
//		Random ran = new Random();
//		int ranNum= (int)(Math.random()*10);
//		System.out.println(ranNum);
//		return questions[ranNum];
		
	}


}
