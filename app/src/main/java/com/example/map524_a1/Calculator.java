package com.example.map524_a1;

import java.util.ArrayList;

public class Calculator {
    public ArrayList<String> inputs;

    Calculator(){
        inputs = new ArrayList<>();
    }

    public void push(String value){
        inputs.add(value);
    }

    public int calculate(){
        int res;
        // There should be at least 3 elements for an operation
        // There should be an odd number of elements for an operation
        if( inputs.size() < 3 || inputs.size() % 2 != 1){
            res = -999999;
        }
        else{
            // First iteration
            if( !inputs.get(0).matches("[0-9]") ||
                    inputs.get(1).matches("[0-9]") ||
                    !inputs.get(2).matches("[0-9]")) {
                res = -999999;
            }
            else{
                res = getResult(Integer.parseInt(inputs.get(0)), inputs.get(1), Integer.parseInt(inputs.get(2)));
                inputs.remove(0);
                inputs.remove(0);
                inputs.remove(0);
            }

            // Loop
            // Error -999999: Not an operation
            // Error -999998: Cannot divide by 0
            while(!inputs.isEmpty() && res != -999999 && res != -999998){
                if(!inputs.get(0).matches("[0-9]") && inputs.get(1).matches("[0-9]")){
                    res = getResult(res, inputs.get(0), Integer.parseInt(inputs.get(1)));
                }
                else{
                    res = -999999;
                }
                inputs.remove(0);
                inputs.remove(0);
            }
        }

        return res;
    }

    private int getResult(int n1, String operator, int n2){
        switch(operator){
            case "+":
                n1 += n2;
                break;
            case "-":
                n1 -= n2;
                break;
            case "*":
                n1 *= n2;
                break;
            case "/":
                n1 = n2 == 0 ? -999998 : (n1 / n2);
                break;
            case "%":
                n1 = n1 % n2;
                break;
            case "POW":
                n1 = (int)Math.pow(n1, n2);
                break;
            case "MAX":
                n1 = Math.max(n1, n2);
                break;
            case "MIN":
                n1 = Math.min(n1, n2);
                break;
            default:
        }
        return n1;
    }
}
