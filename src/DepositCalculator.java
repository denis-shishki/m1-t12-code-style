import java.util.Scanner;


public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().inputOutputResult();
    }
    double getComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundUp(pay, 2);
    }

    double getSimplePercent(double amount, double yearRate, int depositPeriod) {
        double value = amount + amount * yearRate * depositPeriod;
        return roundUp(value, 2);
    }

    double roundUp(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void inputOutputResult() {
        int period;
        int action;
        int amount;
        double outAmount = 0.0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            outAmount = getSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outAmount = getComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outAmount);
    }
}

