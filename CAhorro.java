
package bankcoquette;

public class CAhorro {
    private int numID;
    private double saldo;
    private int numCuenta;
    
    public CAhorro (int numID, double saldo) {
        this.numID = numID;
        this.saldo = saldo;
        //Numero de cuenta se crea al crear una cuenta
    }
    
    //Getters y Setters
    
    public int getNumID() {
        return numID;
    }
    
    public void setNumID (int numID) {
        this.numID = numID;
    }
    
    public double getSaldo () {
        return saldo;
    }
    
    public void setSaldo (double saldo) {
        this.saldo = saldo;
    }
    
    public int getNumeroCuenta() {
        return numCuenta;
    }

    public void setNumeroCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }
    
    //Metodo para depositar en la cuenta
    public void depositar (double cantidad) {
        saldo += cantidad;
    }   
    
    //Metodo para retirar dinero de la cuenta
    public void reitrar (double cantidad) {
        if (cantidad <= saldo ) {
            saldo -= cantidad;
            System.out.println("Extraccion exitosa. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro");
        }
    }
}
