public class Nasobky {
    public static void main (String[] args){
        int x, y = 0;

        for(int i = 0; i <= 10; i++){
            x = i * 3;
            
            //Vylepseni
            y++;
            if(y < 4) {
                System.out.printf("%d ", x);
            } else {
                System.out.printf("%d\n", x);
                y = 0;
            }
        }
    }
}