import main.java.Models.Qlearning_framework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Qlearning_framework models = new Qlearning_framework();
        models.Q_learning();
    }
}