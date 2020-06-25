
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
 * @author Bui Dat
 */
public class InputCheck {
    
    Scanner sc = new Scanner(System.in);
    
    public void add(ArrayList<EastAsiaCountries> list, String code, String name, float area, String terrian) {
        EastAsiaCountries e = new EastAsiaCountries(terrian, code, name, area);
        list.add(e);
    }
    
    public void displayCountryJustInput(ArrayList<EastAsiaCountries> list, String code) {
        for (EastAsiaCountries o : list) {
            if (o.getCountryCode().equalsIgnoreCase(code)) {
                o.display();
            }
        }
    }
    
    public void search(ArrayList<EastAsiaCountries> list, String name) {
        boolean check = false;
        for (EastAsiaCountries o : list) {
            if (o.getCountryName().equalsIgnoreCase(name)) {
                o.display();
                check = true;
            }
            
        }
        if (check == false) {
            System.out.println("Not Found");
        }
    }
    
    public void sortByName(ArrayList<EastAsiaCountries> list) {
        Collections.sort(list, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });
    }
    
    public int getChoice() {
        while (true) {
            System.out.print("Selection of users: ");
            String input = sc.nextLine();
            Pattern p = Pattern.compile("^[1-5]$");
            if (p.matcher(input).find()) {
                int choice = Integer.parseInt(input);
                return choice;
            } else {
                System.out.print("invalid choice, pls re-enter");
            }
        }
    }
    
    public String getCode(ArrayList<EastAsiaCountries> list) {
        
        while (true) {
            boolean check = true;
            System.out.print("Enter code of country: ");
            String code = sc.nextLine().trim();
            for (EastAsiaCountries o : list) {
                if (o.getCountryCode().equalsIgnoreCase(code)) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                return code;
            } else {
                System.err.println("Duplicate code, please input again");
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
