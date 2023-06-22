import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Lottery {
    private List<Toy> listToys = new ArrayList<>();
    private int toy_count;

    public List<Toy> getToys() {
        return listToys;
    }

    public int getToy_count() {
        System.out.println("Количество игрушек = " + toy_count);
        return toy_count;
    }

    public List<Toy> add_toy_in_listToy(Toy name) {
        listToys.add(name);
        toy_count++;
        return listToys;
    }

    private void saveInFile() {
        try (FileWriter writer = new FileWriter("result.txt", true)) {
            Random rnd = new Random();
            int num = rnd.nextInt(3);
            String text = listToys.get(num).getName();
            writer.write(text + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("ERROR");
        }
    }

    public void readFile() {
        try {
            FileReader fr = new FileReader("result.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (Exception ex) {
            System.out.println("ERROR");
        }
    }

    public void lottteryToy() {
        Scanner scanner = new Scanner(System.in);
        int chance = 50;
        System.out.println("Шанс на победу - 50% ");
        System.out.println("Нажмите 1, чтобы изменить шанс на победу ");
        System.out.println("Нажмите 2, чтобы оставить шанс и продолжить ");
        String changeСhance = scanner.next();
        if (changeСhance.equals("1")) {
            System.out.println("Введите шанс на победу от 1 до 100% ");
            chance = scanner.nextInt();
        }
        if (chance >= 0 && chance <= 100) {
            Random rnd = new Random();
            int num = rnd.nextInt(100);
            if (num > chance) {
                System.out.println("Вы проиграли");
            } else if (num < chance) {
                System.out.println("Вы выиграли");
                saveInFile();
                add_toy_in_listToy(listToys.get(0));
            }
        } else {
            System.out.println("Неверное значение ");
        }
    }
}
