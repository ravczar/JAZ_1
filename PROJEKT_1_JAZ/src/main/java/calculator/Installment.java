package calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import calculator.InstallmentsOftheBankCredit;

public class Installment {
    private static final NumberFormat formatter = new DecimalFormat("#0.00");

    private final String numberOfInstallment;
    private final String amountOfCapital;
    private final String amountOfInterest;
    private final String fixedFeeAmount;
    private final String totalAmountOfInstallment;

    public Installment(InstallmentsOftheBankCredit installmentsOftheBankCredit) {
        numberOfInstallment = String.valueOf(installmentsOftheBankCredit.getNumberOfInstallment());
        amountOfCapital = formatter.format(installmentsOftheBankCredit.getAmountOfCapital());
        amountOfInterest = formatter.format(installmentsOftheBankCredit.getAmountOfInterest());
        fixedFeeAmount = formatter.format(installmentsOftheBankCredit.getFixedFeeAmount());
        totalAmountOfInstallment = formatter.format(installmentsOftheBankCredit.getTotalAmountOfInstallment());
    }

    public String getNumberOfInstallment() {
        return numberOfInstallment;
    }

    public String getAmountOfCapital() {
        return amountOfCapital;
    }

    public String getAmountOfInterest() {
        return amountOfInterest;
    }

    public String getFixedFeeAmount() {
        return fixedFeeAmount;
    }

    public String getTotalAmountOfInstallment() {
        return totalAmountOfInstallment;
    }
}
