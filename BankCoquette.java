
package bankcoquette;

import javax.swing.JOptionPane;

public class BankCoquette {
    ListaSE<CAhorro> cuentas;
    ListaSE<Solicitud> solicitudes;
    
    public BankCoquette() {
        this.cuentas = new ListaSE<>();
        this.solicitudes = new ListaSE<>();
    }
    
    public void agregarCuenta (CAhorro cuenta) {
        cuentas.Adiconar(cuenta);
    }
    
    public double consultarSaldo(String numeroIDentidad, int numeroCuenta) {
        for (int i = 0; i < cuentas.Longitud(); i++) {
            CAhorro cuenta = cuentas.Obtener(i);
            if (cuenta.getNumID() == numeroIDentidad) {
                if (cuenta.getNumeroCuenta() == numeroCuenta) {
                    return cuenta.getSaldo();
                }
            }
        }
        return -1;
    }
    
    //Verificar cuenta y ver su posicion
    public int VerificarCuenta() {
        if (solicitudes.EsVacia()) {
            JOptionPane.showMessageDialog(null, "No hay solicitudes en espera");
            return -1; //No hay solicitud en espera
        }
        
        Solicitud solicitud = solicitudes.Obtener(0);
        int pCuenta = cuentas.BuscarCuenta(solicitud.getNumeroIdentidad());
        
        if (pCuenta == -1) {
            System.out.println("La cuenta esta en la posicion: " + pCuenta);
            return pCuenta;
        } else {
            //Crear cuenta
            CAhorro nuevaCuenta = new CAhorro(solicitud.getNumeroIdentidad(), 0);
            cuentas.Adiconar(nuevaCuenta);
            return cuentas.Longitud() - 1; //Posicion de cuenta nueva
        }
    }
    
    public void atenderSolicitud (Solicitud solicitud) {
        boolean clienteValido = false;
        CAhorro cuenta = buscarCuenta(solicitud.getNumeroIdentidad(), solicitud.getNumeroCuenta());
        if (cuenta != null) {
            clienteValido = true;
            
            if (solicitud.getTipo() == "Deposito") {
                cuenta.setSaldo(cuenta.getSaldo() + solicitud.getCantidad());
                System.out.println("Deposito realizado correctamtne. Nuevo saldo: " + cuenta.getSaldo());
            } else if (solicitud.getTipo() == "Extraccion") {
                if (cuenta.getSaldo() >= solicitud.getCantidad()) {
                    cuenta.setSaldo(cuenta.getSaldo() - solicitud.getCantidad());
                    System.out.println("Extraccion realizada correctamente. Nuevo saldo: " + cuenta.getSaldo());
                } else {
                    System.out.println("Saldo insuficiente para realizar extraccion.");
                }
            }
        } else {
        System.out.println("Cliente no encontrado o numero de cuenta incorrecto");
        }
    }
    
    //Da de baja a las cuentas con saldo mayor a un millon pesos
    public ListaSE<CAhorro> DarBajaAMillonarios() {
        ListaSE<CAhorro> cuentasMillonarias = new ListaSE<>();
        for (int i = 0; i < cuentas.Longitud(); i++) {
            CAhorro cuenta = cuentasMillonarias.Obtener(i);
            if (cuenta.getSaldo() > 1000000) {
                cuentasMillonarias.Adiconar(cuenta);
                cuentas.Eliminar(i);
                i--; //Revisa la posicion despues de eliminar la cuneta
            }
        }
        return cuentasMillonarias;
    }
    
    //Cambiar de dinero extranjero a pesos
    public void cambioDivisas (double cantidad, String numID, String tipoDivisa) {
        double cantidadPesos = cantidad * 20;
        CAhorro cuentaCliente = null;
        for (int i = 0; i < cuentas.Longitud(); i++) {
            CAhorro cuenta = cuentas.Obtener(i);
            if (cuenta.getNumID() == numID) {
                cuentaCliente = cuenta;
                break;
            }
        }
        //Si se encuentra realizar deposito
        if (cuentaCliente != null) {
            cuentaCliente.setSaldo(cuentaCliente.getSaldo() + cantidadPesos);
            System.out.println("Se ha realizado el cambia de divisas y se ha depositado correctamente");
        } else {
            System.out.println("No se encontro la cuenta del ");
        }
    }

    // Método para buscar una cuenta en la lista de cuentas del banco
    private CAhorro buscarCuenta(String numeroIdentidad, int numeroCuenta) {
        for (int i = 0; i < cuentas.Longitud();  i++) {
            CAhorro cuenta = cuentas.Obtener(i);
            if (cuenta.getNumID() == numeroIdentidad) {
                if (cuenta.getNumeroCuenta() == numeroCuenta) {
                    return cuenta;
                }
            }
        }
        return null;
    }
}