import Models.MenuOptionsEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static Models.MenuOptionsEnum.*;

public class Main {

    private static Cuentabancaria _cuenta;

    public static void main(String[] args) throws SQLException {


        try (Connection conexion = ConexionBD.conectar()) {
            if (conexion != null) {
                System.out.println("¡La conexión funciona correctamente!");
            }
        }


        MenuOptionsEnum option;
        Scanner valor_obtenido = new Scanner(System.in);

        CrearCuentaBancaria();

        do {
            System.out.println("Seleccione una option");
            System.out.println("1. Retirar");
            System.out.println("2. Depositar");
            System.out.println("3. Consultar");
            System.out.println("4. Salir");

            option = MenuOptionsEnum.fromCodigo(valor_obtenido.nextInt());

            if (option == null) {
                System.out.println("option invalida");
                continue;

            }


            switch (option) {
                case RETIRAR:
                    System.out.println("Ingrese el valor a retirar");
                    _cuenta.retirar(valor_obtenido.nextDouble());
                    break;

                case DEPOSITAR:
                    System.out.println("Ingrese el valor a depositar");
                    _cuenta.depositar(valor_obtenido.nextDouble());
                    break;

                case CONSULTAR:
                    _cuenta.consultar();
                    break;

                case SALIR:
                    System.out.println("Adios");
                    break;


            }


        } while (option != SALIR);
        valor_obtenido.close();

    }

    public static void CrearCuentaBancaria() {
        String titular = "";
        double saldo = -1;

        Scanner valor_obtenido = new Scanner(System.in);


        while (titular.isEmpty()) {
            System.out.println("Ingrese el nombre del titular");
            String entrada = valor_obtenido.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Debes ingresar el nombre del titular");


            } else if (!entrada.matches(_cuenta.regex_titular)) {
                System.out.println("El nombre solo puede contener letras");

            } else {
                titular = entrada.toLowerCase();
            }

        }


        while (saldo < 0) {
            System.out.println("Ingrese el saldo inicial: $");
            String entrada = valor_obtenido.nextLine().trim();

            if (!entrada.matches(_cuenta.regex_monto)) {
                System.out.println("El monto solo puede contener numeros y puntos para los decimales");

            } else {
                saldo = Double.parseDouble(entrada);
            }


        }

        _cuenta = new Cuentabancaria(titular, saldo);


    }
}