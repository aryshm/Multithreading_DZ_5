public class Main {

    public static void main(String[] args) {
        CreditCalculator creditCalculator = new CreditCalculator();
        int creditAmount = 1_500_000, creditDuration = 60;
        double rate = 9.9;
        System.out.println(creditCalculator.monthlyPaymentCalculation(creditAmount, creditDuration, rate));
        System.out.println(creditCalculator.totalRefund(creditAmount, creditDuration, rate));
        System.out.println(creditCalculator.overpaymentCalculation(creditAmount, creditDuration, rate));
    }
}
