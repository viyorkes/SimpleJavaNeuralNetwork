import java.util.Arrays;

public class TestPerceptron {
    public static void main(String[] args) {
        // Definir o número de entradas
        int numberOfInputs = 2;

        // Criar uma instância do perceptron
        SimplePerceptron perceptron = new SimplePerceptron(numberOfInputs);

        // Dados de treinamento (função lógica AND)
        double[][] inputs = {
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };


        int[] targets = {1, -1, -1, -1};

        // Treinar o perceptron com os dados
        for (int epoch = 0; epoch < 1000; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                perceptron.train(inputs[i], targets[i]);
            }
        }

        // Testar o perceptron
        for (int i = 0; i < inputs.length; i++) {
            int output = perceptron.feedforward(inputs[i]);
            System.out.println("Entrada: " + Arrays.toString(inputs[i]) + " Saída: " + output);
        }
    }
}
