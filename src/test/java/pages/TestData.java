package pages;
import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
    static Faker faker = new Faker (new Locale("ru"));
    public static String firstName = faker.name().fullName();
    public static  String lastName = "Kananykhin";
    public static  String myEmail = "useremail@test.com";
    public static String myNumber = "1234567891";
    public static String myBirthDate = "25 January,1992";
    public static String mySubject = "Accounting";
    public static String myPicture = "cat.png";
    public static String myAddress = "somewhere in Syberia";
    public static String myState = "NCR";
    public static String myCity = "Delhi";
    public static String myHobbie = "Music";
}
