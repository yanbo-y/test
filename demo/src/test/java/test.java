import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

   /*    // 15.获取某个时间的上周一和周日;
        Calendar cal = Calendar.getInstance();
//n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
        int n = -1;
        String monday;
        cal.add(Calendar.DATE, n*7);
//想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        monday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        System.out.println(monday);*/


        List<Integer> list = new ArrayList<>();

        // list.add(1);
        // list.add(2);
        // list.add("hello");

        Class c = list.getClass();
        Method method = c.getMethod("add",Object.class);
        method.invoke(list,"hello");
        method.invoke(list,"world");
        method.invoke(list,"liwei");

        System.out.println(list);



    }
}
