package beyondtechnology.indicemassa;

/**
 * Created by rodrigo on 27/12/2017.
 */
public class UtilHelper {
    public static double roundNumber(double number){
        double r = Math.round(number * 100);
        r = r / 100;
        return r;
    }
}
