import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }

        }
    }

    static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Ввести количество шагов за определённый день");
        System.out.println("2 — Изменить цель по количеству шагов в день");
        System.out.println("3 — Напечатать статистику за определённый месяц");
        System.out.println("4 — Выйти из приложения");
    }
}
