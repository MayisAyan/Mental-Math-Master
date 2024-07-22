import java.lang.*;
import java.util.Scanner;

class Player {
    private int totalAnswers = 0;
    private int count = 0;

    public void setTotalAnswers() {
        ++totalAnswers;
    }
    public void setCount() {
        ++count;
    }
    public int getTotalAnswers(){
        return totalAnswers;
    }
    public int getCount() {
        return count;
    }
}

class ArithmeticUtils {
    private int operand1 = 0;
    private int operand2 = 0;
    private int result = 0;
    private String[] randomOperators = new String[] {"+", "-", "*", "/"};
    private String currentOperator = randomOperators[(int)(Math.random() * (3+ 1))];
    ArithmeticUtils(){
        switch(currentOperator){
            case "+":
                operand1 = randomNumbers(99,10);
                operand2 = randomNumbers(99,10);
                result = operand1 + operand2;
                break;
            case "-":
                operand1 = randomNumbers(99,10);
                operand2 = randomNumbers(99,10);
                result = operand1 - operand2;
                break;
            case "*":
                operand1 = randomNumbers(99,0);
                operand2 = randomNumbers(9,0);
                result = operand1 * operand2;
                break;
            case "/":
                do{
                    operand1 = randomNumbers(99,1);
                    operand2 = randomNumbers(99,1);
                }
                while(operand1 % operand2 != 0);
                result = operand1 / operand2;
                break;
        }
    }

    public int randomNumbers(int max, int min) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public int getOperand1 (){
        return operand1;
    }
    public int getOperand2(){
        return operand2;
    }
    public int getResult(){
        return result;
    }
    public String getCurrentOperator(){
        return currentOperator;
    }
}

class Question{
    ArithmeticUtils chlp = new ArithmeticUtils();
    private String expression;
    private int correctAnswer;
    Question(){
        expression = chlp.getOperand1() + " " + chlp.getCurrentOperator() + " " + chlp.getOperand2();
        correctAnswer = chlp.getResult();
    }

    public String getExpression() {
        return expression;
    }
    public int getCorrectAnswerer() {
        return correctAnswer;
    }
}

class Game {
    private long startTime = System.currentTimeMillis();
    private int answer;
    private void print1(String str){
        System.out.println("str");
    }
    Scanner yourAnswer = new Scanner( System.in );

    String str = yourAnswer.nextLine();
    public void startGame() {
        Player player = new Player();

        do{
            Question question = new Question();
            System.out.println(question.getExpression());
            answer = yourAnswer.nextInt();
            player.setTotalAnswers();
            if(answer == question.getCorrectAnswerer()){
                player.setCount();
            }
        }
        while(System.currentTimeMillis() - startTime <= 60000);
        System.out.println("You answered:" + player.getTotalAnswers());
        System.out.println("You have " + player.getCount() + " correct answers");
    }

}

class Main{
    public static void main(String[] args){
        Game game = new Game();
        game.startGame();
    }
}