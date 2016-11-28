package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyClass {
    static int[] arr = {23,43,54,67,43,65,34,55,65};

    public static void main(String[] args) {
        //��ȡ
        MyClass my = new MyClass();
        String str = my.readText("e://123.txt");

        System.out.println("��ȡ�����ǣ�"+str);
        //д��
        writerText(str,"d://www.txt");
        //���ֲ���
        int i = search(arr,55);

        System.out.println("���ֲ��ҷ���"+i);
        //�ݹ���׳�
        int sum = factorial(5);

        System.out.println("�׳ˣ�"+sum);
        //ס��������
        double n = sum(20000);

        System.out.println("ס��������"+(n/2));
    }

    /*�ļ���ȡ*/
    public String readText(String path){
        File file = new File(path);
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));

            String str=null;
            StringBuffer sb = new StringBuffer();

            while((str = br.readLine())!=null){
                sb.append(str);
            }

            br.close();

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*�ļ�д��*/
    public static void writerText(String content,String path){
        File file = new File(path);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write(content);

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*���ֲ���*/
    public static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (key < arr[middle]) {
                end = middle - 1;
            } else if (key > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /*�ݹ�*/
    public static int factorial(int n){
        if (n < 0){
            return 0;
        }
        else if ( n == 1){
            return 1;
        }
        else if (n > 1){

            return n * factorial(n-1);
        }
        return n;
    }

    /*ס��������*/
    public static double sum(int num){
        return num*0.12*2;
    }

}
