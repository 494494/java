import java.util.LinkedList;
import java.util.Scanner;

record Places(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)",name,distance);
    }
}

public class main {
    public static void main(String[] args) {
        LinkedList<Places> list=new LinkedList<>();
        Places nanded=new Places("Nanded",45);
        addPlace(list,nanded);
//        addPlace(list,nanded);
        addPlace(list,new Places("naigaon",0));
        addPlace(list,new Places("sambhajinagar",300));
        addPlace(list,new Places("Pune",418));
        System.out.println(list);

        var iterator= list.listIterator(); //iterator
        Scanner scanner =new Scanner(System.in);
        boolean quitloop=false;
        boolean forward=true;


        printMenu(); //printing menu
        while(!quitloop){

            if(!iterator.hasPrevious()){
                System.out.println("Start of List " + iterator.next());
                forward=true;
            }
            if(!iterator.hasNext()){
                System.out.println("final "+ iterator.previous());
                forward=false;
            }

            System.out.print("Enter the Value: ");
            String s= scanner.nextLine().substring(0,1).toUpperCase();
            switch (s){
                case "F":
                    System.out.println("user want to go forward");
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "B":
                    System.out.println("user want to go backward");
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "L":
                    System.out.println(list);
                    break;
                case "M":
                    printMenu();
                    break;
                default:
                   quitloop=true;
                    break;
            }
        }

    }
    public static void addPlace(LinkedList<Places> list,Places place){
        if(list.contains(place)){
            System.out.println("Found Duplicate "+ place);
            return;
        }
        for(Places p:list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found Duplicate "+ place);
                return;
            }
        }

        int indexMatch=0;
        for(Places p:list){
            if(place.distance()<p.distance()){
                list.add(indexMatch,place);
                return;
            }
            indexMatch++;
        }
        list.add(place);
    }
    private static void printMenu(){
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                Q)uit""");
    }

}
