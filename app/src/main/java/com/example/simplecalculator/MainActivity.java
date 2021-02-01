package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //private variables for the 2 editText
    private EditText calculation, result;
    //string variable to store the calculation and result
    private String curr, res;
    //for all the buttons
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC, btnDel, btnDivision, btnMultiplication, btnAddition,btnSubtraction,btnDot, btnEqual;
    //Variable for the dot button
    private boolean dot_inserted, operator_inserted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize all the private variables
        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";

        //initialize the dot button
        dot_inserted = false;
        operator_inserted = false;

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDivision = (Button) findViewById(R.id.btnDivide);
        btnMultiplication = (Button) findViewById(R.id.btnMultiply);
        btnSubtraction = (Button) findViewById(R.id.btnMinus);
        btnAddition = (Button) findViewById(R.id.btnPlus);
        btnEqual = (Button) findViewById(R.id.btnEquals);
        btnDot = (Button) findViewById(R.id.btnDot);

        //setOnclickListener on the buttons
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              curr = curr + "0";
              displayOne();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "1";
                displayOne();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "2";
                displayOne();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "3";
                displayOne();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "4";
                displayOne();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "5";
                displayOne();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "6";
                displayOne();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "7";
                displayOne();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "8";
                displayOne();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "9";
                displayOne();
            }
        });

        //setOnClickListener on the dot button and validate it
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //First validation is check if it is empty, if yes, Append "0" and set dot_inserted variable to true
                if (curr.isEmpty()){
                    curr = "0.";
                    dot_inserted = true;
                }
                // secondly, check if dot_inserted ==false => append "."
                if (dot_inserted == false){
                    curr = curr + ".";
                    dot_inserted = true;
                }
                //
                displayOne();
            }
        });
        //on the clear button
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                displayOne();
                displayTwo();
            }
        });
        //for the backSpace button
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backSpace();
                displayOne();
            }
        });
        // on the operators buttons
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set do_inserted to false
                dot_inserted = false;
                //check if current string is not empty
                if (!curr.isEmpty()){
                    //check if last digit is a dot => remove it
                    if (curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backSpace();
                    }
                    //check if operator_inserted==false => append operator to curr
                    if (operator_inserted == false){
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }
                //display
                displayOne();
            }
        });
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set do_inserted to false
                dot_inserted = false;
                //check if current string is not empty
                if (!curr.isEmpty()){
                    //check if last digit is a dot => remove it
                    if (curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backSpace();
                    }
                    //check if operator_inserted==false => append operator to curr
                    if (operator_inserted == false){
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                //display
                displayOne();
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //set do_inserted to false
                dot_inserted = false;
                //check if current string is not empty
                if (!curr.isEmpty()){
                    //check if last digit is a dot => remove it
                    if (curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backSpace();
                    }
                    //check if operator_inserted==false => append operator to curr
                    if (operator_inserted == false){
                        curr = curr + " / ";
                        operator_inserted = true;
                    }
                }
                //display
                displayOne();
            }
        });
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set do_inserted to false
                dot_inserted = false;
                //check if current string is not empty
                if (!curr.isEmpty()){
                    //check if last digit is a dot => remove it
                    if (curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backSpace();
                    }
                    //check if operator_inserted==false => append operator to curr
                    if (operator_inserted == false){
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                //display
                displayOne();
            }
        });
        //to use the equals button
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check if last digit is not an operator
                if (operator_inserted = true && !curr.substring(curr.length()-1, curr.length()).equals(" ") ){
                    //create an arrays of strings and save in variable (token)
                    String [] tokens = curr.split(" ");
                    //create switch cases
                    switch (tokens[1].charAt(0)){

                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                            //
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                            //
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                            //
                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();
                }
            }
        });
    }
    //functions for some keys
    public void displayOne(){
        calculation.setText(curr);
    }
    public void displayTwo(){
        result.setText(res);
    }
    //for the clear function
    public void clear(){
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }
    public void backSpace(){
        //if the curr is not empty => remove last char
        if (!curr.isEmpty()){

            //check if dot is the last char in curr => set dot_inserted to false
            if (curr.substring(curr.length()-1, curr.length()).equals(".")){
                dot_inserted = false;
            }
            //if the current operator is detected => delete three digit or chars from the curr & set operator_inserted = false
            if (curr.substring(curr.length()-1, curr.length()).equals(" ")){
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            }else {
                curr = curr.substring(0, curr.length()-1);
            }

        }
    }
}