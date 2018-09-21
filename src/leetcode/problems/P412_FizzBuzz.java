package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class P412_FizzBuzz {

    public static void main(String[] strings) {
        P412_FizzBuzz fizzBuzz412 = new P412_FizzBuzz();
        System.out.println(fizzBuzz412.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz_412");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
