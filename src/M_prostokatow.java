public class M_prostokatow extends Thread{

    // Inicjalizacja zmiennych
    private double a;
    private double b;
    private double n;
    public double wynik;

    // Konstruktor
    public M_prostokatow(double a, double b, double n){
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public static double wzorf(double x){
        return (Math.sqrt(1.3*x + 0.2) / (Math.log(x + 1.1)));
    } // Wzór funkcji

    public static double obliczenia1(double a, double b, double n){ // Główne obliczenia oraz zwracanie sumy

        double suma = 0;
        double dx = (b - a) / n;
        for(int i = 1; i < n; i++){
            suma += wzorf(a + i * dx );
        }
        return  suma *= dx;
    }


    public void run(){
       this.wynik = obliczenia1(a,b,n);
    } // Przypięcie do wyniku sumy pojedyńczego wątku

}
