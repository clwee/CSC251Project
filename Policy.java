public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; 

    private static int policyCount = 0;

    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(policyHolder); 
        policyCount++;
    }

    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public PolicyHolder getPolicyHolder() { return new PolicyHolder(policyHolder); } // Secure return

    public double calculatePolicyPrice() {
        double basePrice = 600.00;
        if (policyHolder.getAge() > 50) basePrice += 75.00;
        if (policyHolder.isSmoker()) basePrice += 100.00;
        if (policyHolder.calculateBMI() > 35) basePrice += (policyHolder.calculateBMI() - 35) * 20.00;
        return basePrice;
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    @Override
    public String toString() {
        return String.format(
            "Policy Number: %d\nProvider Name: %s\n%s\nPolicy Price: $%.2f\n",
            policyNumber, providerName, policyHolder.toString(), calculatePolicyPrice()
        );
    }
}
