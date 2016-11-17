package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.ArrayList;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] var = new String[3];
        int[] vVar = new int[3];
        for(int i=0;i<3;i++)
        {
            var [i] = reader.readLine();
        }
        for(int i=0;i<3;i++)
        {
            vVar[i] = Integer.parseInt(var[i]);
        }
        int min = 0,max = 0,mid = 0;
        if(vVar[0]<vVar[1] && vVar[0]<vVar[2]){
            min = vVar[0];
        }else  if(vVar[1]<vVar[0] && vVar[1]<vVar[2]){
            min = vVar[1];
        }else  if(vVar[2]<vVar[0] && vVar[2]<vVar[1]){
            min = vVar[2];
        }
        if(vVar[0]>vVar[1] && vVar[0]>vVar[2]){
            max= vVar[0];
        }else  if(vVar[1]>vVar[0] && vVar[1]>vVar[2]){
            max = vVar[1];
        }else  if(vVar[2]>vVar[0] && vVar[2]>vVar[1]){
            max = vVar[2];
        }
        if(vVar[0]>min && vVar[0]<max){
            mid = vVar[0];
        }else if(vVar[1]>min && vVar[1]<max){
            mid = vVar[1];
        }else if(vVar[2]>min && vVar[2]<max)
        {
            mid = vVar[2];
        }
        System.out.print(mid);

    }
}
