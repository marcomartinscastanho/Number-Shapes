package com.martinscastanho.marco.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    class Number {
        public Integer number;

        public Boolean isSquare() {
            Double squareRoot = Math.sqrt(number);
            return (squareRoot == Math.floor(squareRoot));
        }

        public Boolean isTriangular() {
            Integer x = 1;
            Integer triangularNumber = 1;
            while(triangularNumber < number){
                x++;
                triangularNumber+=x;
            }
            return (triangularNumber==number);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testNumber(View view) {
        List<String> people = new ArrayList<String>();
        people.add("Rob");

        for (String name : people){
            System.out.println(name);
        }

        Log.i("Info", "Button Pressed");
        Number myNumber = new Number();
        EditText numberEditText = findViewById(R.id.numberEditText);
        String message = "";
        if(numberEditText.getText().toString().isEmpty()){
            message = "Please enter a number!";
        }
        else {
            myNumber.number = Integer.parseInt(numberEditText.getText().toString());
            message = numberEditText.getText().toString();
            if(myNumber.isSquare() && myNumber.isTriangular()){
                message += " is square and triangular!";
            }
            else if(myNumber.isSquare()) {
                message += " is square but not triangular.";
            }
            else if(myNumber.isTriangular()) {
                message += " is triangular but not square.";
            }
            else {
                message += " is neither square not triangular.";
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
