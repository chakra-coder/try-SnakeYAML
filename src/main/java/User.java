import java.util.List;
import java.util.Map;

/**
 * Created by SS on 2016/08/12.
 */
public class User {
    private int id;
    private String name;
    private List<String> hobby;
    private Map<String, Object> skill;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getHobby() { return hobby; }
    public void setHobby(List<String> hobby) { this.hobby = hobby; }

    public Map<String, Object> getSkill() { return skill; }
    public void setSkill(Map<String, Object> skill) { this.skill = skill; }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", hobby=" + hobby + ", skill=" + skill;
    }
}
