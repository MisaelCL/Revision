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
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author khota
 */
public class GUI_Producto extends JFrame implements IInteraccion {

    private static final String[] TIPOS = {"FLORERO", "FRASCO", "VELA", "TAZA", "CUADRO", "OTRO"};

    private final JTextField idField = new JTextField(10);
    private final JComboBox<String> tipoCombo = new JComboBox<>(TIPOS);
    private final JTextField nombreField = new JTextField(20);
    private final JTextField precioField = new JTextField(10);
    private final JTextField existenciaField = new JTextField(10);
    private final JTextField colorField = new JTextField(10);
    private final JTextField materialField = new JTextField(15);
    private final JTextField tamanioField = new JTextField(15);
    private final JTextField categoriaField = new JTextField(15);
    private final JCheckBox activoCheck = new JCheckBox("Activo", true);
    private final JTextArea areaSalida = new JTextArea(12, 50);

    private IControlador controller;

    public GUI_Producto() {
        super("Gestión de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(buildFormPanel(), BorderLayout.NORTH);
        add(buildButtonsPanel(), BorderLayout.CENTER);
        add(buildOutputPanel(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel buildFormPanel() {
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Datos del producto"));

        form.add(new JLabel("ID (para buscar/actualizar/eliminar):"));
        form.add(idField);

        form.add(new JLabel("Tipo:"));
        form.add(tipoCombo);

        form.add(new JLabel("Nombre:"));
        form.add(nombreField);

        form.add(new JLabel("Precio:"));
        form.add(precioField);

        form.add(new JLabel("Existencia:"));
        form.add(existenciaField);

        form.add(new JLabel("Color:"));
        form.add(colorField);

        form.add(new JLabel("Material:"));
        form.add(materialField);

        form.add(new JLabel("Tamaño:"));
        form.add(tamanioField);

        form.add(new JLabel("Categoría:"));
        form.add(categoriaField);

        form.add(new JLabel());
        form.add(activoCheck);

        return form;
    }

    private JPanel buildButtonsPanel() {
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(ae -> {
            Producto producto = obtenerProducto();
            if (producto != null) {
                controller.guardarProducto(producto);
                limpiarCampos();
            }
        });

        JButton actualizarBtn = new JButton("Actualizar");
        actualizarBtn.addActionListener(ae -> {
            Producto producto = obtenerProducto();
            if (producto != null) {
                controller.actualizarProducto(producto);
            }
        });

        JButton buscarBtn = new JButton("Buscar por ID");
        buscarBtn.addActionListener(ae -> obtenerId().ifPresent(controller::mostrarProducto));

        JButton eliminarBtn = new JButton("Eliminar");
        eliminarBtn.addActionListener(ae -> obtenerId().ifPresent(controller::eliminarProducto));

        JButton listarBtn = new JButton("Listar todos");
        listarBtn.addActionListener(ae -> controller.listarProductos());

        buttons.add(guardarBtn);
        buttons.add(actualizarBtn);
        buttons.add(buscarBtn);
        buttons.add(eliminarBtn);
        buttons.add(listarBtn);
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
        tipoCombo.setSelectedIndex(0);
        nombreField.setText("");
        precioField.setText("");
        existenciaField.setText("");
        colorField.setText("");
        materialField.setText("");
        tamanioField.setText("");
        categoriaField.setText("");
        activoCheck.setSelected(true);
    }

    private Optional<Long> obtenerId() {
        try {
            String textoId = idField.getText();
            if (textoId == null || textoId.isBlank()) {
                mostrarMensaje("Ingrese un ID válido");
                return Optional.empty();
            }
            return Optional.of(Long.parseLong(textoId));
        } catch (NumberFormatException e) {
            mostrarMensaje("El ID debe ser numérico");
            return Optional.empty();
        }
    }

    private void cargarEnFormulario(Producto producto) {
        idField.setText(producto.getId() != null ? producto.getId().toString() : "");
        tipoCombo.setSelectedItem(producto.getTipo());
        nombreField.setText(producto.getNombre());
        precioField.setText(String.valueOf(producto.getPrecio()));
        existenciaField.setText(String.valueOf(producto.getExistencia()));
        colorField.setText(producto.getColor());
        materialField.setText(producto.getMaterial());
        tamanioField.setText(producto.getTamanio());
        categoriaField.setText(producto.getCategoria());
        activoCheck.setSelected(producto.isActivo());
    }

    @Override
    public void setController(IControlador c) {
        this.controller = c;
    }

    @Override
    public void mostrarProducto(Producto producto) {
        if (Objects.isNull(producto)) {
            mostrarMensaje("Producto no encontrado");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(producto.getId()).append("\n")
                .append("Tipo = ").append(producto.getTipo()).append("\n")
                .append("Nombre = ").append(producto.getNombre()).append("\n")
                .append("Precio = ").append(producto.getPrecio()).append("\n")
                .append("Existencia = ").append(producto.getExistencia()).append("\n")
                .append("Color = ").append(producto.getColor()).append("\n")
                .append("Material = ").append(producto.getMaterial()).append("\n")
                .append("Tamaño = ").append(producto.getTamanio()).append("\n")
                .append("Categoría = ").append(producto.getCategoria()).append("\n")
                .append("Activo = ").append(producto.isActivo());

        areaSalida.setText(sb.toString());
        cargarEnFormulario(producto);
    }

    @Override
    public Producto obtenerProducto() {
        try {
            Producto producto = new Producto();
            obtenerId().ifPresent(producto::setId);
            producto.setTipo((String) tipoCombo.getSelectedItem());
            producto.setNombre(nombreField.getText());
            producto.setPrecio(Double.parseDouble(precioField.getText()));
            producto.setExistencia(Integer.parseInt(existenciaField.getText()));
            producto.setColor(colorField.getText());
            producto.setMaterial(materialField.getText());
            producto.setTamanio(tamanioField.getText());
            producto.setCategoria(categoriaField.getText());
            producto.setActivo(activoCheck.isSelected());
            return producto;
        } catch (NumberFormatException e) {
            mostrarMensaje("Verifique los campos numéricos (precio, existencia)");
            return null;
        }
    }

    @Override
    public void mostrarProductos(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            areaSalida.setText("No hay productos registrados");
            return;
        }
        String listado = productos.stream()
                .map(p -> String.format("[%d] %s - %s (%s) $%.2f x%d", p.getId(), p.getNombre(), p.getColor(), p.getMaterial(), p.getPrecio(), p.getExistencia()))
                .collect(Collectors.joining("\n"));
        areaSalida.setText(listado);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        areaSalida.setText(mensaje);
    }
}