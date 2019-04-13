public class EmailVerify {

    public static void main(String[] args){

        String emailregex = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}";
        String email = "julia0_@gmail.com";
        System.out.println(email.matches(emailregex));

    }


}
