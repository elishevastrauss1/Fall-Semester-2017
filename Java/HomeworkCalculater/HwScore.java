package december9;

public class HwScore {
	final static double A=0.9;
	final static double B=0.8;
	final static double C=0.7;
	final static double D=0.6;
	
	double earnedPoints;
	double possiblePoints;
	
	static double totalEarnedPoints;
	static double totalPossiblePoints;
	
	public HwScore(double earnedPoints, double possiblePoints) {
		this.earnedPoints = earnedPoints;
		this.possiblePoints = possiblePoints;
		totalEarnedPoints+=earnedPoints;
		totalPossiblePoints+=possiblePoints;
	}
	
	public void printGrade() {
		if (earnedPoints/possiblePoints>=A) {
			System.out.println("On this homework you earned " + earnedPoints + " points out of "+ possiblePoints + " possible points: A");
		}
		else if (earnedPoints/possiblePoints>=B) {
			System.out.println("On this homework you earned " + earnedPoints + " points out of "+ possiblePoints + " possible points: B");
		}
		else if (earnedPoints/possiblePoints>=C) {
			System.out.println("On this homework you earned " + earnedPoints + " points out of "+ possiblePoints + " possible points: C");
		}
		else if (earnedPoints/possiblePoints>=D) {
			System.out.println("On this homework you earned " + earnedPoints + " points out of "+ possiblePoints + " possible points: D");
		} 
		else {
			System.out.println("On this homework you earned " + earnedPoints + " points out of "+ possiblePoints + " possible points: F");
		} 
		
	}
	public static void printOverallGrade() {
		if (totalEarnedPoints/totalPossiblePoints>=A) {
			System.out.println("On all homework, you earned " + totalEarnedPoints +" out of " + totalPossiblePoints + " possible points: A");
		}
		else if (totalEarnedPoints/totalPossiblePoints>=B) {
			System.out.println("On all homework, you earned " + totalEarnedPoints +" out of " + totalPossiblePoints + " possible points: B");
		}
		else if (totalEarnedPoints/totalPossiblePoints>=C) {
			System.out.println("On all homework, you earned " + totalEarnedPoints +" out of " + totalPossiblePoints + " possible points: C");
		}
		else if (totalEarnedPoints/totalPossiblePoints>=D) {
			System.out.println("On all homework, you earned " + totalEarnedPoints +" out of " + totalPossiblePoints + " possible points: D");
		} 
	}
	
	


}
