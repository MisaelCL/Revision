/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author khota
 */
public class GUI_Florero extends JFrame implements IInteraccion {

    private final JTextField idField = new JTextField(10);
    private final JTextField nombreField = new JTextField(20);
    private final JTextField precioField = new JTextField(10);
    private final JTextField existenciaField = new JTextField(10);
    private final JTextField colorField = new JTextField(10);
    private final JTextField largoField = new JTextField(10);
    private final JTextField materialField = new JTextField(15);
    private final JCheckBox activoCheck = new JCheckBox("Activo", true);
    private final JTextArea areaSalida = new JTextArea(12, 40);

    private IControlador controller;

    public GUI_Florero() {
        super("Gestión de floreros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(buildFormPanel(), BorderLayout.NORTH);
        add(buildButtonsPanel(), BorderLayout.CENTER);
        add(buildOutputPanel(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel buildFormPanel() {
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Datos del florero"));

        form.add(new JLabel("ID (para buscar/actualizar/eliminar):"));
        form.add(idField);
        form.add(new JLabel("Nombre:"));
        form.add(nombreField);
        form.add(new JLabel("Precio:"));
        form.add(precioField);
        form.add(new JLabel("Existencia:"));
        form.add(existenciaField);
        form.add(new JLabel("Color:"));
        form.add(colorField);
        form.add(new JLabel("Largo:"));
        form.add(largoField);
        form.add(new JLabel("Material:"));
        form.add(materialField);
        form.add(new JLabel());
        form.add(activoCheck);

        return form;
    }

    private JPanel buildButtonsPanel() {
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton registrarBtn = new JButton("Registrar");
        registrarBtn.addActionListener(ae -> {
            Florero florero = obtenerFlorero();
            if (florero != null) {
                controller.guardarFlorero(florero);
                limpiarCampos();
            }
        });

        JButton listarBtn = new JButton("Listar");
        listarBtn.addActionListener(ae -> controller.listarFlorero());

        JButton buscarBtn = new JButton("Buscar por ID");
        buscarBtn.addActionListener(ae -> obtenerId().ifPresent(controller::mostrarFlorero));

        JButton eliminarBtn = new JButton("Eliminar");
        eliminarBtn.addActionListener(ae -> obtenerId().ifPresent(controller::eliminarFlorero));

        JButton actualizarBtn = new JButton("Actualizar");
        actualizarBtn.addActionListener(ae -> {
            Florero florero = obtenerFlorero();
            if (florero != null) {
                controller.actualizarFlorero(florero);
            }
        });

        buttons.add(registrarBtn);
        buttons.add(actualizarBtn);
        buttons.add(listarBtn);
        buttons.add(buscarBtn);
        buttons.add(eliminarBtn);

        return buttons;
    }

    private JPanel buildOutputPanel() {
        JPanel output = new JPanel(new BorderLayout());
        areaSalida.setEditable(false);
        areaSalida.setLineWrap(true);
        areaSalida.setWrapStyleWord(true);
        output.setBorder(BorderFactory.createTitledBorder("Resultado"));
        output.add(new JScrollPane(areaSalida), BorderLayout.CENTER);
        return output;
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        precioField.setText("");
        existenciaField.setText("");
        colorField.setText("");
        largoField.setText("");
        materialField.setText("");
        activoCheck.setSelected(true);
    }

    private java.util.Optional<Long> obtenerId() {
        try {
            String textoId = idField.getText();
            if (textoId == null || textoId.isBlank()) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID válido", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                return java.util.Optional.empty();
            }
            return java.util.Optional.of(Long.parseLong(textoId));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser numérico", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return java.util.Optional.empty();
        }
    }

    @Override
    public Florero obtenerFlorero() {
        try {
            Florero florero = new Florero();
            String textoId = idField.getText();
            if (textoId != null && !textoId.isBlank()) {
                florero.setIdProducto(Long.parseLong(textoId));
            }
            florero.setNombre(nombreField.getText());
            florero.setPrecio(Double.parseDouble(precioField.getText()));
            florero.setExistencia(Integer.parseInt(existenciaField.getText()));
            florero.setColor(colorField.getText());
            florero.setLargo(Integer.parseInt(largoField.getText()));
            florero.setMaterial(materialField.getText());
            florero.setActivo(activoCheck.isSelected());
            return florero;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Verifique los campos numéricos (precio, existencia, largo)", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void mostrarP_Florero(Florero P_Florero) {
        if (Objects.isNull(P_Florero)) {
            areaSalida.setText("Florero no encontrado");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(P_Florero.getId()).append("\n")
                .append("Nombre = ").append(P_Florero.getNombre()).append("\n")
                .append("Color =").append(P_Florero.getColor()).append("\n")
                .append("Tamaño = ")
                .append(P_Florero.getLargo())
                .append("\n")
                .append("Material= ")
                .append(P_Florero.getMaterial())
                .append("\n")
                .append("Precio = ").append(P_Florero.getPrecio()).append("\n")
                .append("Existencia = ").append(P_Florero.getExistencia()).append("\n")
                .append("Activo = ").append(P_Florero.isActivo());

        areaSalida.setText(sb.toString());
        cargarEnFormulario(P_Florero);
    }

    private void cargarEnFormulario(Florero florero) {
        idField.setText(florero.getIdProducto() != null ? florero.getIdProducto().toString() : "");
        nombreField.setText(florero.getNombre());
        precioField.setText(String.valueOf(florero.getPrecio()));
        existenciaField.setText(String.valueOf(florero.getExistencia()));
        colorField.setText(florero.getColor());
        largoField.setText(String.valueOf(florero.getLargo()));
        materialField.setText(florero.getMaterial());
        activoCheck.setSelected(florero.isActivo());
    }

    @Override
    public void mostrarP_Floreros(List<Florero> productosFlorero) {
        if (productosFlorero == null || productosFlorero.isEmpty()) {
            areaSalida.setText("No hay floreros registrados");
            return;
        }
        String listado = productosFlorero.stream()
                .map(f -> String.format("[%d] %s - %s (%s) $%.2f x%d", f.getIdProducto(), f.getNombre(), f.getColor(), f.getMaterial(), f.getPrecio(), f.getExistencia()))
                .collect(Collectors.joining("\n"));
        areaSalida.setText(listado);
    }

    @Override
    public void setController(IControlador c) {
        this.controller = c;
    }
}