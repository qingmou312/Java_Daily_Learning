package PC;

/**
 * Author:lidan
 * Created:2019/2/21
 */
public class Goods {
    private final String id;
    private final String name;

    public Goods(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return  id ;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
