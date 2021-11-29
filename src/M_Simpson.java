public class M_Simpson extends Thread{
    // Inicjalizacja zmiennych
    private double a;
    private double b;
    private double n;
    double wynik;

    // Konstruktor
    public M_Simpson(double a, double b, double n){
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public static double wzorf(double x){
        return (Math.sqrt(1.3*x + 0.2) / (Math.log(x + 1.1)));
    } // Wzór funkcji

    public static double wysokosc2(double a, double b, double n){ // Wzór wysokości
        return ((a + ((2 / n) * (b - a))) - (a + ((1 / n) * (b - a)))) / 2;
    }

    public static double pkty(double a, double b, double n){ // Obliczanie potrzebnych punktów
        double xi = 0;

        for(double i = 1; i < n; i++){
            xi += 2 * (wzorf(a +((i / n) * (b - a))));
        }
        return xi;
    }

    public static double pkty1(double a, double b, double n){ // Obliczanie potrzebnych punktów
        double ti = 0;
        for(int i = 0; i < n; i++){
            ti += 4 * (wzorf(((a + (((i + 1) / n) * (b - a))) + (a + ((i /n) * (b - a))))/2));
        }
        return ti;
    }

    public static double obliczenia(double a, double b, double n){ //Główne wyliczenia + zwracanie wyniku sumy poszczególnych przedziałów
        double suma = 0;
        suma = (wysokosc2(a,b,n)/3) * (wzorf(a) + pkty(a,b,n) + pkty1(a,b,n) + wzorf(b));

        return suma;

    }
    public void run(){
      this.wynik =  obliczenia(a,b,n); //Zwrócenie wyniku
    }


}
