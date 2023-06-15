import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class FormComboBox extends JFrame implements ItemListener,ChangeListener{
    IngresarAlumno ingresarAlumno = new IngresarAlumno();
    private JPanel paneliz, panelde,  panelRadio, panelForm, panelContainer,panelButton;
    private JLabel nombre, apellidos, telefono, ine, listEstados ,estado;
    private JComboBox<String> estados;
    private JButton btnQuery,boton1;
    private JTextField text1, text2, text3, text4, text5;
    private JRadioButton radio1,radio2,radio3;
    private ButtonGroup buttonGroup;
    private static ArrayList<Alumno> lista = new ArrayList<>();
    EventClick eventClick = new EventClick();

    private static final String[] listaEstados = ListaEstados.listaEstados;

    public FormComboBox() {
        initControl();
        configFrame();
        setControl();
        configPanel();
        llenarCombo();
        add(panelContainer);
        estados.addItemListener(this);
        query();
        radio1.addChangeListener(this);
        radio2.addChangeListener(this);
        radio3.addChangeListener(this);

    }

    private void query(){
        btnQuery.addActionListener(e -> {
            FormList formList = new FormList();
            formList.setVisible(true);
            this.setVisible(false);
        });
    }

    private void initControl(){
        panelButton = new JPanel();
        paneliz = new JPanel();
        panelde = new JPanel();
        panelRadio = new JPanel();
        panelForm = new JPanel();
        panelContainer = new JPanel();
        nombre = new JLabel();
        apellidos = new JLabel();
        telefono = new JLabel();
        ine = new JLabel();
        estado = new JLabel();
        listEstados = new JLabel();
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        text5 = new JTextField();
        estados = new JComboBox<>();
        radio1 = new JRadioButton();
        radio2 = new JRadioButton();
        radio3 = new JRadioButton();
        boton1 = new JButton();
        btnQuery = new JButton();
        buttonGroup = new ButtonGroup();
    }

    private void configFrame(){
        setTitle("formulario.Formulario");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(450, 380);
    }

    private void setControl(){
        nombre.setText("Nombre:");
        apellidos.setText("Apellidos:");
        telefono.setText("Telefono:");
        ine.setText("INE");
        listEstados.setText("Lista Estados:");
        estado.setText("Estado:");
        radio1.setText("Deshabilita uno");
        radio2.setText("Deshabilita dos");
        radio3.setText("Deshabilita todo");
        boton1.setText("Aceptar");
        btnQuery.setText("Consultar");
    }



    private void configPanel(){



        paneliz.setLayout(new GridLayout(6, 0));
        paneliz.add(nombre);
        paneliz.add(apellidos);
        paneliz.add(telefono);
        paneliz.add(ine);
        paneliz.add(listEstados);
        paneliz.add(estado);

        panelde.setLayout(new GridLayout(6, 0));
        panelde.add(text1);
        panelde.add(text2);
        panelde.add(text3);
        panelde.add(text4);
        panelde.add(estados);
        panelde.add(text5);

        panelForm.setLayout(new GridLayout(1, 1));
        panelForm.setPreferredSize(new Dimension(380, 200));
        panelForm.add(paneliz);
        panelForm.add(panelde);

        panelRadio.setLayout(new FlowLayout());
        panelRadio.setPreferredSize(new Dimension(380, 50));
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        panelRadio.add(radio1);
        panelRadio.add(radio2);
        panelRadio.add(radio3);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(150, 50));
        panelButton.add(boton1);
        boton1.addActionListener(eventClick);
        panelButton.add(btnQuery);

        panelContainer.setLayout(new GridLayout(4, 0));
        panelContainer.add(panelForm);
        panelContainer.add(panelButton);
        panelContainer.add(panelRadio);

        add(panelContainer);
    }


    private void llenarCombo(){
        for (String s: listaEstados) {
            estados.addItem(s);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == estados){
            String item = (String) estados.getSelectedItem();
            text5.setText(item);
        }
    }

    public static ArrayList<Alumno> getElemento(){
        return lista;
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        if (radio1.isSelected()) {
            text1.setEnabled(false);
        }
        if (radio2.isSelected()) {
            text1.setEditable(false);
            text2.setEditable(false);
        }
        if (radio3.isSelected()) {
            text1.setEditable(false);
            text2.setEditable(false);
            text3.setEditable(false);
            text4.setEditable(false);
            text5.setEditable(false);
        }
    }


    public class EventClick implements ActionListener {
        public EventClick(){
            lista = new ArrayList<>();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = text1.getText();
            String apellidos = text2.getText();
            String telefono = text3.getText();
            String ine = text4.getText();
            String estado = text5.getText();

            lista.add(new Alumno(nombre,apellidos,telefono,ine,estado));

            ingresarAlumno.ingresar(ingresarAlumno.getAlumnos(),nombre,apellidos,telefono,ine,estado);

            text1.setText(" ");
            text2.setText(" ");
            text3.setText(" ");
            text4.setText(" ");
            text5.setText(" ");


        }
    }
}