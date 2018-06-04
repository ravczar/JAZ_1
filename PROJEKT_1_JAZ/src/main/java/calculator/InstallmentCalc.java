package calculator;

import java.util.ArrayList;
import java.util.List;

import enums.KindOfInstallment;

public class InstallmentCalc {

    public List<InstallmentsOftheBankCredit> calculate(DataToCoutnInstallments dataToCoutnInstallments) {
        
    	if (dataToCoutnInstallments.getKindOfInstallment() == KindOfInstallment.STALA) {
            return coutnFixedInstallmentValue(dataToCoutnInstallments);
        }
        return coutnDecreasingInstallmentValue(dataToCoutnInstallments);
    }

    private List<InstallmentsOftheBankCredit> coutnDecreasingInstallmentValue(DataToCoutnInstallments dataToCoutnInstallments) {
        
    	double previousCapitalAmount = 0;
    	List<InstallmentsOftheBankCredit> creditInstallmentsList = new ArrayList<>();
        
    	

        for (int i = 1; i <= dataToCoutnInstallments.getInstallmentCount(); i++) {
            
        	double amountOfCapital = dataToCoutnInstallments.getCreditTotalAmount() / dataToCoutnInstallments.getInstallmentCount();
            double amountOfInterests = (dataToCoutnInstallments.getCreditTotalAmount() - previousCapitalAmount) * ((dataToCoutnInstallments.getInterestRate() / 100) / (dataToCoutnInstallments.getInstallmentCount() / 12));

            previousCapitalAmount = previousCapitalAmount + amountOfCapital;

            InstallmentsOftheBankCredit installmentsOftheBankCredit = new InstallmentsOftheBankCredit(i, amountOfCapital, amountOfInterests,
                    dataToCoutnInstallments.getFixedLoanFee());

            creditInstallmentsList.add(installmentsOftheBankCredit);
        }
        return creditInstallmentsList;
    }

    private List<InstallmentsOftheBankCredit> coutnFixedInstallmentValue(DataToCoutnInstallments dataToCoutnInstallments) {
        
    	List<InstallmentsOftheBankCredit> creditInstallmentsList = new ArrayList<>();

           for (int i = 1; i <= dataToCoutnInstallments.getInstallmentCount(); i++) {
            
        	double amountOfCapital = dataToCoutnInstallments.getCreditTotalAmount() / dataToCoutnInstallments.getInstallmentCount();
            double amountOfInterests = amountOfCapital * (dataToCoutnInstallments.getInterestRate() / 100);

            InstallmentsOftheBankCredit installmentsOftheBankCredit = new InstallmentsOftheBankCredit(i, amountOfCapital, amountOfInterests,
                    dataToCoutnInstallments.getFixedLoanFee());
            
            creditInstallmentsList.add(installmentsOftheBankCredit);
        }
        return creditInstallmentsList;
    }
}
