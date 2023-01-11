/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task2and3;
import java.util.*;

/**
 *
 * @author lolbo
 */
public class Queue {
    int qitems[] = new int[8];
    int front = 0, end = 0;

    void addqueue() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Queue Item :");
        qitems[end] = input.nextInt();
        end++;
    }

    void takequeue() {
        if (end > front) {
            System.out.println("Item taken :" + qitems[front]);
            front++;
        } else {
            System.out.println("Empty queue");
        }
    }
}
