/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER 17
 */
public class GestorEstudiante {
    private ArrayList<Estudiante> listaEstudiante;
    private DefaultTableModel modelo;

    // Constructor que acepta DefaultTableModel
    public GestorEstudiante(DefaultTableModel modelo) {
        this.listaEstudiante = new ArrayList<>();
        this.modelo = modelo;
    }

    public void agregarEstudiante(Estudiante estudiante, Date fechaNacimiento) {
        if (listaEstudiante.size() >= 5) {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más de 5 estudiantes.");
            return;
        }

        // Validar que solo se ingresen letras en el nombre y apellidos
        if (!esSoloLetras(estudiante.getNombre()) || !esSoloLetras(estudiante.getApellidos())) {
            JOptionPane.showMessageDialog(null, "El nombre y los apellidos solo deben contener letras.");
            return;
        }

        // Calcular la edad basada en la fecha de nacimiento
        int edad = calcularEdad(fechaNacimiento);
        estudiante.setEdad(edad);  // Asigna la edad calculada

        listaEstudiante.add(estudiante);
        actualizarTabla(); // Actualizar la tabla al agregar un estudiante
    }

    // Método para calcular la edad en función de la fecha de nacimiento
    public int calcularEdad(Date fechaNacimiento) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaNacimiento);
        int añoNacimiento = cal.get(Calendar.YEAR);
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        return añoActual - añoNacimiento;
    }

    public void actualizarTabla() {
        // Limpiar la tabla actual
        modelo.setRowCount(0);

        // Agregar todos los estudiantes a la tabla
        for (Estudiante e : listaEstudiante) {
            modelo.addRow(new Object[]{e.getCodigo(), e.getNombre(), e.getApellidos(), e.getFacultad(), e.getEdad(), e.getProvincia()});
        }
    }

    // Método para limpiar los campos del formulario
    public void limpiar(javax.swing.JTextField txtCodigo, javax.swing.JTextField txtNombre,
                                  javax.swing.JTextField txtApellido, javax.swing.JComboBox<String> cboFacultad,
                                  javax.swing.JComboBox<String> cboProvincia, com.toedter.calendar.JCalendar calendario) {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cboFacultad.setSelectedIndex(-1);
        cboProvincia.setSelectedIndex(-1);
        calendario.setDate(null);
    }
    
    public void eliminarEstudiante(String codigo) {
        // Eliminar el estudiante de la lista
        listaEstudiante.removeIf(e -> e.getCodigo().equals(codigo));
    }

   public void buscarPorNombre(String nombre) {
    // Limpiar la tabla actual
    modelo.setRowCount(0);

    // Filtrar la lista por nombre y agregar los resultados a la tabla
    for (Estudiante e : listaEstudiante) {
        if (e.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
            modelo.addRow(new Object[]{e.getCodigo(), e.getNombre(), e.getApellidos(), e.getFacultad(), e.getEdad(), e.getProvincia()});
        }
    }
}
   
   public void eliminarTodosEstudiantes() {
        listaEstudiante.clear();
        JOptionPane.showMessageDialog(null, "Todos los estudiantes han sido eliminados.");
        actualizarTabla(); // Actualizar la tabla después de eliminar todos
        }
   
   public void verificarListaVacia() {
    if (listaEstudiante.isEmpty()) {
        JOptionPane.showMessageDialog(null, "La lista de estudiantes está vacía.");
    } else {
        JOptionPane.showMessageDialog(null, "La lista de estudiantes tiene " + listaEstudiante.size() + " estudiante(s).");
    }
}

    // Método auxiliar para verificar si una cadena solo contiene letras
    private boolean esSoloLetras(String texto) {
        return texto != null && texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    
    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiante;
    }
}
