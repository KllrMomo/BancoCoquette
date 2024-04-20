
package bankcoquette;

public class Solicitud {
    private String tipo; // "Deposito" o "Extraccion"
    private String numeroIdentidad;
    private double cantidad;
    private String nombre;
    private String apellidos;
    private String sexo;
    private String nacionalidad; // Se requiere solo si es extranjero
    private String direccion; // Se requiere solo si es extranjero
    private int numeroCuenta;

    public Solicitud(String tipo, String numeroIdentidad, double cantidad, String nombre, String apellidos, String sexo, String nacionalidad, String direccion, int numeroCuenta) {
        this.tipo = tipo;
        this.numeroIdentidad = numeroIdentidad;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.numeroCuenta = numeroCuenta;
    }
    
    //Getters
    public String getTipo() {return tipo;}
    public String getNumeroIdentidad () {return numeroIdentidad;}
    public double getCantidad () {return cantidad;}
    public String getNomnre () {return nombre;}
    public String getApellidos () {return apellidos;}
    public String getSexo () {return sexo;}
    public String getNacionalidad () {return nacionalidad;}
    public String getDireccion () {return direccion;}
    public int getNumeroCuenta () {return numeroCuenta;}
}
