public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Inicjalizacja końcowych wyników
        double wynik_s = 0;
            double wynik_t = 0;
            double wynik_p = 0;


            // Tworzenie obiektów z przediału 0-1
        for(double i = 0.4; i <= 1; i += 0.3){
            M_Simpson simpson = new M_Simpson(i - 0.3,i,1000);
            M_Trapezow trapezy = new M_Trapezow(i - 0.3,i,1000);
            M_prostokatow prostokatow = new M_prostokatow(i - 0.3,i,1000);

            //Metody run
            simpson.run();
            trapezy.run();
            prostokatow.run();

            // Dopisanie do sumy wyniku każdego wątku
            wynik_s += simpson.wynik;
            wynik_t += trapezy.wynik;
            wynik_p += prostokatow.wynik;

        }
        // Wypisanie sum
        System.out.println("Wynik simpsona " +wynik_s);
        System.out.println("Wynik trapzeow " + wynik_t);
        System.out.println("Wynik prostokatow " + wynik_p);
    }
}
