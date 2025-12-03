/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
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
public class GUI_Producto extends JFrame implements IInteraccion {

    private static final String TIPO_FLORERO = "FLORERO";

    private final JTextField idField = new JTextField(10);
    private final JTextField nombreField = new JTextField(20);
    private final JTextField precioField = new JTextField(10);
    private final JTextField existenciaField = new JTextField(10);
    private final JTextField colorField = new JTextField(10);
    private final JTextField largoField = new JTextField(10);
    private final JTextField materialField = new JTextField(15);
    private final JTextField tipoField = new JTextField(15);
    private final JCheckBox activoCheck = new JCheckBox("Activo", true);
    private final JTextArea areaSalida = new JTextArea(12, 40);

    private IControlador controller;

    public GUI_Producto() {
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
        form.add(new JLabel("Tipo:"));
        form.add(tipoField);
        form.add(new JLabel());
        form.add(activoCheck);

        return form;
    }

    private JPanel buildButtonsPanel() {
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton registrarBtn = new JButton("Registrar");
        registrarBtn.addActionListener(ae -> {
            Producto producto = obtenerProducto();
            if (producto != null) {
                controller.guardarProducto(producto);
                limpiarCampos();
            }
        });

        JButton listarBtn = new JButton("Listar");
        listarBtn.addActionListener(ae -> controller.listarProductos());

        JButton buscarBtn = new JButton("Buscar por ID");
        buscarBtn.addActionListener(ae -> obtenerId().ifPresent(controller::mostrarProducto));

        JButton eliminarBtn = new JButton("Eliminar");
        eliminarBtn.addActionListener(ae -> obtenerId().ifPresent(controller::eliminarProducto));

        JButton actualizarBtn = new JButton("Actualizar");
        actualizarBtn.addActionListener(ae -> {
            Producto producto = obtenerProducto();
            if (producto != null) {
                controller.actualizarProducto(producto);
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
        tipoField.setText("");
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


    private void cargarEnFormulario(Producto producto) {
        idField.setText(producto.getIdProducto() != null ? producto.getIdProducto().toString() : "");
        nombreField.setText(producto.getNombre());
        precioField.setText(String.valueOf(producto.getPrecio()));
        existenciaField.setText(String.valueOf(producto.getExistencia()));
        colorField.setText(producto.getColor());
        largoField.setText(producto.getLargo() != null ? String.valueOf(producto.getLargo()) : "");
        materialField.setText(producto.getMaterial());
        tipoField.setText(producto.getTipo());
        activoCheck.setSelected(producto.isActivo());
    }

    @Override
    public void setController(IControlador c) {
        this.controller = c;
    }

    @Override
    public void mostrar_Producto(Producto producto) {
        if (Objects.isNull(producto)) {
            areaSalida.setText("Producto no encontrado");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(producto.getId()).append("\n")
                .append("Nombre = ").append(producto.getNombre()).append("\n")
                .append("Tipo Producto =").append(producto.getTipoProducto()).append("\n")
                .append("Color =").append(producto.getColor()).append("\n")
                .append("Tamaño = ")
                .append(producto.getLargo())
                .append("\n")
                .append("Material= ")
                .append(producto.getMaterial())
                .append("\n")
                .append("Tipo Detalle= ")
                .append(producto.getTipo())
                .append("\n")
                .append("Precio = ").append(producto.getPrecio()).append("\n")
                .append("Existencia = ").append(producto.getExistencia()).append("\n")
                .append("Activo = ").append(producto.isActivo());

        areaSalida.setText(sb.toString());
        cargarEnFormulario(producto);
    }

    @Override
    public Producto obtenerProducto() {
       try {
            Producto producto = new Producto();
            producto.setTipoProducto(TIPO_FLORERO);
            String textoId = idField.getText();
            if (textoId != null && !textoId.isBlank()) {
                producto.setIdProducto(Long.parseLong(textoId));
            }
            producto.setNombre(nombreField.getText());
            producto.setPrecio(Double.parseDouble(precioField.getText()));
            producto.setExistencia(Integer.parseInt(existenciaField.getText()));
            producto.setColor(colorField.getText());
            producto.setLargo(Integer.parseInt(largoField.getText()));
            producto.setMaterial(materialField.getText());
            producto.setTipo(tipoField.getText());
            producto.setActivo(activoCheck.isSelected());
            return producto;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Verifique los campos numéricos (precio, existencia, largo)", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void mostrar_Productos(List<Producto> productosFlorero) {
        if (productosFlorero == null || productosFlorero.isEmpty()) {
            areaSalida.setText("No hay floreros registrados");
            return;
        }
        String listado = productosFlorero.stream()
                .map(f -> String.format("[%d] %s - %s (%s) $%.2f x%d", f.getIdProducto(), f.getNombre(), f.getColor(), f.getMaterial(), f.getPrecio(), f.getExistencia()))
                .collect(Collectors.joining("\n"));
        areaSalida.setText(listado);
    }
}