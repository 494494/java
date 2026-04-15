public class Park extends point{
    private String name;


    public Park( String name,String location) {
        super(location);
        this.name=name;
    }

    public String toStrin(){
        return name+ "National park";
    }
}
