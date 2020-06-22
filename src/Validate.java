
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    //method get amount for expense
    public void add(ArrayList<EastAsiaCountries> list, String code, String name,
            float area, String terrain) {
        EastAsiaCountries e = new EastAsiaCountries(terrain, code, name, area);
        list.add(e);
    }

    public void display(ArrayList<EastAsiaCountries> list, String code) {
        for (EastAsiaCountries o : list) {
            if (o.getCountryCode().equalsIgnoreCase(code)) {
                o.display();
            }
        }
    }

    public void sort(ArrayList<EastAsiaCountries> list) {
        Collections.sort(list, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });
        for (EastAsiaCountries o : list) {
            o.display();
        }
    }

    public void search(ArrayList<EastAsiaCountries> list, String name) {
        boolean check = true;
        for (EastAsiaCountries o : list) {
            if (o.getCountryName().equalsIgnoreCase(name)) {
                o.display();
                check = false;
            }
        }
        if (check) {
            System.out.println("not found");
        }
    }

    public int getChoice() {
        int choice = 0;
        while (true) {
            try {
                System.out.print("input choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 5) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("invalid choice, please input again");
            }
        }
        return choice;
    }

    public String getCode(ArrayList<EastAsiaCountries> list) {
        while (true) {
            boolean check = true;
            System.out.print("input code: ");
            String code = sc.nextLine();
            for (EastAsiaCountries o : list) {
                if (o.getCountryCode().equalsIgnoreCase(code)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return code;
            } else {
                System.err.println("dublicate code, please input again");
            }
        }
    }

    public String getName(ArrayList<EastAsiaCountries> list) {
        String name = "";
        while (true) {
            System.out.print("Enter name of country: ");
            name = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z]+$");
            if (p.matcher(name).find()) {
                break;
            } else {
                System.err.println("invalid name, please input name again");
            }
        }
        return name;
    }

    public float getArea(ArrayList<EastAsiaCountries> list) {
        String area = "";
        while (true) {
            System.out.print("Enter total Area: ");
            area = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]+(.[0-9]+)?$");
            if (p.matcher(area).find()) {
                break;
            } else {
                System.err.println("Invalid area, please input again");
            }
        }
        return Float.parseFloat(area);
    }

    public String getTerrian(ArrayList<EastAsiaCountries> list) {
        String terrian = "";
        while (true) {
            System.out.print("Enter terrain of country: ");
            terrian = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z]+$");
            if (p.matcher(terrian).find()) {
                break;
            } else {
                System.err.println("Invalid terrian, please input again");
            }
        }
        return terrian;
    }
}
