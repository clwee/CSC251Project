import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            File file = new File("PolicyInformation.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                int policyNumber = Integer.parseInt(scanner.nextLine().trim());
                String providerName = scanner.nextLine().trim();
                String firstName = scanner.nextLine().trim();
                String lastName = scanner.nextLine().trim();
                int age = Integer.parseInt(scanner.nextLine().trim());
                String smokingStatus = scanner.nextLine().trim();
                double height = Double.parseDouble(scanner.nextLine().trim());
                double weight = Double.parseDouble(scanner.nextLine().trim());
                
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);
                
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        }

        for (Policy policy : policies) {
            System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder’s First Name: " + policy.getFirstName());
            System.out.println("Policyholder’s Last Name: " + policy.getLastName());
            System.out.println("Policyholder’s Age: " + policy.getAge());
            System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder’s Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder’s Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder’s BMI: %.2f%n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());
        }
        
        System.out.println("\nThe number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
