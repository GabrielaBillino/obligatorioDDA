package dominio;


public class CuentaCorriente {
    private double saldo;

   public CuentaCorriente() {
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void disminuirSaldo(double valorEstadia) {
        this.saldo -= valorEstadia;
    }

    public void setSaldo(double saldo) {
      this.saldo = saldo;
    }
}
