
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bui Dat
 */
public class ManageEastAsiaCountries {

    public void menu() {
        System.out.println("");
        System.out.println("\t\t\t\tMENU\t\t\t\t");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {
        ArrayList<EastAsiaCountries> list = new ArrayList<>();
        ManageEastAsiaCountries meac = new ManageEastAsiaCountries();
        Scanner sc = new Scanner(System.in);
        InputCheck ic = new InputCheck();
        String code = "";
        while (true) {
            meac.menu();
            int choice = ic.getChoice();
            switch (choice) {
                case 1:
                    code = ic.getCode(list);
                    String name = ic.getName(list);
                    float area = ic.getArea(list);
                    String terrian = ic.getTerrian(list);
                    ic.add(list, code, name, area, terrian);
                    break;
                case 2:
                    if (!code.isEmpty()) {
                        ic.displayCountryJustInput(list, code);
                    } else {
                        System.err.println("Please input information fisrt");
                    }
                    break;
                case 3:
                    String nameSearch = ic.getName(list);
                    boolean check = false;
                    for (EastAsiaCountries o : list) {
                        if (o.getCountryName().equals(nameSearch)) {
                            o.display();
                            check = true;
                        }
                    }
                    if (check == false) {
                        System.out.println("Not Found");
                    }
                    break;
                case 4:
                    ic.sortByName(list);
                    for (EastAsiaCountries o : list) {
                        o.display();
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    
}
