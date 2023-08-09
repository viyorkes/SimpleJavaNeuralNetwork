import java.util.stream.IntStream;

public class SimplePerceptron {
    // Learning rate
    double learningRate = 0.1;
    // Weights of the neural network
    double[] weights;

    // Constructor to initialize the weights randomly
    public SimplePerceptron(int n) {
        weights = new double[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Math.random() * 2 - 1; // Initializing weights between -1 and 1
        }
    }

    // Activation function (here we use the step function)
    public int activation(double sum) {
        return sum >= 0 ? 1 : -1;
    }

    // Function to feed the input through the network and get the output
    public int feedforward(double[] inputs) {
        double sum = 0;
        // Using lambda to calculate the weighted sum
        sum = IntStream.range(0, weights.length)
                .mapToDouble(i -> inputs[i] * weights[i])
                .sum();
        return activation(sum); // Applying the activation function
    }

    // Function to train the neural network
    public void train(double[] inputs, int target) {
        int guess = feedforward(inputs); // Getting the current output for the given input
        int error = target - guess; // Calculating the error
        // Adjusting the weights based on the error using lambda
        IntStream.range(0, weights.length)
                .forEach(i -> weights[i] += learningRate * error * inputs[i]);
    }
}

