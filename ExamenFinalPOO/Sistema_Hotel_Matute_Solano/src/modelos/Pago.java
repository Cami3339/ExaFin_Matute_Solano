// Paquete donde se agrupan las clases e interfaces del modelo
package modelos;

// Interfaz que define el contrato para el cálculo de pagos o totales
public interface Pago {
    // Método que debe implementar cualquier clase que maneje pagos
    // Debe retornar el total calculado como un valor double
    double calcularTotal();
}
