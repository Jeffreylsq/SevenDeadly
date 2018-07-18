package edu.cpp.tianyuwei.sevendeadlysins.model;
import java.util.ArrayList;
import java.util.List;
public class QuestionSet {

    private List<question>questionList;

    public QuestionSet()
    {
        this.questionList = new ArrayList<>();
    }
    public void addQuestion(String title, boolean correctAnswer)
    {
           question q = new question();
           q.setTitle(title);
           q.setCorrectAnswer(correctAnswer);
           questionList.add(q);
    }

    public question getQuestion(int index){

        return questionList.get(index);
    }
public int getSize()
{
    return questionList.size();
}



}
