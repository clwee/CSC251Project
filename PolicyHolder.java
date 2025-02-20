public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private boolean smoker;
    private double height; 
    private double weight; 

    public PolicyHolder(String firstName, String lastName, int age, boolean smoker, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smoker = smoker;
        this.height = height;
        this.weight = weight;
    }

    public PolicyHolder(PolicyHolder holder) {
        this.firstName = holder.firstName;
        this.lastName = holder.lastName;
        this.age = holder.age;
        this.smoker = holder.smoker;
        this.height = holder.height;
        this.weight = holder.weight;
    }

    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public boolean isSmoker() { return smoker; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return String.format(
            "Policyholder's First Name: %s\nPolicyholder's Last Name: %s\nPolicyholder's Age: %d\nPolicyholder's Smoking Status (Y/N): %s\nPolicyholder's Height: %.1f inches\nPolicyholder's Weight: %.1f pounds\nPolicyholder's BMI: %.2f",
            firstName, lastName, age, (smoker ? "smoker" : "non-smoker"), height, weight, calculateBMI()
        );
    }
}
