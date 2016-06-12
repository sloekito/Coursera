import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        //InputStreamReader input_stream = new InputStreamReader(System.in);
        //BufferedReader reader = new BufferedReader(input_stream);
        //String text = reader.readLine();

        String text = "(())";
        // Printing answer, write your code here
        String out = checkBrackets(text);
        System.out.println(out);
    }

    public static String checkBrackets(String text)
    {
        if(text.length() < 2)
        {
            return Integer.toString(text.length());
        }
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket bracket = new Bracket(next, position);
                opening_brackets_stack.push(bracket);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if(!opening_brackets_stack.pop().Match(next))
                {

                    return Integer.toString(position + 1);
                }
            }

        }

        return "Success";
    }
}
