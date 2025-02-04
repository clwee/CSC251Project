import java.io.*;
import java.util.*;

class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    public double calculatePolicyPrice() {
        double price = 600;
        if (age > 50) {
            price += 75;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }
}

public class Demo {
    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try (Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"))) {
            while (fileScanner.hasNext()) {
                int policyNumber = Integer.parseInt(fileScanner.nextLine().trim());
                String providerName = fileScanner.nextLine().trim();
                String firstName = fileScanner.nextLine().trim();
                String lastName = fileScanner.nextLine().trim();
                int age = Integer.parseInt(fileScanner.nextLine().trim());
                String smokingStatus = fileScanner.nextLine().trim().toLowerCase();
                double height = Double.parseDouble(fileScanner.nextLine().trim());
                double weight = Double.parseDouble(fileScanner.nextLine().trim());

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);

                if (smokingStatus.equals("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt not found.");
            return;
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        for (Policy policy : policies) {
            System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());
        }

        System.out.println("\nThe number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
