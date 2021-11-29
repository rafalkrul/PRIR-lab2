public class M_Trapezow extends Thread{

    // Inicjalizacja zmiennych
    public double wynik;
    private double a;
    private double b;
    private double n;

    // Konstruktor
    public M_Trapezow(double a, double b, double n){
        this.a = a;
        this.b = b;
        this.n = n;
    }


    public static double wzorf(double x){ // Wzór funkji
        return (Math.sqrt(1.3*x + 0.2) / (Math.log(x + 1.1)));
    }


    public static double wysokosc(double a, double b, double n){
        return (b - a) / n;
    } // Obliczanie i zwracanie wysokości

    public static double pkt(double a, double b, double n){ // Obliczanie pktu

        double xi = 0;
        for(double i = 1; i < n; i++){
            xi += (wzorf(a + ((i / n) * (b - a))));
        }
        return xi;
    }
    public static double obliczenie(double a, double b, double n){ // Główne obliczenia

        double suma = 0;

        suma = wysokosc(a,b,n) * (wzorf(a) / 2 + pkt(a,b,n) + wzorf(b)/2);

        return suma;
    }
    public void run(){
        this.wynik = obliczenie(a,b,n);
    } // Przypięcie do wyniku sumy pojedzyńczego wątku


}
