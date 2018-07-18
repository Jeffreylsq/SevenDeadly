package edu.cpp.tianyuwei.sevendeadlysins;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.cpp.tianyuwei.sevendeadlysins.model.QuestionSet;

public class MainActivity extends AppCompatActivity {
    private QuestionSet questionSet;
    private static int currentQuestionIndex;
    private TextView questionTextView;
    public static int array[]={0,0,0,0,0,0,0};                        //baoshi=0,fennu=0,landuo=0,aoman=0,qiangyu=0,seyu=0,jidu=0;
   public Button finish;

    public void init()
    {
        finish =(Button)findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toy = new Intent(MainActivity.this,Result.class);
                startActivity(toy);
            }
        });
    }





    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       init();


        questionSet = new QuestionSet();
        questionSet.addQuestion("   Do you eat alot everyday and sometimes you can not stop by yourself ",true);
        questionSet.addQuestion("   Are you passionate about food and if you can not eat something you really want, you will in bad mood ",true);
        questionSet.addQuestion("   Are you easily angered?",true);
        questionSet.addQuestion("   Will you throw something when you are angry",true);
        questionSet.addQuestion("   You seldom complete your plan on time",true);
        questionSet.addQuestion("   Will you start doing your homework at the last minute", true);
        questionSet.addQuestion("   Will you always ignore some people who you don't really like", true);
        questionSet.addQuestion("   Do you sometimes look down on others",true);
        questionSet.addQuestion("   When others have something that you also dreams of, would you also want to get it no matter what way", true);
        questionSet.addQuestion("   Will you do whatever it takes to achieve your goal", true);
        questionSet.addQuestion("   Do you very eager for sex sometimes or you really want have sex with someone you like", true);
        questionSet.addQuestion("   Do you feel upset without sex", true);
        questionSet.addQuestion("   Do you often envy the lives of others",true);
        questionSet.addQuestion("   You feel not comfortable or jealous when your friend has a success career", true);
        currentQuestionIndex=0;

           questionTextView = findViewById(R.id.questionTextView);
           questionTextView.setTextColor(Color.YELLOW);
          questionTextView.setText(questionSet.getQuestion(currentQuestionIndex).getTitle());

       Button trueButton = findViewById(R.id.trueButton);
       trueButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(questionSet.getQuestion(currentQuestionIndex).isCorrectAnswer()==true)
               {
                   if(currentQuestionIndex <2)
                   {
                      array[0]++;
                   }
                   else if(currentQuestionIndex<4)
                   {
                       array[1]++;//fennu++;
                   }
                   else if(currentQuestionIndex<6)
                   {
                       array[2]++;              //landuo++;
                   }
                   else if(currentQuestionIndex<8)
                   {
                            array[3]++;   //  aoman++;
                   }
                   else if(currentQuestionIndex<10)
                   {
                            array[4]++;            //qiangyu++;
                   }
                   else if(currentQuestionIndex <12)
               {
                   array[5]++;//seyu++;

               }
                   else
                   {
                       array[6]++;    //jidu++;
                   }


               }
               Toast.makeText(MainActivity.this,"please continue",Toast.LENGTH_SHORT).show();

           }
       });
      Button falseButton = findViewById(R.id.falseButton);
       falseButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Log.d("UI", "The false button has been clicked");
               Toast.makeText(MainActivity.this,"please continue", Toast.LENGTH_SHORT).show();

           }
       });

       Button nextButton =  findViewById(R.id.nextButton);
       nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

                  currentQuestionIndex ++;
                  currentQuestionIndex = (currentQuestionIndex+1)%questionSet.getSize();
               questionTextView.setText(questionSet.getQuestion(currentQuestionIndex).getTitle());
           }
       });








    }


}
