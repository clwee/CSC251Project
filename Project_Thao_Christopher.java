public class Policy {
    
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; 
    private double weight; 

    public Policy() {
        this.policyNumber = 0;
        this.providerName = "Unknown";
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

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

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

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


import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        int policyNumber = scanner.nextInt();

        System.out.print("Please enter the Provider Name: ");
        scanner.nextLine(); 
        String providerName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int age = scanner.nextInt();

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        scanner.nextLine(); 
        String smokingStatus = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double height = scanner.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double weight = scanner.nextDouble();

        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

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

        scanner.close();
    }
}
