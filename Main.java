public class Main {
  public static String formGradeString(int[] arr) {
    String output = "";
    for (int currNum : arr) {
      if (currNum >= 90) {
        output += "A";
      } else if (currNum >= 80) {
        output += "B";
      } else if (currNum >= 70) {
        output += "C";
      } else if (currNum >= 60) {
        output += "D";
      } else {
        output += "F";
      }
    }
    return output;
  }
  
  public static String valedictorianName(String[] studentNames, double[] studentGrades) {
    double bestGPA = 0;
    int bestGPAPos = 0;
    for (int index = 0; index < studentGrades.length; index++) {
      if (studentGrades[index] >= bestGPA) {
        bestGPA = studentGrades[index];
        bestGPAPos = index;
      }
    }
    return studentNames[bestGPAPos];
  }

  public static String longestPlateau(int[] nums) {
    // dunno come back later to think
    int count = 0;
    int highestCount = 0;
    int indexOfCount = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        count++;
      } 
      if (nums[i] < nums[i + 1]) {
        count = 0;
      }
      if (count >= highestCount) {
        highestCount = count;
      }
      

    }
    String output = "[" + highestCount + ", " + indexOfCount + "]";
    return output;
  }


  public static double rumors(int n) {
    // need a break
    final int NTRIALS = 1000;
    int rumorsTotal = 0;
    for (int trials = 0; trials < NTRIALS; trials++) {
      int[] people = new int[n - 1];
      int rand =  (int) (Math.random() * people.length);
      people[rand] = 1;
      int rumorHear = 1;

      boolean twoCheck = true;
      while (twoCheck) {
        for (int currNum : people) {
          if (currNum == 2) {
            twoCheck = false;
          }
          int newRand = (int) (Math.random() * people.length);
          people[newRand]++;
          if (currNum == 1) {
            
            rumorHear++;
          }
        }
      }
      rumorsTotal += rumorHear;
    }

    
    return (double) rumorsTotal / NTRIALS;
  }

  public static void main(String[] args) {
    int[] array = new int[]{62, 79, 99, 50};
    System.out.println(formGradeString(array));

    System.out.println("--------------------------------------------------------------------------------");

    String[] studentNames = {"emily", "albert", "sophie", "phillip", "ophelia"};
    double[] studentGrades = {0.223, 3.538, 3.237, 1.437, 1.162};
    System.out.println(valedictorianName(studentNames, studentGrades));

    System.out.println("--------------------------------------------------------------------------------");

    int[] input = {0, 3, 1, 1, 1, 0, 2, 2, 1, 1};
    int[] input2 = {0, 1, 1, 1, 1, 0, 3, 3, 2, 2};
    System.out.println(longestPlateau(input));
    System.out.println(longestPlateau(input2));

    System.out.println("--------------------------------------------------------------------------------");

    System.out.println(rumors(20));
  }
}