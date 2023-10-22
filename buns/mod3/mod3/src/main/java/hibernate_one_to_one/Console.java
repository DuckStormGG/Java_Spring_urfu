package hibernate_one_to_one;


import java.util.List;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Выберете действие:" +
                "\n1.Добавить работника " +
                "\n2.Вывод работника" +
                "\n3.Вывод деталей работника " +
                "\n4.Удалить работника");

        int answer = in.nextInt();

        switch (answer)
        {
            case 1:{
                System.out.println("Введите данные работника через \",\" без пробелов:\n" +
                        "(Имя,Фамилия,Департамент,Зарплата,Город,Телефон,E-mail)");
                List<String> data = List.of(in.next().split(","));
                ConsoleMain.createEmploy(data.get(0)
                        , data.get(1)
                        , data.get(2)
                        , Integer.parseInt(data.get(3))
                        , data.get(4)
                        , data.get(5)
                        , data.get(6));
            }
            break;
            case 2:{
                System.out.println("Введите Id работника");
                int id = in.nextInt();
                ConsoleMain.showEmploy(id);
            }
            break;
            case 3:{
                System.out.println("Введите Id детали о работнике");
                int id = in.nextInt();
                ConsoleMain.showDetail(id);
            }
            break;
            case 4:{
                System.out.println("Введите Id работника");
                int id = in.nextInt();
                ConsoleMain.deleteEmploy(id);
            }
            break;

        }

    }
}
