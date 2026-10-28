package Models;

public enum MenuOptionsEnum {
    RETIRAR(1),
    DEPOSITAR(2),
    CONSULTAR(3),
    SALIR(4),
    DESCONOCIDO(-1);

    public final int item;

    MenuOptionsEnum(int item) {
        this.item = item;
    }

    public static MenuOptionsEnum fromCodigo(int index) {
        for (MenuOptionsEnum opcion : values()){
            if(opcion.item == index){
                return opcion;
            }
        }

        return MenuOptionsEnum.DESCONOCIDO;
    }



}
