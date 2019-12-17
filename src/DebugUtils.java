import java.util.ArrayList;

public class DebugUtils {
    public static void Write(ArrayList<Residence> newData) {
        for(Residence r: newData){
            System.out.println(r.getStringValue());
        }
    }
}
