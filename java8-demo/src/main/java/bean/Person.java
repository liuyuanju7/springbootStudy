package bean;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author liuyuanju1
 * @date 2018/7/29
 * @description:
 */
@Data
@ToString
@Accessors(chain = true)
public class Person {
    private String name;
    private int age;
    private String sex;
}
