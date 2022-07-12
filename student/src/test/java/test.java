import java.util.UUID;

/**
 * @ClassName : test
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/12  17:39
 */
public class test {
    public static void main(String[] args) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace);
        System.out.println(Long.valueOf(replace));
    }
}
