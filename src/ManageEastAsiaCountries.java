
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class ManageEastAsiaCountries {

    ArrayList<EastAsiaCountries> list = new ArrayList<>();

    public void menu() {
        System.out.println("1. Enter the information for 11 countries in Southeast Asia");
        System.out.println("2. Display the information of country you've just input.");
        System.out.println("3. Search the country according to the entered country's name.");
        System.out.println("4. Display the information increasing with the country name.");
        System.out.println("5. Exit.");
    }

    public static void main(String[] args) {
        int choice;
        Validate v = new Validate();
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();

//        list.add(new EastAsiaCountries("nice", "VN", "Viet Nam", 100000));
//        list.add(new EastAsiaCountries("nice", "LA", "Lao", 200000));
//        list.add(new EastAsiaCountries("nice", "Thai", "Thai Lan", 300000));
//        list.add(new EastAsiaCountries("nice", "Indo", "Indonesia", 400000));
//        list.add(new EastAsiaCountries("nice", "Cam", "Campuchia", 500000));
        Scanner sc = new Scanner(System.in);
        String code = "";
        while (true) {
            m.menu();
            choice = v.getChoice();
            switch (choice) {
                case 1:
                    code = v.getCode(m.list);
                    String name = v.getName(m.list);
                    float area = v.getArea(m.list);
                    String terrain = v.getTerrian(m.list);
                    v.add(m.list, code, name, area, terrain);
                    break;
                case 2:
                    if (!code.isEmpty()) {
                        v.display(m.list, code);
                    }
                    break;
                case 3:
                    System.out.println("input country name: ");
                    String countryName = sc.nextLine();
                    v.search(m.list, countryName);
                    break;
                case 4:
                    v.sort(m.list);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
