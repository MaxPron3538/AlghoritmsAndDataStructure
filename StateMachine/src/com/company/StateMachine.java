package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class StateMachine
{
    public int DFA(String str)
    {
        String state = Transition.get(0);

        for(int index = 0;index < str.length();index++)
        {
           if(state.equals(Transition.get(0)))
           {
               if (str.charAt(index) == ':') return str.indexOf(state);

               else if(str.charAt(index) == ';')
               {
                   state = Transition.get(1);
                   return str.indexOf(state);
               }
               else if(str.charAt(index) == '-')
               {
                   if(state.equals(Transition.get(0))) state = Transition.get(1);
                   if(state.equals(Transition.get(1))){ state = Transition.get(2); return str.indexOf(state);}
               }
           }
           else if(state.equals(Transition.get(1)))
           {
               if(str.charAt(index) == ';') return str.indexOf(Transition.get(1));

               else if(str.charAt(index) == '-')
               {
                   state = Transition.get(2);
                   return str.indexOf(state);
               }
               else if(str.charAt(index) == ':')
               {
                   if(state.equals(Transition.get(1))) state = Transition.get(2);
                   if(state.equals(Transition.get(2))){ state = Transition.get(0); return str.indexOf(state);}
               }
           }
           else if(state.equals(Transition.get(2)))
           {
               if(str.charAt(index) == '-') return str.indexOf(Transition.get(2));

               else if(str.charAt(index) == ':')
               {
                   state = Transition.get(0);
                   return str.indexOf(state);
               }
               else if(str.charAt(index) == ';')
               {
                   if(state.equals(Transition.get(2))) state = Transition.get(0);
                   if(state.equals(Transition.get(0))){ state = Transition.get(1); return str.indexOf(state);}
               }
           }
        }
        return 0;
    }

    public char setTransition(State state)
    {
        switch(state)
        {
            case Initial: return ':';

            case Intermediate: return ';';

            case  Final: return '-';
        }
    return 0;
    }

    ArrayList<String> Transition = new ArrayList<String>(Arrays.asList(String.valueOf(setTransition(State.Initial)),
            String.valueOf(setTransition(State.Intermediate)),String.valueOf(setTransition(State.Final))));

    enum State{Initial,Intermediate,Final};

}
