import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*; // to read the file and for the IOExceptions

public class PolicyDemo {
  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // declare variables
    int policyNumber, policyCount;
    String providerName;
    String firstName;
    String lastName;
    int age;
    String smokingStatus;
    double height;
    double weight;
    int pSmokers = 0;
    int pNonSmokers = 0;
    boolean filecontinues = true;

    // Open the file for reading.
    File excerciseFile = new File("PolicyInformation.txt");
    Scanner inputFile = new Scanner(excerciseFile);

    while (filecontinues == true) {
      if (inputFile.hasNext() == true) {
        // prompt the user to enter information about the Policy
        // System.out.print("Please enter the Policy Number: ");
        String a = inputFile.nextLine();

        // System.out.print("Please enter the Provider Name: ");
        String b = inputFile.nextLine();

        // System.out.print("Please enter the Policyholder's First Name: ");
        String c = inputFile.nextLine();

        // System.out.print("Please enter the Policyholder's Last Name: ");
        String d = inputFile.nextLine();

        // System.out.print("Please enter the Policyholder's Age: ");
        String e = inputFile.nextLine();

        // System.out.print("Please enter the Policyholder's Smoking Status
        // (smoker/non-smoker): ");
        String f = inputFile.nextLine();

        // System.out.print("Please enter the Policyholder's Height (in inches): ");
        String g = inputFile.nextLine();

        // System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        String h = inputFile.nextLine();

        // designates each value to its corresponding reference variable according to
        // its data type
        age = Integer.valueOf(e);
        policyNumber = Integer.valueOf(a);
        providerName = b;
        firstName = c;
        lastName = d;
        smokingStatus = f;
        height = Double.valueOf(g);
        weight = Double.valueOf(h);

        // counts the number of smoker and non-smoker policies
        // the counter does work, but the program runs into an error(which i haven't
        // figured how to fix yet) before it can print it out
        if (smokingStatus.equalsIgnoreCase("smoker"))
          pSmokers += 1;
        else
          pNonSmokers += 1;
        // create a Policy object
        Policy policy = new Policy(age, policyNumber, providerName, firstName, lastName, smokingStatus, height, weight);

        // outputs the information from the current policy's instance
        System.out.println(policy.toString());
        if(inputFile.hasNext())
            inputFile.nextLine();
            
      } else {
        filecontinues = false;
      }
    }
    inputFile.close();
    policyCount = Policy.getInstanceCount();
    System.out.println("There were "+ policyCount + " Policy objects created." + "\n");
    System.out.println("The number of policies with a smoker is: " + pSmokers);
    System.out.println("The number of policies with a non-smoker is: " + pNonSmokers);
  }
}