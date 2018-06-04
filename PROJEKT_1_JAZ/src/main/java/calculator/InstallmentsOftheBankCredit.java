package calculator;

public class InstallmentsOftheBankCredit {

    private final int numberOfInstallment;
    private final double amountOfCapital;
    private final double amountOfInterest;
    private final double fixedFeeAmount;
    private final double totalAmountOfInstallment;

    public InstallmentsOftheBankCredit(int numberOfInstallment, double amountOfCapital, double amountOfInterest, double fixedFeeAmount) {
        this.numberOfInstallment = numberOfInstallment;
        this.amountOfCapital = amountOfCapital;
        this.amountOfInterest = amountOfInterest;
        this.fixedFeeAmount = fixedFeeAmount;
        this.totalAmountOfInstallment = amountOfCapital + amountOfInterest + fixedFeeAmount;
    }

    public int getNumberOfInstallment() {
        return numberOfInstallment;
    }

    public double getAmountOfCapital() {
        return amountOfCapital;
    }

    public double getAmountOfInterest() {
        return amountOfInterest;
    }

    public double getFixedFeeAmount() {
        return fixedFeeAmount;
    }

    public double getTotalAmountOfInstallment() {
        return totalAmountOfInstallment;
    }
}
