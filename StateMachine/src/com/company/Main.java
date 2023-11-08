package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        try(FileInputStream reader = new FileInputStream("temp.txt"))
        {
            StateMachine st = new StateMachine();
            byte[] byteStr = new byte[reader.available()];
            reader.read(byteStr,0, reader.available());
            String str = new String(byteStr);
            String temp = new String(str);
            ArrayList<String> array = new ArrayList<>();
            Indexator size = new Indexator();
            int count = 0;

            while (size.index_Str(str) > 0) {
                String substr = str.substring(0, st.DFA(str) + 1);
                array.add(substr);
                str = str.replaceFirst(substr, "");
            }

            while (count < size.index_Str(temp)) {
                if (st.DFA(array.get(count)) > 0) System.out.println(array.get(count) + "  " + true);

                count++;
            }
        }
        catch (IOException ex)
        {
          System.out.println(ex.getMessage());
        }

    }
}
