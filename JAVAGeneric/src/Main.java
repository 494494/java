import javax.swing.text.html.ListView;

public class Main {
    public static void main(String[] args) {
        Park[] nationalParks = new Park[]{
                new Park("YEllowstonr","44.4882, -110.2916"),
                new Park ("GrandCanyon "," 36.1085, -112.0985"),
                new Park("yosemite","37.8858,-119.46554")
        };
        Layer<Park> parkLayer= new Layer<>(nationalParks);
        parkLayer.render();

        Rivers[] MajorRivers= new Rivers[]{
          new Rivers("riv1", "47.2160, -95.2348",
                  "35.1556, -90.0659",
                  "29.1566, -89.2495"),
          new Rivers("Missouri","45.9239, -111.4983",
                  "38.8146, -90.1218")
        };
        Layer<Rivers> riversLayer=new Layer<>(MajorRivers);

        riversLayer.addElements(new Rivers("reiver345","40.54325,-6543.5434","43.65432,-23.654324"));
        riversLayer.render();
    }
}
