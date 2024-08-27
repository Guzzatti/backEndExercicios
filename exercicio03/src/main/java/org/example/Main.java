public class Main {
    public static void main(String[] args) {
        Barco barco1 = new Barco("Barco 1", 2);
        Barco barco2 = new Barco("Barco 2", 5);
        Barco barco3 = new Barco("Barco 3", 7);
        Barco barco4 = new Barco("Barco 4", 12);
        Barco barco5 = new Barco("Barco 5", 20);

        Barco[] barcos = {barco1, barco2, barco3, barco4, barco5};

        PortoPequeno portoPequeno = new PortoPequeno("Porto Pequeno", 10);
        PortoGrande portoGrande = new PortoGrande("Porto Grande", 10);

        for (Barco barco : barcos) {
            if (!portoPequeno.atracarBarco(barco)) {
                portoGrande.atracarBarco(barco);
            }
        }
    }
}
