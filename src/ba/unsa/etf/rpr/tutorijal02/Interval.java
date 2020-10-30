package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetnaTacka, krajnjaTacka;
    boolean daLiPocetnaPripada, dalikrajnjapripada;

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        daLiPocetnaPripada = false;
        dalikrajnjapripada = false;

    }

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean daLiPocetnaPripada, boolean daLiKrajnjaPripada) throws IllegalAccessException {
        if(pocetnaTacka > krajnjaTacka) throw new IllegalAccessException();
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.daLiPocetnaPripada = daLiPocetnaPripada;
        dalikrajnjapripada = daLiKrajnjaPripada;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public boolean isDaLiPocetnaPripada() {
        return daLiPocetnaPripada;
    }

    public boolean isDalikrajnjapripada() {
        return dalikrajnjapripada;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public void setDaLiPocetnaPripada(boolean daLiPocetnaPripada) {
        this.daLiPocetnaPripada = daLiPocetnaPripada;
    }

    public void setDalikrajnjapripada(boolean dalikrajnjapripada) {
        this.dalikrajnjapripada = dalikrajnjapripada;
    }

    public boolean isIn (double tacka) {
        return tacka >= pocetnaTacka && tacka <= krajnjaTacka;
    }

    public boolean isNull () {
        return !(pocetnaTacka - krajnjaTacka == 0);
    }

    public Interval intersect (Interval i) throws IllegalAccessException {
        Interval vratiInterval = new Interval();
        if(i.pocetnaTacka > this.krajnjaTacka || this.pocetnaTacka > i.krajnjaTacka) return vratiInterval;
        if(i.pocetnaTacka > this.pocetnaTacka) {
            vratiInterval.setPocetnaTacka(i.pocetnaTacka);
            vratiInterval.setDaLiPocetnaPripada(i.daLiPocetnaPripada && this.daLiPocetnaPripada);
        }
        if(i.krajnjaTacka > this.krajnjaTacka) {
            vratiInterval.setKrajnjaTacka(i.krajnjaTacka);
            vratiInterval.setDalikrajnjapripada(i.dalikrajnjapripada && this.dalikrajnjapripada);
        }
        if(i.pocetnaTacka < this.pocetnaTacka) {
            vratiInterval.setPocetnaTacka(this.pocetnaTacka);
            vratiInterval.setDaLiPocetnaPripada(i.daLiPocetnaPripada && this.daLiPocetnaPripada);
        }
        if(i.krajnjaTacka < this.krajnjaTacka) {
            vratiInterval.setKrajnjaTacka(this.krajnjaTacka);
            vratiInterval.setDalikrajnjapripada(i.dalikrajnjapripada && this.dalikrajnjapripada);
        }
        return vratiInterval;
    }

    public static Interval intersect (Interval i1, Interval i2) throws IllegalAccessException {
        return i1.intersect(i2);
    }

    @Override
    public String toString() {
        String s = "";
        if(daLiPocetnaPripada) s = s + "[";
        else s = s + "(";
        if(pocetnaTacka == krajnjaTacka && dalikrajnjapripada && daLiPocetnaPripada)
            s = s + pocetnaTacka + ", " + krajnjaTacka;
        if(dalikrajnjapripada) s = s + "]";
        else s = s + ")";

        return s;
    }

    @Override
    public boolean equals(Object obj) {
        return this.pocetnaTacka == ((Interval)obj).pocetnaTacka && this.krajnjaTacka == ((Interval)obj).krajnjaTacka
                && this.dalikrajnjapripada == ((Interval)obj).dalikrajnjapripada &&
                this.daLiPocetnaPripada == ((Interval)obj).dalikrajnjapripada;
    }
}

