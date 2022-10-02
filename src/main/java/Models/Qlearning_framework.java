package main.java.Models;

import main.java.Data.Input_Data;
import main.java.Entity.Q_table;

import java.io.IOException;
import java.util.ArrayList;
/*
EPOCHS = 4000
LEARNING_RATE = 0.2
GAMMA = 0.95
EPSILON = 0.1
 */

public class Qlearning_framework {
    private Input_Data inputData;
    private double[][] distance;
    private Q_table wakanda;
    private int epochs = 10000;
    private float epsilon = 0.35f;
    private float gamma = 0.95f;
    private float lr = 0.2f;
    public Qlearning_framework() throws IOException {
        inputData = new Input_Data();
        distance = inputData.Distance();
        wakanda = new Q_table(inputData.getSize());
    }

    public void Q_learning() throws CloneNotSupportedException {
        int n = inputData.getSize();
        Q_table CompQtable = (Q_table) ((Q_table)wakanda).clone();
        for (int ep = 0; ep < epochs; ep ++) {
            System.out.println("Copy" + " " + CompQtable.get_val(0, 1));
            System.out.println("real " + wakanda.get_val(0, 1));
            CompQtable.eps_greedy_update(distance, epsilon, gamma, lr); // upd
            System.out.println("Copy" + " " + CompQtable.get_val(0, 1));
            System.out.println("real " + wakanda.get_val(0, 1));
            double greedy_cost = wakanda.compute_value_of_q_table(distance); //calc
            double greedy_cost_comp = CompQtable.compute_value_of_q_table(distance);
            System.out.println("Copy" + " " + CompQtable.get_val(0, 1));
            System.out.println("real " + wakanda.get_val(0, 1));
            if (greedy_cost_comp < greedy_cost) {
                wakanda = (Q_table) ((Q_table)CompQtable).clone();
            }
            break;
        }
        System.out.println(wakanda.compute_value_of_q_table(distance));
        int[] fx = wakanda.greedy_road();
        for(int x : fx){
            System.out.print(x + " ");
        }
    }
    public void display(){
//        int n = inputData.getSize();
//        for(int i = 0; i < n; i ++){
//            for(int j = 0; j < n; j ++){
//                System.out.print(inputData.getDistance(i, j) + " ");
//            }
//            System.out.println("");
//        }
    }
}
