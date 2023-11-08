package com.company;

public class Indexator
{
    public int index_Str(String temp)
    {
        int index = 0;

        StateMachine st = new StateMachine();

        while (st.DFA(temp) > 0)
        {
            temp = temp.replaceFirst(temp.substring(0,st.DFA(temp) + 1), "");

            index++;
        }
        return index;
    }
}
