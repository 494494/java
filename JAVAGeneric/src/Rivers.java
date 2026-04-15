public class Rivers extends line{
    private String name;


    public Rivers(String name, String... locations) {
        super(locations);
        this.name=name;
    }

    public String toStrin(){
        return name+ "River";
    }
}
