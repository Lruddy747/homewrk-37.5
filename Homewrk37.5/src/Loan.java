public class Loan {
    private final double loanAmount;

    private final double annualInterestRate;
    private final int numberOfYears;

    public Loan(double loanAmount, double annualInterestRate, int numberOfYears) {

        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;

    }

    public double getMonthlyPayment() {

        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int numberOfMonths = numberOfYears * 12;
        return (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));

    }

    public double getTotalPayment() {

        return getMonthlyPayment() * numberOfYears * 12;

    }
}