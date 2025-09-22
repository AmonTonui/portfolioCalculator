package portfolioCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class MainGui extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton calculatorButton;
	private JButton shapesButton;
	private JButton quadraticButton;
	private JButton statisticalButton;
	
	public MainGui() {
		setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        calculatorButton = new JButton("Basic Calculator");
        calculatorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculatorButton.addActionListener(this);
        add(calculatorButton);

        shapesButton = new JButton("Area of Shapes");
        shapesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        shapesButton.addActionListener(this);
        add(shapesButton);

        quadraticButton = new JButton("Quadratic Equation");
        quadraticButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quadraticButton.addActionListener(this);
        add(quadraticButton);
        
        statisticalButton = new JButton("Statistical calculator");
        statisticalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        statisticalButton.addActionListener(this);
        add(statisticalButton);

        setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == calculatorButton) {
			new CalculatorGui();
		}
		else if (e.getSource() == shapesButton) {
			new ShapesGui();
		}
		else if (e.getSource()== quadraticButton) {
			new QuadraticGui();
		}
		else if (e.getSource() == statisticalButton) {
            new StatisticalGui();
        }
	
	
	}
	public static void main (String args[]) {
		new MainGui();
	}
	
	public class CalculatorGui extends JFrame implements ActionListener {
		private static final long serialVersionUID = 1L;
		private JTextField resultField;
		private JButton[] numberButtons;
		private JButton addButton, subtractButton, multiplyButton, divideButton, calculateButton, clearButton;
		private  double Num1, Num2;
		private String Operator;
		private JButton decimalButton;
		
		public CalculatorGui() {
			setTitle("basic Calculator");
			setSize(300, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new GridLayout(6, 4));
            
            resultField = new JTextField();
            add(resultField);
            
            numberButtons = new JButton [10];
            //adds the integer buttons from 0 to 9
            for (int i = 0; i < 10; i++) {
            	numberButtons[i] = new JButton(String.valueOf(i));
            	numberButtons[i].addActionListener(this);
            	add(numberButtons[i]);
            }
            //initialises the buttons
            addButton = new JButton("+");
            addButton.addActionListener(this);
            add(addButton);
            
            subtractButton = new JButton("-");
            subtractButton.addActionListener(this);
            add(subtractButton);
            
            multiplyButton = new JButton("*");
            multiplyButton.addActionListener(this);
            add(multiplyButton);
            
            divideButton = new JButton("/");
            divideButton.addActionListener(this);
            add(divideButton);
            
            calculateButton = new JButton("=");
            calculateButton.addActionListener(this);
            add(calculateButton);
            
            clearButton = new JButton("C");
            clearButton.addActionListener(this);
            add(clearButton);
            
            decimalButton = new JButton(".");
            decimalButton.addActionListener(this);
            add(decimalButton);
            
            
            setVisible(true);
            		
            	
            
            
            
            
		}
		@Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0 ; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    resultField.setText(resultField.getText() + i);
                    return;
                }
            }

            if (e.getSource() == addButton) {
                Operator = "+";
                Num1 = Double.parseDouble(resultField.getText());
                resultField.setText("");
            } 
            else if (e.getSource() == subtractButton) {
                Operator = "-";
                Num1 = Double.parseDouble(resultField.getText());
                resultField.setText("");
            } 
            else if (e.getSource() == multiplyButton) {
                Operator = "*";
                Num1 = Double.parseDouble(resultField.getText());
                resultField.setText("");
            } 
            else if (e.getSource() == divideButton) {
                Operator = "/";
                Num1 = Double.parseDouble(resultField.getText());
                resultField.setText("");
                
             
            }else if (e.getSource() == decimalButton) {
                String currentText = resultField.getText();
                if (!currentText.contains(".")) {
                    resultField.setText(currentText + ".");
                }
                return;
            } 
            else if (e.getSource() == calculateButton) {
                Num2 = Double.parseDouble(resultField.getText());
                switch (Operator) {
                    case "+":
                        resultField.setText(String.valueOf(Num1 + Num2));
                        break;
                    case "-":
                        resultField.setText(String.valueOf(Num1 - Num2));
                        break;
                    case "*":
                        resultField.setText(String.valueOf(Num1 * Num2));
                        break;
                    case "/":
                        if (Num2 != 0) {
                            resultField.setText(String.valueOf((double) Num1 / Num2));
                        } 
                        else {
                            resultField.setText("Error");
                        }
                        break;
                }
                
            } 
            else if (e.getSource() == clearButton) {
                resultField.setText("");
                Num1 = 0;
                Num2 = 0;
            }		
		
	}
	
	
		
	}
	
	public class ShapesGui extends JFrame implements ActionListener {

		    private static final long serialVersionUID = 1L;
			private JComboBox<String> shapesComboBox;
		    private JTextField[] inputFields;
		    private JLabel[] labels;
		    private JButton calculateButton;
		    private JLabel resultLabel;
		
		    private String[] shapes = {"Circle", "Cylinder", "Triangle", "Rectangle or Square", "Cone", "Parallelogram", "Trapezium"};
		
		    public ShapesGui() {
		        setTitle("Shapes Calculator");
		        setSize(600, 600);
		        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        setLayout(new BorderLayout());
		
		        JPanel topPanel = new JPanel();
		        topPanel.setLayout(new FlowLayout());
		        JLabel instructionLabel = new JLabel("Select a shape and enter the required dimensions:");
		        topPanel.add(instructionLabel);
		        shapesComboBox = new JComboBox<>(shapes);
		        shapesComboBox.addActionListener(this);
		        topPanel.add(shapesComboBox);
		        add(topPanel, BorderLayout.NORTH);
		
		        JPanel centerPanel = new JPanel();
		        centerPanel.setLayout(new GridBagLayout());
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.insets = new Insets(5, 5, 5, 5);
		
		        labels = new JLabel[3];
		        inputFields = new JTextField[3];
		
		        for (int i = 0; i < labels.length; i++) {
		            labels[i] = new JLabel();
		            gbc.gridx = 0;
		            gbc.gridy = i;
		            centerPanel.add(labels[i], gbc);
		
		            inputFields[i] = new JTextField(10);
		            inputFields[i].setVisible(false);
		            gbc.gridx = 1;
		            gbc.gridy = i;
		            centerPanel.add(inputFields[i], gbc);
		        }
		
		        gbc.gridx = 0;
		        gbc.gridy = labels.length;
		        gbc.gridwidth = 2;
		        gbc.anchor = GridBagConstraints.WEST;
		        resultLabel = new JLabel();
		        centerPanel.add(resultLabel, gbc);
		
		        add(centerPanel, BorderLayout.CENTER);
		
		        calculateButton = new JButton("Calculate");
		        calculateButton.addActionListener(this);
		        JPanel buttonPanel = new JPanel();
		        buttonPanel.add(calculateButton);
		        add(buttonPanel, BorderLayout.SOUTH);
		
		        setVisible(true);
		    }
		
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == shapesComboBox) {
		            String selectedShape = (String) shapesComboBox.getSelectedItem();
		            resetInputFields();
		            resultLabel.setText("");
		            resultLabel.setVisible(false);
		
		            if (selectedShape != null) {
		                switch (selectedShape) {
		                    case "Circle":
		                        setLabelAndVisibility("Radius:", true, 0);
		                        break;
		                    case "Cylinder":
		                        setLabelAndVisibility("Radius:", true, 0);
		                        setLabelAndVisibility("Height:", true, 1);
		                        break;
		                    case "Triangle":
		                        setLabelAndVisibility("Base:", true, 0);
		                        setLabelAndVisibility("Height:", true, 1);
		                        break;
		                    case "Rectangle or Square":
		                        setLabelAndVisibility("Length:", true, 0);
		                        setLabelAndVisibility("Width:", true, 1);
		                        break;
		                    case "Cone":
		                        setLabelAndVisibility("Radius:", true, 0);
		                        setLabelAndVisibility("Height:", true, 1);
		                        break;
		                    case "Parallelogram":
		                        setLabelAndVisibility("Base:", true, 0);
		                        setLabelAndVisibility("Height:", true, 1);
		                        break;
		                    case "Trapezium":
		                        setLabelAndVisibility("Base 1:", true, 0);
		                        setLabelAndVisibility("Base 2:", true, 1);
		                        setLabelAndVisibility("Height:", true, 2);
		                        break;
		                }
		            }
		        } else if (e.getSource() == calculateButton) {
		            String selectedShape = (String) shapesComboBox.getSelectedItem();
		            if (selectedShape != null) {
		            	
		              
		                double[] dimensions = getDimensions();
		                double result = calculateArea(selectedShape, dimensions);
		                resultLabel.setVisible(true);
		                
		                String precisionInput = JOptionPane.showInputDialog("Specify the precision :");
		                int decimalPlaces = Integer.parseInt(precisionInput);
		                double roundedResult = Math.round(result * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);

		                resultLabel.setText("The area of the " + selectedShape + " to " + decimalPlaces + " decimal places is: " + roundedResult);
		            }
		        }
		    }
		
		    private void resetInputFields() {
		        for (int i = 0; i < inputFields.length; i++) {
		            inputFields[i].setText("");
		            inputFields[i].setVisible(false);
		        }
		    }
		
		    private void setLabelAndVisibility(String labelText, boolean visibility, int index) {
		        labels[index].setText(labelText);
		        inputFields[index].setVisible(visibility);
		    }
		
		    private double[] getDimensions() {
		        double[] dimensions = new double[inputFields.length];
		        for (int i = 0; i < inputFields.length; i++) {
		            String input = inputFields[i].getText();
		            if (input.isEmpty()) {
		                dimensions[i] = 0.0;
		            } else {
		                dimensions[i] = Double.parseDouble(input);
		                if (dimensions[i] < 0) {
		                	JOptionPane.showMessageDialog(this, "Input positive values only ", "error", JOptionPane.ERROR_MESSAGE);
		                    dimensions[i] = 0.0;
		                }
		            }
		        }
		        return dimensions;
		    }
		
		    private double calculateArea(String shape, double[] dimensions) {
		        switch (shape) {
		            case "Circle":
		                return Math.PI * Math.pow(dimensions[0], 2);
		            case "Cylinder":
		                return 2 * Math.PI * dimensions[0] * (dimensions[0] + dimensions[1]);
		            case "Triangle":
		                return 0.5 * dimensions[0] * dimensions[1];
		            case "Rectangle or Square":
		                return dimensions[0] * dimensions[1];
		            case "Cone":
		                return Math.PI * dimensions[0] * (dimensions[0] + Math.sqrt(Math.pow(dimensions[0], 2) + Math.pow(dimensions[1], 2)));
		            case "Parallelogram":
		                return dimensions[0] * dimensions[1];
		            case "Trapezium":
		                return (dimensions[0] + dimensions[1]) * dimensions[2] / 2;
		            default:
		                return 0.0;
		        }
		    }
		    

	
	}
	
	public class QuadraticGui extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		private JTextField aField;
		private JTextField bField;
		private JTextField cField;
		private JButton calculateButton;
		private JLabel root1Label;
		private JLabel root2Label;
		
		public QuadraticGui() {
			setTitle("Quadratic Calculator");
	        setSize(600, 600);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLayout(new GridBagLayout());
	        
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(10, 10, 10, 10);

			
			JLabel instructionLabel = new JLabel("Enter the coefficients of a, b, and c");
	        add(instructionLabel,gbc);
			
	        JLabel aLabel = new JLabel("a:");
	        aField = new JTextField(10);
	        add(aLabel);
	        add(aField, gbc);

			
	        JLabel bLabel = new JLabel("b:");
	        bField = new JTextField(10);
	        add(bLabel);
	        add(bField, gbc);
			
	        JLabel cLabel = new JLabel("c:");
	        cField = new JTextField(10);
	        add(cLabel);
	        add(cField, gbc);
			
			calculateButton = new JButton("Calculate");
			calculateButton.addActionListener(this);
			add(calculateButton, gbc);
			
			root1Label = new JLabel("", SwingConstants.CENTER);
			add(root1Label, gbc);
			
			root2Label = new JLabel("", SwingConstants.CENTER);
			add(root2Label, gbc);
			
			pack();
			
			setVisible(true);
			
			
		}
		public void actionPerformed(ActionEvent e) {
			double a = Double.parseDouble(aField.getText());
	        double b = Double.parseDouble(bField.getText());
	        double c = Double.parseDouble(cField.getText());
	        double discriminant = (Math.pow(b, 2) - (4*a*c));
	        
	        System.out.println("a: " + a);
	        System.out.println("b: " + b);
	        System.out.println("c: " + c);
	        System.out.println("Discriminant: " + discriminant);
	      

	     
	        
	        if (discriminant >= 0) {
	            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
	            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
	            root1Label.setText("Root 1: " + root1);
	            root2Label.setText("Root 2: " + root2);
	        } else {
	            root1Label.setText("No real root");
	            root2Label.setText("");
	        }
		}
    }
	public class StatisticalGui extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		private JButton calculateButton;
		private JTextField inputField;
		private JLabel Result;
		private JComboBox<String>statisticsOperation;
		private String[] Operations = {"Mean", "Median", "Variance", "Standard Deviation"};
		
		public StatisticalGui() {
			setTitle("Statistical calculator");
			setSize(600, 500);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new GridBagLayout());
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 10, 10, 10);
			
			JPanel optionsPanel = new JPanel();
			optionsPanel.setLayout(new FlowLayout());
			
			JLabel promptLabel = new JLabel("Select the statictical operation");
			gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;
	        add(promptLabel, gbc);
			
			
			statisticsOperation = new JComboBox<>(Operations);
			gbc.gridx = 1;
	        gbc.gridy = 0;
			statisticsOperation.addActionListener(this);
			gbc.anchor = GridBagConstraints.WEST;
	        add(statisticsOperation, gbc);
	        
	        JLabel inputLabel = new JLabel("Input the numbers separating with commas:");
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.gridwidth = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        add(inputLabel, gbc);
			
			inputField = new JTextField();
			gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.gridwidth = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        add(inputField, gbc);
			
			Result = new JLabel("", SwingConstants.CENTER);
			gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        add(Result, gbc);
			
	        calculateButton = new JButton("Calculate");
	        calculateButton.addActionListener(this);
	        gbc.gridx = 0;
	        gbc.gridy = 6; 
	        gbc.gridwidth = 2;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        add(calculateButton, gbc);

			
			setVisible(true);
			
			
			
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String [] numberInput = inputField.getText().split(",");
			double[] numbers = new double[numberInput.length];
			for (int i = 0; i < numberInput.length; i++) {
				numbers[i] = Double.parseDouble(numberInput[i]);
			}
			
			String operation = (String) statisticsOperation.getSelectedItem();
			double result;
			switch(operation) {
            case "Mean":
                result = calculateMean(numbers);
                break;
            case "Median":
                result = calculateMedian(numbers);
                break;
            case "Variance":
                result = calculateVariance(numbers);
                break;
            case "Standard Deviation":
                result = calculateStdDev(numbers);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
		Result.setText(operation + ": " + result);
		
		}
		private double calculateMean(double[] numbers) {
	        double sum = 0;
	        for (double number : numbers) {
	            sum += number;
	        }
	        return sum / numbers.length;
	    }
		
		private double calculateMedian(double[] numbers) {
	        Arrays.sort(numbers);
	        int middle = numbers.length / 2;
	        if (numbers.length % 2 == 0) {
	            return (numbers[middle - 1] + numbers[middle]) / 2.0;
	        } else {
	            return numbers[middle];
	        }
	    }
		
		private double calculateVariance(double[] numbers) {
	        double mean = calculateMean(numbers);
	        double squaredDifferenceSum = 0;
	        for (double number : numbers) {
	            squaredDifferenceSum += Math.pow(number - mean, 2);
	        }
	        return squaredDifferenceSum / numbers.length;
	    }
		
		private double calculateStdDev(double[] numbers) {
	        return Math.sqrt(calculateVariance(numbers));
	    }
		
			
		
	}
		
		
	
}
