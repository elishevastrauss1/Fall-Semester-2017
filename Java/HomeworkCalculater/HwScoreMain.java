package december9;

public class HwScoreMain {

	public static void main(String[] args) {
		HwScore hw1=new HwScore(26.5, 30);
		HwScore hw2=new HwScore(29, 27.5);
		HwScore hw3=new HwScore(0,20);
		//HwScore hw4=new HwScore(16,20); //causes yellow box so commented out for now
		
		hw1.printGrade();
		hw2.printGrade();
		hw3.printGrade();
		HwScore.printOverallGrade();
		
	}

}
