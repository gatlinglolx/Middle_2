public class Main {
    public static void main(String[] args) {
        Toy constructor = new Toy(1, "Конструктор", 2);
        Toy robot = new Toy(2, "Робот", 2);
        Toy doll = new Toy(3, "Кукла", 6);

        Lottery lottery = new Lottery();
        lottery.add_toy_in_listToy(constructor);
        lottery.add_toy_in_listToy(robot);
        lottery.add_toy_in_listToy(doll);

        lottery.lottteryToy();
        lottery.readFile();
        lottery.getToys();
        lottery.getToy_count();
    }
}
