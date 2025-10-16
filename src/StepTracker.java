import java.util.Scanner;

public class StepTracker {
    Converter converter = new Converter();
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10_000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неправильный номер месяца");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Неправильный номер дня");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Шаги должны быть положительными");
            return;
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Текущая цель: " + goalByStepsPerDay);
        System.out.println("Введите цель шагов на день");
        int stepsGoal = scanner.nextInt();
        if (stepsGoal < 0) {
            System.out.println("цель шагов на день должна быть положительная");
            return;
        }
        goalByStepsPerDay = stepsGoal;
        System.out.println("Текущая цель изменена на " + stepsGoal + " шагов");

    }

    void printStatistic() {
        System.out.println("Введите число месяца");

        int month = scanner.nextInt();

        MonthData monthData = monthToData[month - 1];
        monthData.printDaysAndStepsFromMonth();

        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов за месяц: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов за месяц: " + sumSteps / monthData.days.length);
        System.out.println("Пройденная дистанция за месяц в км: " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия за месяц: " + monthData.bestSeries(goalByStepsPerDay));
    }
}
