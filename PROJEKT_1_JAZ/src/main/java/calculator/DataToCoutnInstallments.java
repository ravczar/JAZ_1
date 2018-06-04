package calculator;

import enums.KindOfInstallment;

public class DataToCoutnInstallments {

    private final double creditTotalAmount;
    private final int installmentCount;
    private final double interestRate;
    private final double fixedLoanFee;
    private final KindOfInstallment kindOfInstallment;

    public DataToCoutnInstallments(double creditTotalAmount, int installmentCount, double interestRate, double fixedLoanFee, KindOfInstallment kindOfInstallment) {
        this.creditTotalAmount = creditTotalAmount;
        this.installmentCount = installmentCount;
        this.interestRate = interestRate;
        this.fixedLoanFee = fixedLoanFee;
        this.kindOfInstallment = kindOfInstallment;
    }

    public double getCreditTotalAmount() {
        return creditTotalAmount;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getFixedLoanFee() {
        return fixedLoanFee;
    }

    public KindOfInstallment getKindOfInstallment() {
        return kindOfInstallment;
    }
}
