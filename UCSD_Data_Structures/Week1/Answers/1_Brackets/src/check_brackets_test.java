import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sheilaloekito on 6/12/16.
 */
public class check_brackets_test {
    @Test
    public void test_Success_String(){
        String input = "[()]";
        String out = check_brackets.checkBrackets(input);
        assertEquals("Success", out);
    }

    @Test
    public void test_Success_String2(){
        String input = "[{[]}()";
        String out = check_brackets.checkBrackets(input);
        assertEquals("Success", out);
    }

    @Test
    public void test_Success_String3(){
        String input = "[foo(bar);";
        String out = check_brackets.checkBrackets(input);
        assertEquals("Success", out);
    }

    @Test
    public void test_Fail_String(){
        String input = "{[}";
        String out = check_brackets.checkBrackets(input);
        assertEquals("3", out);
    }

    @Test
    public void test_One_String(){
        String input = "{";
        String out = check_brackets.checkBrackets(input);
        assertEquals("1", out);
    }

    @Test
    public void test_Empty_String(){
        String input = "";
        String out = check_brackets.checkBrackets(input);
        assertEquals( "0", out);
    }
}