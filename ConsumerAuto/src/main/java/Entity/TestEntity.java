package Entity;

public class TestEntity {

    public String routingKey;
    public String name;
    public int id;

    public TestEntity(){

    }

    public TestEntity(String routingKey, String name, int id) {
        this.routingKey = routingKey;
        this.name = name;
        this.id = id;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Entity[" + routingKey + ", " + name + ", " + id + "]";
    }
}
