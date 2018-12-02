public class Mnohocleny {
    public static void main(String[] args) {
        Mnohoclen clen1 = new Mnohoclen(7, 3, 0, 5, 2, 5);
        Mnohoclen clen2 = new Mnohoclen(5, 2, 1, 0, 0, 1);
        Mnohoclen mnohoclen = clen1.vynasobMnohoclen(clen2);

        System.out.printf("%s", mnohoclen);
        

    }
}