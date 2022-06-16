package caculator_management.service.impl;

import caculator_management.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public Double calculator(double number1, double number2,String operator) {

        switch (operator){
            case "addition(+)":
                return number1 + number2;
            case "subtraction(-)":
                return number1 - number2;
            case "multiplication(x)":
                return number1 * number2;
            default:
                return number1 / number2;
        }
    }
}
