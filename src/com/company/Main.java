package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        try {
            Input input = new Input();
            input.inputStr();
            input.spaceDel(Input.str);

            input.splitStr();

            Calculate calculate = new Calculate();
            RomArabConv romArabConv = new RomArabConv();

            if ((input.checkAll(Input.firstNum, Input.secondNum)==true)&&(input.checkStringRom(Input.firstNum)==true)&&(input.checkStringRom(Input.secondNum)==true)){
                Input.result=calculate.arabNum(romArabConv.romToArab(Input.firstNum), romArabConv.romToArab(Input.secondNum), Input.operationStr);
                System.out.println("Результат:" + romArabConv.arabRomConv(Integer.toString(Input.result)));

            }

            if ((input.checkAll(Input.firstNum, Input.secondNum)==true)&&(input.checkString(Input.firstNum)==true)&&(input.checkString(Input.secondNum)==true))
                System.out.println("результат: " + calculate.arabNum(Integer.parseInt(Input.firstNum), Integer.parseInt(Input.secondNum), Input.operationStr));
            else System.exit(0);
        }
        catch (RuntimeException e){
            throw new IllegalArgumentException("Некорректный пример данных. Например 1+1 или II*V ");

        }


    }
}
//Данный класс разбивает введенную строку на 3 составляющие: первая переменная, оператор и вторая переменная.
// Все три составляющие строки присваиваются к 3 разным переменным: firstNum, operationStr, secondNum.
class Input {
    static String str;
    static String firstNum="";
    static String secondNum="";
    static char operationStr='0';
    static int result;


    // Ввод символов с клавиатуры с присваиванием статистисеской переменной str;
    void inputStr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример:");
        str = scanner.nextLine();

    }

    //Удаляем пробелы из строки str;
    String spaceDel(String str) {
        String strTemp = "";
        strTemp = str.replaceAll(" ", "");
        return this.str = strTemp;
    }

    //Разделяем строку на 3 составные: первое число, операция, второе число и приваиваем к статистическим переменным;
    void splitStr() {

        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == '+') || (str.charAt(i) == '-')|| (str.charAt(i) == '*')|| (str.charAt(i) == '/')) {
                break;
            }
            else firstNum = firstNum + str.charAt(i);
            }
        operationStr=str.charAt(firstNum.length());
        secondNum=str.substring(firstNum.length()+1);

    }
    // Метод проверят содержит ли строка только цифры. true если в строке только арабские цифры
    boolean checkString(String string) {
        if ((string.matches("1"))||(string.matches("2"))||(string.matches("3"))||
                (string.matches("4"))||(string.matches("5"))||(string.matches("6"))||
                (string.matches("7"))||(string.matches("8"))||(string.matches("9"))||(string.matches("10")))
            return true;
        else return false;
    }
    // Метод проверят содержит ли строка только римские цифры. true если в строке только римские цифры
    boolean checkStringRom(String string){
        if ((string.matches("I"))||(string.matches("II"))||(string.matches("III"))||
                (string.matches("IV"))||(string.matches("V"))||(string.matches("VI"))||
                (string.matches("VII"))||(string.matches("VIII"))||(string.matches("IX"))||(string.matches("X")))
        return true;
        else return false;
    }

    boolean checkAll(String a, String b){
        if ((checkString(a)&&checkString(b)==true)||(checkStringRom(a)&&checkStringRom(b)==true))
            return true;
        else return false;
    };




}
class Calculate {
    int arabNum(int firstNum, int secondNum, char operator){
        double result = 0;
        switch (operator){
            case('+'): result= firstNum+secondNum;
                break;
            case('-'): result= firstNum-secondNum;
                break;
            case('*'): result= firstNum*secondNum;
                break;
            case('/'): result= firstNum/secondNum;
                break;

        }
        return (int)result;
    }
}
class RomArabConv {
    int romToArab(String rom) {
        int arab = 0;
        switch (rom) {
            case ("I"):
                arab = 1;
                break;
            case ("II"):
                arab = 2;
                break;
            case ("III"):
                arab = 3;
                break;
            case ("IV"):
                arab = 4;
                break;
            case ("V"):
                arab = 5;
                break;
            case ("VI"):
                arab = 6;
                break;
            case ("VII"):
                arab = 7;
                break;
            case ("VIII"):
                arab = 8;
                break;
            case ("IX"):
                arab = 9;
                break;
            case ("X"):
                arab = 10;
                break;

        }
        return arab;
    }

    String arabRomFirst(String arab) {
        String romFirst="";
        switch (arab) {
            case ("1"):
                romFirst = "I";
                break;
            case ("2"):
                romFirst = "II";
                break;
            case ("3"):
                romFirst = "III";
                break;
            case ("4"):
                romFirst = "IV";
                break;
            case ("5"):
                romFirst = "V";
                break;
            case ("6"):
                romFirst = "VI";
                break;
            case ("7"):
                romFirst = "VII";
                break;
            case ("VIII"):
                romFirst = "VIII";
                break;
            case ("9"):
                romFirst = "IX";
                break;
            case ("10"):
                romFirst = "X";
                break;
        }
        return romFirst;
    }
    String arabRomSecond(String arab) {
        String romSecond="";
        switch (arab) {
            case ("1"):
                romSecond = "X";
                break;
            case ("2"):
                romSecond = "XX";
                break;
            case ("3"):
                romSecond = "XXX";
                break;
            case ("4"):
                romSecond = "XL";
                break;
            case ("5"):
                romSecond = "L";
                break;
            case ("6"):
                romSecond = "LX";
                break;
            case ("7"):
                romSecond = "LXX";
                break;
            case ("VIII"):
                romSecond = "LXXX";
                break;
            case ("9"):
                romSecond = "XC";
                break;
        }
        return romSecond;
    }
    String arabRomConv(String arab) {
        String romFull="";
        String romFirst="";
        String romSecond="";

        if (arab.length()==3){
            return romFull= "C";}

        if (arab.length()==1){
            romFull=arabRomFirst(arab);

        }
        if (arab.length()==2){
                String arab1, arab2;

            arab1=Character.toString(arab.charAt(1));
            arab2=Character.toString(arab.charAt(0));

                romFirst=arabRomFirst(arab1);
                romSecond=arabRomSecond(arab2);
                romFull=romSecond+romFirst;

            }
            return romFull;
    }


}








