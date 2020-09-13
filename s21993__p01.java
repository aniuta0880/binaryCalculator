package com.company;
import java.util.Scanner;
public class S21993_p01 {
    public static int BinarySubtraction(int FirstDig, int SecondDig)
    {
        while (SecondDig != 0)
        {
            int WhatIsBorrowed = (~FirstDig) & SecondDig;
            FirstDig = FirstDig ^ SecondDig;
            SecondDig = WhatIsBorrowed << 1;
        }
        return FirstDig;
    }
    public static int BinaryMultiplication(int FirstDig, int SecondDig)
    {
        int Result = 0;
        while (SecondDig > 0)
        {
            if ((SecondDig & 1) != 0)
                Result = Result | FirstDig;
            FirstDig = FirstDig << 1;
            SecondDig = SecondDig >> 1;
        }
        return Result;
    }
    public static int BinaryDivision(int FirstDig, int SecondDig)
    {
        int Result = 0;
        int TempVal;
        while (FirstDig >= SecondDig) {
            TempVal = SecondDig;
            int Counter = 1;
            while (TempVal <= FirstDig) {
                TempVal = TempVal << 1;
                Counter = Counter << 1;
            }
            Result = Result | (Counter >> 1);
            TempVal = (TempVal >> 1);
            FirstDig = BinarySubtraction(FirstDig,TempVal);
        }
        return Result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pierwszą wartość: ");
        int FirstDig = scanner.nextInt();
        System.out.println("Podaj drugą wartość: ");
        int LastDig = scanner.nextInt();
        System.out.println("Podaj znak pożądanej operacji: ");
        char Znak = scanner.next().charAt(0);
        if(FirstDig==0 && LastDig==0)
        {
            System.out.println("Error");
            return;
        }
        if(LastDig==0 && Znak==(char)47 ) // sytuacja gdy ktoś próbuje podzielić przez 0
        {
            System.out.println("Error");
            return;
        }
        System.out.println(FirstDig); // wyświetlenie I liczby
        for (int i = 31; i >= 0; i--) //w ten sposób wyświetlam wartości binarne
        {
            int result = FirstDig >> i;
            int Ans = result & 1;
            if (Ans==1) {
                System.out.print("1");
            } else
                System.out.print("0");
        }
        System.out.println();
        System.out.println(LastDig); // wyświetlenie II liczby
        for (int i = 31; i >= 0; i--)
        {
            int result = LastDig >> i;
            int Ans = result & 1;
            if (Ans==1) {
                System.out.print("1");
            } else
                System.out.print("0");
        }
        //+ dodawanie
        if(Znak==(char)43)
        {
            int MyWrt = ( FirstDig | LastDig ); //dodawanie
            System.out.println();
            System.out.println("===============================");
            System.out.println(MyWrt+" ");
            for (int i = 31; i >= 0; i--)
            {
                int result = MyWrt >> i;
                int Ans = result & 1;
                if (Ans==1) {
                    System.out.print("1");
                } else
                    System.out.print("0");
            }
        }
        //- odejmowanie
        if(Znak==(char)45)
        {
            int MyWrt = BinarySubtraction(FirstDig,LastDig); //odejmowanie
            System.out.println();
            System.out.println("===============================");
            System.out.println(MyWrt);
            for (int i = 31; i >= 0; i--)
            {
                int result = MyWrt >> i;
                int Ans = result & 1;
                if (Ans==1) {
                    System.out.print("1");
                } else
                    System.out.print("0");
            }
        }
        //* mnożenie
        if(Znak==(char)42)
        {
            int MyWrt = BinaryMultiplication(FirstDig,LastDig); //mnożenie
            System.out.println();
            System.out.println("================================");
            System.out.println(MyWrt);
            for (int i = 31; i >= 0; i--)
            {
                int Result = MyWrt >> i;
                int Ans = Result & 1;
                if (Ans==1) {
                    System.out.print("1");
                } else
                    System.out.print("0");
            }
        }
        // / dzielenie
        if(Znak==(char)47)
        {
            int MyWrt = BinaryDivision(FirstDig,LastDig); //dzielenie
            System.out.println();
            System.out.println("=================================");
            System.out.println(MyWrt);
            for (int i = 31; i >= 0; i--)
            {
                int Result = MyWrt >> i;
                int Ans = Result & 1;
                if (Ans==1) {
                    System.out.print("1");
                } else
                    System.out.print("0");
            }
        }


    }
}