import java.util.Arrays;

public interface Mappable {

    void render();

    static double[] stringToLatLon(String Location){
        String[] arr= Location.split(",");
        double lat=Double.parseDouble(arr[0]);
        double lon=Double.parseDouble(arr[1]);
        return new double[]{lat, lon};
    }
}
//Point .......................................
abstract class point implements Mappable{
    private double[] location =new double[2];
    private String location(){
        return Arrays.toString(location);
    }

    public point (String location){
        this.location=Mappable.stringToLatLon(location);
    }
    @Override
    public void render() {
        System.out.println("Render "+ this+ " as Pint ("+
                location()+" )");
    }
}

//Line.......................................
abstract class  line implements Mappable{
    private  double[][] locations;

    private String location(){
        return Arrays.deepToString(this.locations);
    }

    public line(String... locations){
        this.locations= new double[locations.length][];
        int index= 0;
        for(var l: locations){
            this.locations[index++]=Mappable.stringToLatLon(l);
        }
    }

    @Override
    public void render() {
        System.out.println("render "+ this +" as Line ( "+ location()+" )");
    }
}