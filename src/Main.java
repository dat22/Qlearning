import main.java.Models.Qlearning_framework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        String filename = "Data_48_33523.txt";
        Qlearning_framework models = new Qlearning_framework(filename);
        models.Q_learning();
    }
}