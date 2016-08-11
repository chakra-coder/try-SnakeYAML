import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.yaml.snakeyaml.DumperOptions.*;
import static org.yaml.snakeyaml.DumperOptions.FlowStyle.*;
import static org.yaml.snakeyaml.nodes.Tag.YAML;

/**
 * Created by SS on 2016/08/12.
 */
public class Main {
    public static void main(String... args) throws IOException {
//        load();
        dump();
    }

    private static void load() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        List list = yaml.loadAs(ClassLoader.getSystemResourceAsStream("list.yaml"), List.class);
        System.out.println(list);
        Map map = yaml.loadAs(ClassLoader.getSystemResourceAsStream("map.yaml"), Map.class);
        System.out.println(map);
        User user = yaml.loadAs(ClassLoader.getSystemResourceAsStream("user.yaml"), User.class);
        System.out.println(user);
        for (Object obj : yaml.loadAll(ClassLoader.getSystemResourceAsStream("loadAll.yaml"))) {
            System.out.println(obj);
        }
    }

    private static void dump() throws IOException {
        Yaml yaml = new Yaml();

        List list2 = yaml.loadAs(new FileReader("list.yaml"), List.class);
        System.out.println("<<< BEFORE >>>");
        System.out.println(list2);

//        List<? extends Serializable> list = Arrays.asList("hoge2", null, 123456, true);
        list2.add(Arrays.asList("hoge3", null, 123, true));
        String yamlData = yaml.dump(list2);
//        System.out.println(yamlData);

//        yamlData = yaml.dumpAs(list, YAML, BLOCK);
//        System.out.println(yamlData);

        yaml.dump(list2, new FileWriter("list.yaml"));

        list2 = yaml.loadAs(new FileReader("list.yaml"), List.class);
        System.out.println("<<< AFTER >>>");
        System.out.println(list2);
    }
}
