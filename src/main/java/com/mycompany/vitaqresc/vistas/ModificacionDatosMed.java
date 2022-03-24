package com.mycompany.vitaqresc.vistas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.vitaqresc.controladores.RestManager;
import com.mycompany.vitaqresc.models.AlergiasLista;
import com.mycompany.vitaqresc.models.HistorialAlergias;
import com.mycompany.vitaqresc.models.HistorialMedicamentos;
import com.mycompany.vitaqresc.models.HistorialPadecimientos;
import com.mycompany.vitaqresc.models.InfoDoctor;
import com.mycompany.vitaqresc.models.ListaPacientes;
import com.mycompany.vitaqresc.models.MedicamentosLista;
import com.mycompany.vitaqresc.models.PadecimientosLista;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author axlku
 */
public class ModificacionDatosMed extends javax.swing.JFrame implements Runnable {

    public static int indicePaciente = 0;
    public int banderaPrincipalInicio = 0;

    public int indiceAlergiaAEditar = 0;
    public int indicePadecimientoAEditar = 0;
    public int indiceMedicamentoAEditar = 0;

    PadecimientosLista HistorialPadecimientos;
    AlergiasLista HistorialAlergias;
    MedicamentosLista HistorialMedicamentos;
    ListaPacientes listaPacientes;

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            return false;
        }
    };
    DefaultTableModel modelo1 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            return false;
        }
    };
    DefaultTableModel modelo2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            return false;
        }
    };

    SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public ModificacionDatosMed() {
        initComponents();
        ocultarCampos();
        desactivarBotones();
        this.modelo = (DefaultTableModel) tablaPadecimientos.getModel();
        this.modelo1 = (DefaultTableModel) tablaAlergias.getModel();
        this.modelo2 = (DefaultTableModel) tablaMedicamentos.getModel();
        btnGuardar.setVisible(false);
        txtMedico.setText(new InfoDoctor().getNombreCompleto());
        txtCargo.setText(new InfoDoctor().getCargo());
        txtEspecialidad.setText(new InfoDoctor().getEspecialidad());
        txtDependencia.setText(new InfoDoctor().getDependencia());
        txtClinica.setText(new InfoDoctor().getClinicaBase());
        txtConsultorio.setText(new InfoDoctor().getConsultorio());
        txtModalidad.setText(new InfoDoctor().getModalidadtrabajo());
        txtCedula.setText(new InfoDoctor().getModalidadtrabajo());
    }

    private void getComponents(Container c) {

        Component[] m = c.getComponents();

        for (int i = 0; i < m.length; i++) {

            if (m[i].getClass().getName() == "javax.swing.JPanel") {
                m[i].setBackground(Color.green);
            }

            if (c.getClass().isInstance(m[i]));
            getComponents((Container) m[i]);
        }
    }

    private void getComponents2(Container d) {

        Component[] n = d.getComponents();

        for (int i = 0; i < n.length; i++) {

            if (n[i].getClass().getName() == "javax.swing.JPanel") {
                n[i].setBackground(Color.red);
            }

            if (d.getClass().isInstance(n[i]));
            getComponents2((Container) n[i]);
        }
    }

    private void ocultarCampos() {
        txtPadecimiento.setEnabled(false);
        txtGravedad.setEnabled(false);
        txtCausa.setEnabled(false);
        fechaDiagnosticoP.setEnabled(false);
        txtAlergia.setEnabled(false);
        txtReaccion.setEnabled(false);
        fechaDiagnosticoP.setEnabled(false);
        txtSintomas.setEnabled(false);
        txtMedicamento.setEnabled(false);
        txtDosis.setEnabled(false);
        txtFrecuencia.setEnabled(false);
        fechaInicioM.setEnabled(false);
        txtMedico.setEnabled(false);
        txtCargo.setEnabled(false);
        txtEspecialidad.setEnabled(false);
        txtDependencia.setEnabled(false);
        txtClinica.setEnabled(false);
        txtConsultorio.setEnabled(false);
        txtModalidad.setEnabled(false);
        txtCedula.setEnabled(false);
//        txtDireccion.setEnabled(false);
        fechaDiagnosticoA.setEnabled(false);
    }

    private void activarCamposMed() {
        txtMedico.setEnabled(true);
        txtCargo.setEnabled(true);
        txtEspecialidad.setEnabled(true);
        txtDependencia.setEnabled(true);
        txtClinica.setEnabled(true);
        txtConsultorio.setEnabled(true);
        txtModalidad.setEnabled(true);
        txtCedula.setEnabled(true);
        //    txtDireccion.setEnabled(true);
    }

    private void ocultarCamposMed() {
        txtMedico.setEnabled(false);
        txtCargo.setEnabled(false);
        txtEspecialidad.setEnabled(false);
        txtDependencia.setEnabled(false);
        txtClinica.setEnabled(false);
        txtConsultorio.setEnabled(false);
        txtModalidad.setEnabled(false);
        txtCedula.setEnabled(false);
//        txtDireccion.setEnabled(false);
    }

    private void activarCamposPad() {
        txtPadecimiento.setEnabled(true);
        txtGravedad.setEnabled(true);
        txtCausa.setEnabled(true);
        fechaDiagnosticoP.setEnabled(true);
    }

    private void activarCamposAl() {
        txtAlergia.setEnabled(true);
        txtSintomas.setEnabled(true);
        txtReaccion.setEnabled(true);
        fechaDiagnosticoA.setEnabled(true);
    }

    private void activarCamposM() {
        txtMedicamento.setEnabled(true);
        txtDosis.setEnabled(true);
        txtFrecuencia.setEnabled(true);
        fechaInicioM.setEnabled(true);
    }

    private void limpiarCajasPad() {
        txtPadecimiento.setText("");
        txtGravedad.setText("");
        txtCausa.setText("");
        fechaDiagnosticoP.setCalendar(null);
    }

    private void limpiarCajasAl() {
        txtAlergia.setText("");
        txtReaccion.setText("");
        txtSintomas.setText("");
        fechaDiagnosticoA.setCalendar(null);
    }

    private void limpiarCajasM() {
        txtMedicamento.setText("");
        txtDosis.setText("");
        txtFrecuencia.setText("");
        fechaInicioM.setCalendar(null);
    }

    private void desactivarAl() {
        txtAlergia.setEnabled(false);
        txtReaccion.setEnabled(false);
        txtSintomas.setEnabled(false);
        fechaDiagnosticoP.setEnabled(false);
    }

    private void desactivarPad() {
        txtPadecimiento.setEnabled(false);
        txtGravedad.setEnabled(false);
        txtCausa.setEnabled(false);
        fechaDiagnosticoP.setEnabled(false);
    }

    private void desactivarM() {
        txtMedicamento.setEnabled(false);
        txtDosis.setEnabled(false);
        txtFrecuencia.setEnabled(false);
        fechaInicioM.setEnabled(false);
    }

    private void activarCampos() {
        txtPadecimiento.setEnabled(true);
        txtGravedad.setEnabled(true);
        txtCausa.setEnabled(true);
        fechaDiagnosticoP.setEnabled(true);
        txtAlergia.setEnabled(true);
        txtSintomas.setEnabled(true);
        txtReaccion.setEnabled(true);
        fechaDiagnosticoP.setEnabled(true);
        txtMedicamento.setEnabled(true);
        txtDosis.setEnabled(true);
        txtFrecuencia.setEnabled(true);
        txtMedico.setEnabled(true);
        txtCargo.setEnabled(true);
        txtEspecialidad.setEnabled(true);
        txtDependencia.setEnabled(true);
        txtClinica.setEnabled(true);
        txtConsultorio.setEnabled(true);
        txtModalidad.setEnabled(true);
        txtCedula.setEnabled(true);
        // txtDireccion.setEnabled(true);
    }

    private void limpiarCajas() {
        txtPadecimiento.setText("");
        txtGravedad.setText("");
        txtCausa.setText("");
        fechaDiagnosticoP.setCalendar(null);
        txtAlergia.setText("");
        txtReaccion.setText("");
        fechaDiagnosticoP.setCalendar(null);
        txtSintomas.setText("");
        txtMedicamento.setText("");
        txtDosis.setText("");
        txtFrecuencia.setText("");
    }

    private void desactivarBotones() {
        btnAgregarPadecimiento.setEnabled(false);
        btnAgregarAlergia.setEnabled(false);
        btnAñadirM.setEnabled(false);
        btnEliminarAl.setEnabled(false);
        btnEliminarPad.setEnabled(false);
        btnEliminarMed.setEnabled(false);
        tablaAlergias.setEnabled(false);
        tablaMedicamentos.setEnabled(false);
        tablaPadecimientos.setEnabled(false);
        btnGuardar.setEnabled(false);
        //btnEditar.setEnabled(false);
    }

    private void activarBotones() {
        btnAgregarPadecimiento.setEnabled(true);
        btnAgregarAlergia.setEnabled(true);
        btnAñadirM.setEnabled(true);
        btnEliminarAl.setEnabled(true);
        btnEliminarPad.setEnabled(true);
        btnEliminarMed.setEnabled(true);
        tablaAlergias.setEnabled(true);
        tablaMedicamentos.setEnabled(true);
        tablaPadecimientos.setEnabled(true);
        //btnEditar.setEnabled(true);
        btnGuardar.setEnabled(true);
    }

    public void cargarPadecimientos() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonListaPadecimientos = RestManager
                    .getInstance()
                    .obtenerListaPadecimientos(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim());
            String jsonListaAlergias = RestManager
                    .getInstance()
                    .obtenerListaAlergias(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim());
            String jsonListaMedicamentos = RestManager
                    .getInstance()
                    .obtenerListaMedicamentos(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim());

            if (!"Not Found".equals(jsonListaPadecimientos)) {
                System.out.println(jsonListaPadecimientos);
                HistorialPadecimientos = objectMapper.readValue(jsonListaPadecimientos, PadecimientosLista.class);
            }

            if (!"Not Found".equals(jsonListaAlergias)) {
                HistorialAlergias = objectMapper.readValue(jsonListaAlergias, AlergiasLista.class);
            }
            if (!"Not Found".equals(jsonListaMedicamentos)) {
                HistorialMedicamentos = objectMapper.readValue(jsonListaMedicamentos, MedicamentosLista.class);
            }
            long start2 = System.currentTimeMillis();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean done = false;
                    while (done == false) {
                        if (HistorialPadecimientos != null) {
                            for (int i = 0; i < HistorialPadecimientos.getHistorialPadecimientos().size(); i++) {
                                try {
                                    if (i == HistorialPadecimientos.getHistorialPadecimientos().size() - 1) {
                                        done = true;
                                        System.out.println("hilo detenido");
                                    }
                                    Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(HistorialPadecimientos
                                            .getHistorialPadecimientos()
                                            .get(i)
                                            .getFechaDiagnostico());
                                    modelo.addRow(new Object[]{
                                        HistorialPadecimientos.getHistorialPadecimientos().get(i).getNombre(),
                                        HistorialPadecimientos.getHistorialPadecimientos().get(i).getGravedad(),
                                        HistorialPadecimientos.getHistorialPadecimientos().get(i).getCausa(),
                                        new SimpleDateFormat("dd/MM/yyyy").format(date)
                                    });
                                    tablaPadecimientos.setModel(modelo);
                                } catch (ParseException ex) {
                                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            done = true;
                            System.out.println("hilo detenido por lista vacia");
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean done = false;
                    while (done == false) {
                        if (HistorialAlergias != null) {
                            for (int i = 0; i < HistorialAlergias.getHistorialAlergias().size(); i++) {
                                try {
                                    if (i == HistorialAlergias.getHistorialAlergias().size() - 1) {
                                        done = true;
                                        System.out.println("hilo detenido");
                                    }
                                    Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(HistorialAlergias.getHistorialAlergias().get(i).getFechaDiagnostico());
                                    modelo1.addRow(new Object[]{
                                        HistorialAlergias.getHistorialAlergias().get(i).getNombre(),
                                        HistorialAlergias.getHistorialAlergias().get(i).getReaccion(),
                                        HistorialAlergias.getHistorialAlergias().get(i).getSintomas(),
                                        new SimpleDateFormat("dd/MM/yyyy").format(date)

                                    });
                                    tablaAlergias.setModel(modelo1);
                                } catch (ParseException ex) {
                                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            done = true;
                            System.out.println("hilo detenido por lista vacia");
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean done = false;
                    while (done == false) {
                        if (HistorialMedicamentos != null) {
                            for (int i = 0; i < HistorialMedicamentos.getHistorialMedicamentos().size(); i++) {
                                try {
                                    if (i == HistorialMedicamentos.getHistorialMedicamentos().size() - 1) {
                                        done = true;
                                        System.out.println("hilo detenido");
                                    }
                                    Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(HistorialMedicamentos.getHistorialMedicamentos().get(i).getFechaInicio());
                                    modelo2.addRow(new Object[]{
                                        HistorialMedicamentos.getHistorialMedicamentos().get(i).getNombre(),
                                        HistorialMedicamentos.getHistorialMedicamentos().get(i).getDosis(),
                                        HistorialMedicamentos.getHistorialMedicamentos().get(i).getFrecuencia(),
                                        new SimpleDateFormat("dd/MM/yyyy").format(date)
                                    });
                                    tablaMedicamentos.setModel(modelo2);
                                } catch (ParseException ex) {
                                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            done = true;
                            System.out.println("hilo detenido por lista vacia");
                        }
                    }
                }
            }).start();
            long end2 = System.currentTimeMillis();
            System.out.println(end2 - start2 + " tiempo total");
        } catch (IOException ex) {
            Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAlergia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSintomas = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtReaccion = new javax.swing.JTextField();
        btnAgregarAlergia = new javax.swing.JButton();
        btnEliminarAl = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        fechaDiagnosticoA = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMedicamento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDosis = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFrecuencia = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnAñadirM = new javax.swing.JButton();
        btnEliminarMed = new javax.swing.JButton();
        fechaInicioM = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMedico = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDependencia = new javax.swing.JTextField();
        txtClinica = new javax.swing.JTextField();
        txtConsultorio = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtModalidad = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPadecimiento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtGravedad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtCausa = new javax.swing.JTextField();
        btnAgregarPadecimiento = new javax.swing.JButton();
        btnEliminarPad = new javax.swing.JButton();
        fechaDiagnosticoP = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPadecimientos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlergias = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        labelNombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Modificación de datos médicos del paciente");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Alergías");

        jLabel3.setText("Nombre (Alergia)");

        txtAlergia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlergiaKeyTyped(evt);
            }
        });

        jLabel4.setText("Reacción");

        txtSintomas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSintomasKeyTyped(evt);
            }
        });

        jLabel25.setText("Síntomas");

        txtReaccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReaccionKeyTyped(evt);
            }
        });

        btnAgregarAlergia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAlergia.setForeground(new java.awt.Color(0, 153, 0));
        btnAgregarAlergia.setText("+");
        btnAgregarAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlergiaActionPerformed(evt);
            }
        });

        btnEliminarAl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminarAl.setForeground(new java.awt.Color(255, 0, 0));
        btnEliminarAl.setText("-");
        btnEliminarAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlActionPerformed(evt);
            }
        });

        jLabel24.setText("Fecha del diagnóstico");

        fechaDiagnosticoA.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarAl)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fechaDiagnosticoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgregarAlergia)
                                        .addGap(34, 34, 34))
                                    .addComponent(txtReaccion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addContainerGap(28, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarAl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarAlergia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDiagnosticoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Medicamentos");

        jLabel6.setText("Nombre");

        txtMedicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMedicamentoKeyTyped(evt);
            }
        });

        jLabel7.setText("Dosis");

        jLabel8.setText("Frecuencia");

        jLabel26.setText("Fecha de inicio");

        btnAñadirM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAñadirM.setForeground(new java.awt.Color(0, 153, 0));
        btnAñadirM.setText("+");
        btnAñadirM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirMActionPerformed(evt);
            }
        });

        btnEliminarMed.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminarMed.setForeground(new java.awt.Color(255, 0, 0));
        btnEliminarMed.setText("-");
        btnEliminarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMedActionPerformed(evt);
            }
        });

        fechaInicioM.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(87, 87, 87)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel26))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(fechaInicioM, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAñadirM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarMed)
                        .addGap(11, 11, 11))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEliminarMed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnAñadirM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addGap(2, 2, 2)
                        .addComponent(fechaInicioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Médico");

        jLabel14.setText("Nombre");

        txtMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMedicoKeyTyped(evt);
            }
        });

        jLabel15.setText("Especialidad");

        txtEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEspecialidadKeyTyped(evt);
            }
        });

        jLabel16.setText("Cargo");

        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCargoKeyTyped(evt);
            }
        });

        jLabel17.setText("Dependencia");

        jLabel18.setText("Clínica base");

        jLabel19.setText("Cédula profesional");

        jLabel20.setText("Modalidad de trabajo");

        jLabel21.setText("Consultorio");

        txtModalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModalidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(176, 176, 176)
                                .addComponent(jLabel16)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel15)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 21, Short.MAX_VALUE))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEditar.setBackground(new java.awt.Color(8, 51, 162));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar datos");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(26, 218, 98));
        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Padecimientos");

        jLabel10.setText("Nombre (Padecimiento)");

        txtPadecimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPadecimientoKeyTyped(evt);
            }
        });

        jLabel11.setText("Gravedad");

        txtGravedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGravedadKeyTyped(evt);
            }
        });

        jLabel12.setText("Causa");

        jLabel23.setText("Fecha del diagnóstico");

        txtCausa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCausaKeyTyped(evt);
            }
        });

        btnAgregarPadecimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarPadecimiento.setForeground(new java.awt.Color(0, 153, 0));
        btnAgregarPadecimiento.setText("+");
        btnAgregarPadecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPadecimientoActionPerformed(evt);
            }
        });

        btnEliminarPad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminarPad.setForeground(new java.awt.Color(255, 0, 0));
        btnEliminarPad.setText("-");
        btnEliminarPad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPadActionPerformed(evt);
            }
        });

        fechaDiagnosticoP.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarPadecimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPad))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtPadecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23)
                            .addComponent(jLabel11)
                            .addComponent(txtGravedad, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(fechaDiagnosticoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnAgregarPadecimiento)
                    .addComponent(btnEliminarPad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPadecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDiagnosticoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tablaPadecimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Gravedad", "Causa", "Fecha diagnóstico"
            }
        ));
        tablaPadecimientos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaPadecimientos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablaPadecimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPadecimientosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPadecimientos);

        tablaAlergias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Reacción", "Síntomas", "Fecha diagnóstico"
            }
        ));
        tablaAlergias.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaAlergias.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablaAlergias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlergiasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAlergias);

        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dosis", "Frecuencia", "Fecha inicio"
            }
        ));
        tablaMedicamentos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaMedicamentos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablaMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMedicamentosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaMedicamentos);

        labelNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNombre.setText("(Nombre del paciente)");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (banderaPrincipalInicio == 0) {
            banderaPrincipalInicio = 1;
            activarBotones();
            activarCamposAl();
            activarCamposM();
            activarCamposPad();
        } else {
            if (!tablaPadecimientos.getSelectionModel().isSelectionEmpty()) {
                int indiceFila = tablaPadecimientos.getSelectedRow();
                indicePadecimientoAEditar = HistorialPadecimientos.getHistorialPadecimientos().get(tablaPadecimientos.getSelectedRow()).getId();
                limpiarCajasM();
                limpiarCajasAl();
                txtPadecimiento.setText(tablaPadecimientos.getValueAt(indiceFila, 0).toString());
                txtGravedad.setText(tablaPadecimientos.getValueAt(indiceFila, 1).toString());
                txtCausa.setText(tablaPadecimientos.getValueAt(indiceFila, 2).toString());
                JTextFieldDateEditor fechaDiagnosticoTxt = (JTextFieldDateEditor) fechaDiagnosticoP.getDateEditor();
                fechaDiagnosticoTxt.setText(tablaPadecimientos.getValueAt(indiceFila, 3).toString());
            } else if (!tablaAlergias.getSelectionModel().isSelectionEmpty()) {
                int indiceFila = tablaAlergias.getSelectedRow();
                indiceAlergiaAEditar = HistorialAlergias.getHistorialAlergias().get(tablaAlergias.getSelectedRow()).getId();
                limpiarCajasPad();
                limpiarCajasM();
                txtAlergia.setText(tablaAlergias.getValueAt(indiceFila, 0).toString());
                txtReaccion.setText(tablaAlergias.getValueAt(indiceFila, 1).toString());
                txtSintomas.setText(tablaAlergias.getValueAt(indiceFila, 2).toString());
                JTextFieldDateEditor fechaDiagnosticoTxt = (JTextFieldDateEditor) fechaDiagnosticoA.getDateEditor();
                fechaDiagnosticoTxt.setText(tablaAlergias.getValueAt(indiceFila, 3).toString());
            } else if (!tablaMedicamentos.getSelectionModel().isSelectionEmpty()) {
                int indiceFila = tablaMedicamentos.getSelectedRow();
                indiceMedicamentoAEditar = HistorialMedicamentos.getHistorialMedicamentos().get(tablaMedicamentos.getSelectedRow()).getId();
                System.out.println(indiceMedicamentoAEditar);
                limpiarCajasPad();
                limpiarCajasAl();
                txtMedicamento.setText(tablaMedicamentos.getValueAt(indiceFila, 0).toString());
                txtDosis.setText(tablaMedicamentos.getValueAt(indiceFila, 1).toString());
                txtFrecuencia.setText(tablaMedicamentos.getValueAt(indiceFila, 2).toString());
                JTextFieldDateEditor fechaInicio = (JTextFieldDateEditor) fechaInicioM.getDateEditor();
                fechaInicio.setText(tablaMedicamentos.getValueAt(indiceFila, 3).toString());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed


    }//GEN-LAST:event_btnGuardarActionPerformed


    private void tablaPadecimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPadecimientosMouseClicked

    }//GEN-LAST:event_tablaPadecimientosMouseClicked

    private void btnAgregarPadecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPadecimientoActionPerformed
        if (!(txtPadecimiento.getText() == null || txtPadecimiento.getText() == "")
                && !(txtGravedad.getText() == null || txtGravedad.getText() == "")
                && !(txtCausa.getText() == null || txtCausa.getText() == "")
                && !(fechaDiagnosticoP.getDate() == null)) {
            if (indicePadecimientoAEditar != 0) {
                try {
                    String fechaDiagnosticoFormatoCrudo = dFormat.format(fechaDiagnosticoP.getDate());
                    HistorialPadecimientos padecimientoAModificar = new HistorialPadecimientos();
                    padecimientoAModificar.setId(indicePadecimientoAEditar);
                    padecimientoAModificar.setNombre(txtPadecimiento.getText());
                    padecimientoAModificar.setGravedad(txtGravedad.getText());
                    padecimientoAModificar.setCausa(txtCausa.getText());
                    JTextFieldDateEditor fechaDiagnosticoPadecimiento = (JTextFieldDateEditor) fechaDiagnosticoP.getDateEditor();
                    padecimientoAModificar.setFechaDiagnostico(fechaDiagnosticoFormatoCrudo);
                    padecimientoAModificar.setIdPac(Integer.valueOf(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim()));
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonPadecimientoAEnviar = objectMapper.writeValueAsString(padecimientoAModificar);

                    int actualizarPadecimientoStatus = RestManager
                            .getInstance()
                            .actualizarPadecimiento(String.valueOf(indicePadecimientoAEditar), jsonPadecimientoAEnviar);

                    if (actualizarPadecimientoStatus == 200) {
                        JOptionPane op = new JOptionPane("Cambios guardados", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op);
                        op.setBackground(Color.green);
                        JDialog jd = op.createDialog(this, "");
                        jd.setVisible(true);

                        indicePadecimientoAEditar = 0;
                        limpiarTablas();
                        limpiarCajasPad();
                        cargarPadecimientos();

                    } else {
                        System.out.println("cambios no guardados");
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    String fechaDiagnosticoFormatoCrudo = dFormat.format(fechaDiagnosticoP.getDate());
                    ArrayList<HistorialPadecimientos> listaParaEnviar = new ArrayList<>();
                    HistorialPadecimientos padecimientoARegistrar = new HistorialPadecimientos();
                    padecimientoARegistrar.setId(indicePadecimientoAEditar);
                    padecimientoARegistrar.setNombre(txtPadecimiento.getText());
                    padecimientoARegistrar.setGravedad(txtGravedad.getText());
                    padecimientoARegistrar.setCausa(txtCausa.getText());
                    //      JTextFieldDateEditor fechaDiagnosticoPadecimiento = (JTextFieldDateEditor) fechaDiagnosticoP.getDateEditor();
                    padecimientoARegistrar.setFechaDiagnostico(fechaDiagnosticoFormatoCrudo);
                    padecimientoARegistrar.setIdPac(Integer.valueOf(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim()));
                    listaParaEnviar.add(padecimientoARegistrar);

                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonPadecimientoAEnviar = objectMapper.writeValueAsString(listaParaEnviar);

                    int padecimientosStatusResponse = RestManager
                            .getInstance()
                            .añadirPadecimientos(jsonPadecimientoAEnviar);
                    if (padecimientosStatusResponse == 200) {
                        JOptionPane op = new JOptionPane("padecimientos registrado", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op);
                        op.setBackground(Color.green);
                        JDialog jd = op.createDialog(this, "");
                        jd.setVisible(true);

                        limpiarTablas();
                        limpiarCajasPad();
                        cargarPadecimientos();
                    } else {
                        System.out.println("padecimientos no registrados");
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane op = new JOptionPane("Favor de rellenar todos los campos", JOptionPane.PLAIN_MESSAGE);
            getComponents2(op);
            op.setBackground(Color.red);
            JDialog jd = op.createDialog(this, "");
            jd.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarPadecimientoActionPerformed

    private void limpiarTablas() {
        DefaultTableModel c1 = (DefaultTableModel) tablaPadecimientos.getModel();
        c1.setRowCount(0);
        tablaPadecimientos.setModel(c1);
        c1 = (DefaultTableModel) tablaAlergias.getModel();
        c1.setRowCount(0);
        tablaAlergias.setModel(c1);
        c1 = (DefaultTableModel) tablaMedicamentos.getModel();
        c1.setRowCount(0);
        tablaMedicamentos.setModel(c1);
    }

    private void tablaAlergiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlergiasMouseClicked

    }//GEN-LAST:event_tablaAlergiasMouseClicked

    private void btnAgregarAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlergiaActionPerformed
        if (!(txtAlergia.getText() == null || txtAlergia.getText() == "")
                && !(txtReaccion.getText() == null || txtReaccion.getText() == "")
                && !(txtSintomas.getText() == null || txtSintomas.getText() == "")
                && !(fechaDiagnosticoA.getDate() == null)) {
            if (indiceAlergiaAEditar != 0) {
                try {
                    String fechaDiagnosticoFormatoCrudo = dFormat.format(fechaDiagnosticoA.getDate());
                    HistorialAlergias alergiaAModificar = new HistorialAlergias();
                    alergiaAModificar.setId(indiceAlergiaAEditar);
                    alergiaAModificar.setNombre(txtAlergia.getText());
                    alergiaAModificar.setReaccion(txtReaccion.getText());
                    alergiaAModificar.setSintomas(txtSintomas.getText());
                    //  JTextFieldDateEditor fechaDiagnosticoPadecimiento = (JTextFieldDateEditor) fechaDiagnosticoA.getDateEditor();
                    alergiaAModificar.setFechaDiagnostico(fechaDiagnosticoFormatoCrudo);
                    alergiaAModificar.setIdPac(Integer.valueOf(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim()));
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonAlergiaAEnviar = objectMapper.writeValueAsString(alergiaAModificar);

                    int actualizarAlergiaStatus = RestManager
                            .getInstance()
                            .actualizarAlergia(String.valueOf(indiceAlergiaAEditar), jsonAlergiaAEnviar);

                    if (actualizarAlergiaStatus == 200) {
                        JOptionPane op = new JOptionPane("Cambios guardados", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op);
                        op.setBackground(Color.green);
                        JDialog jd = op.createDialog(this, "");
                        jd.setVisible(true);

                        indiceAlergiaAEditar = 0;
                        limpiarTablas();
                        limpiarCajasAl();
                        cargarPadecimientos();

                    } else {
                        System.out.println("cambios no guardados");
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    String fechaDiagnosticoFormatoCrudo = dFormat.format(fechaDiagnosticoA.getDate());
                    ArrayList<HistorialAlergias> listaParaEnviar = new ArrayList<>();
                    HistorialAlergias alergiaARegistrar = new HistorialAlergias();
                    alergiaARegistrar.setId(indicePadecimientoAEditar);
                    alergiaARegistrar.setNombre(txtAlergia.getText());
                    alergiaARegistrar.setReaccion(txtReaccion.getText());
                    alergiaARegistrar.setSintomas(txtSintomas.getText());
                    //      JTextFieldDateEditor fechaDiagnosticoPadecimiento = (JTextFieldDateEditor) fechaDiagnosticoA.getDateEditor();
                    alergiaARegistrar.setFechaDiagnostico(fechaDiagnosticoFormatoCrudo);
                    alergiaARegistrar.setIdPac(Integer.valueOf(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim()));
                    listaParaEnviar.add(alergiaARegistrar);

                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonAlergiasAEnviar = objectMapper.writeValueAsString(listaParaEnviar);

                    int padecimientosStatusResponse = RestManager
                            .getInstance()
                            .añadirAlergia(jsonAlergiasAEnviar);
                    if (padecimientosStatusResponse == 200) {
                        JOptionPane op = new JOptionPane("alergias registradas", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op);
                        op.setBackground(Color.green);
                        JDialog jd = op.createDialog(this, "");
                        jd.setVisible(true);

                        limpiarTablas();
                        limpiarCajasAl();
                        cargarPadecimientos();
                    } else {
                        System.out.println("alergias no registradas");
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane op = new JOptionPane("Favor de rellenar todos los campos", JOptionPane.PLAIN_MESSAGE);
            getComponents2(op);
            op.setBackground(Color.red);
            JDialog jd = op.createDialog(this, "");
            jd.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarAlergiaActionPerformed

    private void tablaMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedicamentosMouseClicked

    }//GEN-LAST:event_tablaMedicamentosMouseClicked

    private void btnAñadirMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirMActionPerformed
        if (!(txtMedicamento.getText() == null || txtMedicamento.getText() == "")
                && !(txtDosis.getText() == null || txtDosis.getText() == "")
                && !(txtFrecuencia.getText() == null || txtFrecuencia.getText() == "")
                && !(fechaInicioM.getDate() == null)) {
            if (indiceMedicamentoAEditar != 0) {
                try {
                    String fechaInicialFormatoCrudo = dFormat.format(fechaInicioM.getDate());
                    HistorialMedicamentos medicamentoAModificar = new HistorialMedicamentos();
                    medicamentoAModificar.setId(indiceMedicamentoAEditar);
                    medicamentoAModificar.setNombre(txtMedicamento.getText());
                    medicamentoAModificar.setDosis(txtDosis.getText());
                    medicamentoAModificar.setFrecuencia(txtFrecuencia.getText());
                    //    JTextFieldDateEditor fechaDiagnosticoPadecimiento = (JTextFieldDateEditor) fechaInicioM.getDateEditor();
                    medicamentoAModificar.setFechaInicio(fechaInicialFormatoCrudo);
                    medicamentoAModificar.setIdPac(Integer.valueOf(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim()));
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonMedicamentoAEnviar = objectMapper.writeValueAsString(medicamentoAModificar);
                    //   System.out.println(indiceMedicamentoAEditar);
                    int actualizarMedicamentoStatus = RestManager
                            .getInstance()
                            .actualizarMedicamento(String.valueOf(indiceMedicamentoAEditar), jsonMedicamentoAEnviar);

                    if (actualizarMedicamentoStatus == 200) {
                        JOptionPane op = new JOptionPane("Cambios guardados", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op);
                        op.setBackground(Color.green);
                        JDialog jd = op.createDialog(this, "");
                        jd.setVisible(true);

                        indiceMedicamentoAEditar = 0;
                        limpiarTablas();
                        limpiarCajasM();
                        cargarPadecimientos();

                    } else {
                        System.out.println("cambios no guardados");
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    String fechaInicialFormatoCrudo = dFormat.format(fechaInicioM.getDate());
                    ArrayList<HistorialMedicamentos> listaParaEnviar = new ArrayList<>();
                    HistorialMedicamentos medicamentoARegistrar = new HistorialMedicamentos();
                    medicamentoARegistrar.setId(indiceMedicamentoAEditar);
                    medicamentoARegistrar.setNombre(txtMedicamento.getText());
                    medicamentoARegistrar.setDosis(txtDosis.getText());
                    medicamentoARegistrar.setFrecuencia(txtFrecuencia.getText());
                    // JTextFieldDateEditor fechaDiagnosticoPadecimiento = (JTextFieldDateEditor) fechaInicioM.getDateEditor();
                    medicamentoARegistrar.setFechaInicio(fechaInicialFormatoCrudo);
                    medicamentoARegistrar.setIdPac(Integer.valueOf(listaPacientes.getListaPacientesJava().get(indicePaciente).getIdPrim()));
                    listaParaEnviar.add(medicamentoARegistrar);

                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonMedicamentosAEnviar = objectMapper.writeValueAsString(listaParaEnviar);

                    int medicamentosStatusResponse = RestManager
                            .getInstance()
                            .añadirMedicamentos(jsonMedicamentosAEnviar);
                    if (medicamentosStatusResponse == 200) {
                        JOptionPane op = new JOptionPane("medicamentos registrados", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op);
                        op.setBackground(Color.green);
                        JDialog jd = op.createDialog(this, "");
                        jd.setVisible(true);

                        limpiarTablas();
                        limpiarCajasPad();
                        cargarPadecimientos();
                    } else {
                        System.out.println("medicamentos no registrados");
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ModificacionDatosMed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane op = new JOptionPane("Favor de rellenar todos los campos", JOptionPane.PLAIN_MESSAGE);
            getComponents2(op);
            op.setBackground(Color.red);
            JDialog jd = op.createDialog(this, "");
            jd.setVisible(true);
        }
    }//GEN-LAST:event_btnAñadirMActionPerformed

    private void btnEliminarPadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPadActionPerformed
        if (indicePadecimientoAEditar != 0) {
            int eliminarPadecimientoStatus = RestManager.getInstance().eliminarPadecimiento(String.valueOf(indicePadecimientoAEditar));
            if (eliminarPadecimientoStatus == 200) {
                JOptionPane op = new JOptionPane("Padecimiento borrado", JOptionPane.PLAIN_MESSAGE);
                getComponents(op);
                op.setBackground(Color.green);
                JDialog jd = op.createDialog(this, "");
                jd.setVisible(true);

                indicePadecimientoAEditar = 0;
                limpiarTablas();
                limpiarCajasPad();
                cargarPadecimientos();
            }
        } else {
            JOptionPane op = new JOptionPane("Favor de seleccionar un padecimiento a borrar", JOptionPane.PLAIN_MESSAGE);
            getComponents2(op);
            op.setBackground(Color.red);
            JDialog jd = op.createDialog(this, "");
            jd.setVisible(true);
        }
    }//GEN-LAST:event_btnEliminarPadActionPerformed

    private void btnEliminarAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlActionPerformed
        if (indiceAlergiaAEditar != 0) {
            int eliminarPadecimientoStatus = RestManager.getInstance().eliminarAlergia(String.valueOf(indiceAlergiaAEditar));
            if (eliminarPadecimientoStatus == 200) {
                JOptionPane op = new JOptionPane("Alergia borrada", JOptionPane.PLAIN_MESSAGE);
                getComponents(op);
                op.setBackground(Color.green);
                JDialog jd = op.createDialog(this, "");
                jd.setVisible(true);

                indicePadecimientoAEditar = 0;
                limpiarTablas();
                limpiarCajasAl();
                cargarPadecimientos();
            }
        } else {
            JOptionPane op = new JOptionPane("Favor de seleccionar una alergia a borrar", JOptionPane.PLAIN_MESSAGE);
            getComponents2(op);
            op.setBackground(Color.red);
            JDialog jd = op.createDialog(this, "");
            jd.setVisible(true);
        }
    }//GEN-LAST:event_btnEliminarAlActionPerformed

    private void btnEliminarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMedActionPerformed
        if (indiceMedicamentoAEditar != 0) {
            int eliminarPadecimientoStatus = RestManager.getInstance().eliminarMedicamento(String.valueOf(indiceMedicamentoAEditar));
            if (eliminarPadecimientoStatus == 200) {
                JOptionPane op = new JOptionPane("Medicamento borrado", JOptionPane.PLAIN_MESSAGE);
                getComponents(op);
                op.setBackground(Color.green);
                JDialog jd = op.createDialog(this, "");
                jd.setVisible(true);

                indicePadecimientoAEditar = 0;
                limpiarTablas();
                limpiarCajasM();
                cargarPadecimientos();
            }
        } else {
            JOptionPane op = new JOptionPane("Favor de seleccionar un medicamento a borrar", JOptionPane.PLAIN_MESSAGE);
            getComponents2(op);
            op.setBackground(Color.red);
            JDialog jd = op.createDialog(this, "");
            jd.setVisible(true);
        }
    }//GEN-LAST:event_btnEliminarMedActionPerformed

    private void txtPadecimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPadecimientoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {
            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtPadecimientoKeyTyped

    private void txtGravedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGravedadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtGravedadKeyTyped

    private void txtCausaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCausaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtCausaKeyTyped

    private void txtAlergiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlergiaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtAlergiaKeyTyped

    private void txtReaccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReaccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtReaccionKeyTyped

    private void txtSintomasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSintomasKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtSintomasKeyTyped

    private void txtMedicamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedicamentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtMedicamentoKeyTyped

    private void txtMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedicoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtMedicoKeyTyped

    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtCargoKeyTyped

    private void txtEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEspecialidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtEspecialidadKeyTyped

    private void txtModalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModalidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ') && c != KeyEvent.VK_BACK_SPACE && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {

            evt.consume();
            JOptionPane pane2 = new JOptionPane("No se admiten numeros en este campo",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
            getComponents2(pane2);
            pane2.setBackground(Color.red);
            JDialog jd1 = pane2.createDialog(this, "");
            jd1.setVisible(true);
        }
    }//GEN-LAST:event_txtModalidadKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        modelo.setRowCount(0);
        tablaPadecimientos.setModel(modelo);
        modelo1.setRowCount(0);
        tablaAlergias.setModel(modelo1);
        modelo2.setRowCount(0);
        tablaMedicamentos.setModel(modelo2);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        tablaMedicamentos.clearSelection();
        tablaAlergias.clearSelection();
        tablaPadecimientos.clearSelection();
        indiceAlergiaAEditar = 0;
        indiceMedicamentoAEditar = 0;
        indicePadecimientoAEditar = 0;
        limpiarCajasAl();
        limpiarCajasM();
        limpiarCajasPad();
    }//GEN-LAST:event_jPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificacionDatosMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificacionDatosMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificacionDatosMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificacionDatosMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificacionDatosMed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAlergia;
    private javax.swing.JButton btnAgregarPadecimiento;
    private javax.swing.JButton btnAñadirM;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarAl;
    private javax.swing.JButton btnEliminarMed;
    private javax.swing.JButton btnEliminarPad;
    private javax.swing.JButton btnGuardar;
    private com.toedter.calendar.JDateChooser fechaDiagnosticoA;
    private com.toedter.calendar.JDateChooser fechaDiagnosticoP;
    private com.toedter.calendar.JDateChooser fechaInicioM;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTable tablaAlergias;
    private javax.swing.JTable tablaMedicamentos;
    private javax.swing.JTable tablaPadecimientos;
    private javax.swing.JTextField txtAlergia;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCausa;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtClinica;
    private javax.swing.JTextField txtConsultorio;
    private javax.swing.JTextField txtDependencia;
    private javax.swing.JTextField txtDosis;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtFrecuencia;
    private javax.swing.JTextField txtGravedad;
    private javax.swing.JTextField txtMedicamento;
    private javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtModalidad;
    private javax.swing.JTextField txtPadecimiento;
    private javax.swing.JTextField txtReaccion;
    private javax.swing.JTextField txtSintomas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
