/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author ACER
 */
public class Estudiante {
    private String codigo;
    private String nombre;
    private String apellidos;
    private String facultad;
    private int edad;
    private String provincia;

    // Métodos getter y setter

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (esSoloLetras(nombre)) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre solo debe contener letras.");
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (esSoloLetras(apellidos)) {
            this.apellidos = apellidos;
        } else {
            throw new IllegalArgumentException("Los apellidos solo deben contener letras.");
        }
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    // Constructor sin parámetros
    public Estudiante() {
    }

    // Constructor con parámetros
    public Estudiante(String codigo, String nombre, String apellidos, String facultad, int edad, String provincia) {
        this.codigo = codigo;

        // Validar que nombre y apellidos solo contengan letras
        if (esSoloLetras(nombre)) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre solo debe contener letras.");
        }

        if (esSoloLetras(apellidos)) {
            this.apellidos = apellidos;
        } else {
            throw new IllegalArgumentException("Los apellidos solo deben contener letras.");
        }

        this.facultad = facultad;
        this.edad = edad;
        this.provincia = provincia;
    }

    // Método auxiliar para verificar si una cadena solo contiene letras
    private boolean esSoloLetras(String texto) {
        return texto != null && texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    // Método toString para imprimir el objeto
    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", facultad=" + facultad + ", edad=" + edad + ", provincia=" + provincia + '}';
    }
}
