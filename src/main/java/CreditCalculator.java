public class CreditCalculator {

    public int monthlyPaymentCalculation(int creditAmount, int creditDuration, double rate) {
        return (int) (creditAmount * annuityRateCalculation(creditDuration, rate));
    }

    public int totalRefund(int creditAmount, int creditDuration, double rate) {
        return (int) (annuityRateCalculation(creditDuration, rate) * creditDuration * creditAmount);
    }

    public int overpaymentCalculation(int creditAmount, int creditDuration, double rate) {
        return (int) (annuityRateCalculation(creditDuration, rate) * creditDuration * creditAmount - creditAmount);
    }

    public double annuityRateCalculation(int creditDuration, double rate) {
        double monthRate = (rate / 12) / 100;
        double annuityRate = (monthRate * (Math.pow(1 + monthRate, creditDuration))
                / ((Math.pow(1 + monthRate, creditDuration)) - 1));
        return annuityRate;
    }
}
