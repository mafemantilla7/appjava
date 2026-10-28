public class Cuentabancaria {

    private double saldo;
    private String titular;
    public static String regex_titular = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+(?: [A-Za-zÁÉÍÓÚáéíóúÑñÜü]+)*$";
    public static String regex_monto = "^[0-9]+(\\.[0-9]{1,2})?$";


    public Cuentabancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;

    }

    public void depositar(double monto) {

        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Se deposito ha sido exitoso. Se ha ingresado: " + monto);

        } else {
            System.out.println("Error, el deposito debe ser mayor a 0");
        }


        this.consultar();
    }

    public void retirar(double monto) {
        if (saldo > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            System.out.println("Retiro exitoso, se ha retirado:  $" + monto);
        } else {
            System.out.println("Saldo insuficiente");

        }

        this.consultar();
    }

    public double consultar() {
        System.out.println("Su saldo actual es de: $" + saldo);
        return saldo;

    }


}
