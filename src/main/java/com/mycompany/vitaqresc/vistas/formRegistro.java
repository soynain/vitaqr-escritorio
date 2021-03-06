/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.vistas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.vitaqresc.controladores.RestManager;
import com.mycompany.vitaqresc.models.HistorialAlergias;
import com.mycompany.vitaqresc.models.HistorialMedicamentos;
import com.mycompany.vitaqresc.models.HistorialPadecimientos;
import com.mycompany.vitaqresc.models.ListaAlergiasPaciente;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Gebel
 */
public class formRegistro extends javax.swing.JFrame {

    /**
     * Creates new form formRegistro
     */
    public static panelPacientePrincipal principal;
    public static frameA├▒adirAlergias alergiaFrame;
    public static frameA├▒adirPadecimientos padeFrame;
    public static frameA├▒adirMedicamentos medFrame;
    JTextFieldDateEditor editor;

    public static String nombreR = "";
    public static String apellidosR = "";
    public static String telefonoR = "";
    //String fechaTexto = formatoDelTexto.format("31/07/2000");
    Date fecha = new Date("2000/07/31");
    public static String dateR = "";

    public static String sexoR = "";
    public static double alturaR = 0;
    public static double pesoR = 0;
    public static String donanteR = "";

//   
    public formRegistro() {

        initComponents();
        alergiaFrame = new frameA├▒adirAlergias();
        padeFrame = new frameA├▒adirPadecimientos();
        medFrame = new frameA├▒adirMedicamentos();
        //  fechaNac.setEnabled(false);
        this.editor = (JTextFieldDateEditor) fechaNac.getDateEditor();
        //    editor.setEnabled(false);
        //jButton1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        fechaNac = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        usuarioReg = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        contraReg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrar nuevo paciente");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Nombres");

        jLabel4.setText("Fecha de nacimiento");

        jLabel5.setText("Sexo");

        jLabel6.setText("Altura");

        jLabel7.setText("Peso");

        jLabel8.setText("Donante de ├│rganos");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(26, 218, 98));
        jButton1.setText("Confirmar registro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opci├│n", "Si", "No" }));

        jLabel9.setText("Tel├ęfono");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opci├│n", "Masculino", "Femenino" }));

        jButton2.setText("A├▒adir alergias");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("A├▒adir padecimientos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("A├▒adir medicamentos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        fechaNac.setDateFormatString("dd/MM/yyyy");

        jButton5.setText("Regresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setText("Usuario");

        jLabel11.setText("Contrase├▒a");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(usuarioReg, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(contraReg)))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(usuarioReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(contraReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        obtenerArrayText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        alergiaFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        padeFrame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        medFrame.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        principal.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    private void getComponents(Container c) {
        Component[] m = c.getComponents();
        for (int i = 0; i < m.length; i++) {
            if (m[i].getClass().getName() == "javax.swing.JPanel") {
                m[i].setBackground(Color.red);
            }
            if (c.getClass().isInstance(m[i])) {
                getComponents((Container) m[i]);
            }
        }
    }

    private void getComponents(Container c, boolean si) {
        Component[] m = c.getComponents();
        for (int i = 0; i < m.length; i++) {
            if (m[i].getClass().getName() == "javax.swing.JPanel") {
                m[i].setBackground(Color.green);
            }
            if (c.getClass().isInstance(m[i])) {
                getComponents((Container) m[i]);
            }
        }
    }

    public void activarInstanciaOriginal(panelPacientePrincipal c1) {
        principal = c1;
    }

    public void obtenerArrayText() {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        /*validaci├│n de campos*/
        sdfrmt.setLenient(false);
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Pattern patronLetras = Pattern.compile("[a-zA-Z├í-├║├ü-├Ü ]+");
        if (!(jTextField1.getText().isEmpty()) && !(editor.getText().isEmpty()) && !(jTextField2.getText().isEmpty())
                && (jComboBox2.getSelectedItem().toString() != "Selecciona una opci├│n") && !(jTextField5.getText().isEmpty())
                && !(jTextField6.getText().isEmpty()) && (jComboBox1.getSelectedItem().toString() != "Selecciona una opci├│n")
                && !(jTextField7.getText().isEmpty()) && !(usuarioReg.getText().isEmpty()) && !(contraReg.getText().isEmpty())) {

            try {
                Date javaDate = sdfrmt.parse(editor.getText());
                if (pattern.matcher(jTextField7.getText()).matches()) {
                    if (patronLetras.matcher(jTextField1.getText()).matches() && patronLetras.matcher(jTextField2.getText()).matches()) {
                        /*una vez los datos son validadeos, se almacenan en variables*/
                        nombreR = jTextField1.getText();
                        apellidosR = jTextField2.getText();
                        telefonoR = jTextField7.getText();
                        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                        dateR = dFormat.format(fechaNac.getDate());
                        sexoR = jComboBox2.getSelectedItem().toString();
                        alturaR = Double.parseDouble(jTextField5.getText());
                        pesoR = Double.parseDouble(jTextField6.getText());
                        donanteR = jComboBox1.getSelectedItem().toString();
                        //  String nombreCompleto = nombreR + " " + apellidosR;

                        /*enviar solicitud post con los datos del paciente, a punto de testear
                        inserci├│n de alergias*/
                        String registroId = RestManager.getInstance()
                                .registrarNuevoPaciente(nombreR, apellidosR, usuarioReg.getText(), contraReg.getText(),
                                        dateR.toString(), sexoR, String.valueOf(alturaR),
                                        String.valueOf(pesoR), telefonoR, donanteR);
                        JOptionPane op = new JOptionPane("El paciente ha sido correctamente registrado en tu consultorio", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op, true);
                        op.setBackground(Color.green);
                        JDialog jd = op.createDialog(this, "");
                        jd.setVisible(true);
                        alergiaFrame.formulario.dispose();
                        alergiaFrame.dispose();
                        principal.setVisible(true);
                        principal.jButton11.doClick();
                        this.setVisible(false);
                        registrarAlergias(registroId);
                    } else {
                        JOptionPane op3 = new JOptionPane("Los campos nombre y apellidos solo admiten texto", JOptionPane.PLAIN_MESSAGE);
                        getComponents(op3);
                        op3.setBackground(Color.red);
                        JDialog jd2 = op3.createDialog(this, "");
                        jd2.setVisible(true);
                    }
                } else {
                    JOptionPane op3 = new JOptionPane("El tel├ęfono no admite texto", JOptionPane.PLAIN_MESSAGE);
                    getComponents(op3);
                    op3.setBackground(Color.red);
                    JDialog jd2 = op3.createDialog(this, "");
                    jd2.setVisible(true);
                }
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                JOptionPane op3 = new JOptionPane("El formato de fecha es incorrecto, debe ser dd/MM/yyyy", JOptionPane.PLAIN_MESSAGE);
                getComponents(op3);
                op3.setBackground(Color.red);
                JDialog jd2 = op3.createDialog(this, "");
                jd2.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(formRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane op2 = new JOptionPane("Favor de rellenar todos los campos", JOptionPane.PLAIN_MESSAGE);
            getComponents(op2);
            op2.setBackground(Color.red);
            JDialog jd2 = op2.createDialog(this, "");
            jd2.setVisible(true);
        }

    }

    public void registrarAlergias(String id) throws JsonProcessingException {
        /*si el string no viene nulo o no hu o error de server,
                        significa que el registro fue un exito*/
        if (id != null || id != "" || id != " ") {
            System.out.println(id);
            ObjectMapper objectMapper = new ObjectMapper();
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            /*recuperamos el id de la inserci├│n del registro del paciente
                            para a├▒adir las alergias, padecimientos y medicamentos 
                            desde el modulo del registro*/
            JsonNode jsonNode = objectMapper.readTree(id);
            String idInsertado = jsonNode.get("id").asText();

            /*Se crea una lista con los atributos de alergia, para ser convertidos
                        a json, se debe incluir el id del paciente en la solicitud a mandar
                        despu├ęs de registrar al usuario*/
            if (alergiaFrame.getjTable1().getRowCount() > 0) {
                ArrayList<HistorialAlergias> listaParaEnviar = new ArrayList<>();
                for (int i = 0; i < alergiaFrame.getjTable1().getRowCount(); i++) {
                    HistorialAlergias alergiaIndividual = new HistorialAlergias();
                    alergiaIndividual.setNombre(alergiaFrame.getjTable1().getValueAt(i, 0).toString());
                    alergiaIndividual.setReaccion(alergiaFrame.getjTable1().getValueAt(i, 1).toString());
                    alergiaIndividual.setSintomas(alergiaFrame.getjTable1().getValueAt(i, 2).toString());
                    alergiaIndividual.setFechaDiagnostico(dFormat.format(alergiaFrame.getjTable1().getValueAt(i, 3).toString()));
                    alergiaIndividual.setIdPac(Integer.valueOf(idInsertado));
                    listaParaEnviar.add(alergiaIndividual);
                }

                String jsonListaAlergiasAEnviar = objectMapper.writeValueAsString(listaParaEnviar);
                int alergiaStatusResponse = RestManager.getInstance().a├▒adirAlergia(jsonListaAlergiasAEnviar);
                if (alergiaStatusResponse == 200) {
                    System.out.println("alergias registradas");
                } else {
                    System.out.println("alergias no registradas");
                }
            }
        }
        registrarPadecimientos(id);
    }

    public void registrarPadecimientos(String id) throws JsonProcessingException {
        /*registrar los padecimientos con la misma din├ímica que las alergias*/
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        /*recuperamos el id de la inserci├│n del registro del paciente
                            para a├▒adir las alergias, padecimientos y medicamentos 
                            desde el modulo del registro*/
        JsonNode jsonNode = objectMapper.readTree(id);
        String idInsertado = jsonNode.get("id").asText();
        // String idInsertado = jsonNode.get("id").asText();
        if (padeFrame.getjTable1().getRowCount() > 0) {
            ArrayList<HistorialPadecimientos> listaParaEnviar = new ArrayList<>();
            for (int i = 0; i < padeFrame.getjTable1().getRowCount(); i++) {
                HistorialPadecimientos padecimientosLista = new HistorialPadecimientos();
                padecimientosLista.setNombre(padeFrame.getjTable1().getValueAt(i, 0).toString());
                padecimientosLista.setGravedad(padeFrame.getjTable1().getValueAt(i, 1).toString());
                padecimientosLista.setCausa(padeFrame.getjTable1().getValueAt(i, 2).toString());
                padecimientosLista.setFechaDiagnostico(dFormat.format(padeFrame.getjTable1().getValueAt(i, 3).toString()));
                padecimientosLista.setIdPac(Integer.valueOf(idInsertado));
                listaParaEnviar.add(padecimientosLista);
            }

            String jsonListaPadecimientosAEnviar = objectMapper.writeValueAsString(listaParaEnviar);
            System.out.println(jsonListaPadecimientosAEnviar);
            int padecimientosStatusResponse = RestManager.getInstance().a├▒adirPadecimientos(jsonListaPadecimientosAEnviar);
            if (padecimientosStatusResponse == 200) {
                System.out.println("padecimientos registrados");
            } else {
                System.out.println("padecimientos no registrados");
            }
        }
        registrarMedicamentos(id);
    }

    public void registrarMedicamentos(String id) throws JsonProcessingException {
        /*registrar medicamentos por ultimo*/
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        /*recuperamos el id de la inserci├│n del registro del paciente
                            para a├▒adir las alergias, padecimientos y medicamentos 
                            desde el modulo del registro*/
        JsonNode jsonNode = objectMapper.readTree(id);
        String idInsertado = jsonNode.get("id").asText();
        // String idInsertado = jsonNode.get("id").asText();
        if (medFrame.getjTable1().getRowCount() > 0) {
            ArrayList<HistorialMedicamentos> listaParaEnviar = new ArrayList<>();
            for (int i = 0; i < medFrame.getjTable1().getRowCount(); i++) {
                HistorialMedicamentos medicamentosLista = new HistorialMedicamentos();
                medicamentosLista.setNombre(medFrame.getjTable1().getValueAt(i, 0).toString());
                medicamentosLista.setDosis(medFrame.getjTable1().getValueAt(i, 1).toString());
                medicamentosLista.setFrecuencia(medFrame.getjTable1().getValueAt(i, 2).toString());
                medicamentosLista.setFechaInicio(dFormat.format(medFrame.getjTable1().getValueAt(i, 3).toString()));
                medicamentosLista.setIdPac(Integer.valueOf(idInsertado));
                listaParaEnviar.add(medicamentosLista);
            }

            String jsonListaMedicamentosAEnviar = objectMapper.writeValueAsString(listaParaEnviar);
            System.out.println(jsonListaMedicamentosAEnviar);
            int medicamentosStatusResponse = RestManager.getInstance().a├▒adirMedicamentos(jsonListaMedicamentosAEnviar);
            if (medicamentosStatusResponse == 200) {
                System.out.println("medicamentos registrados");
            } else {
                System.out.println("medicamentos no registrados");
            }
        }
    }

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
            java.util.logging.Logger.getLogger(formRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contraReg;
    private com.toedter.calendar.JDateChooser fechaNac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField usuarioReg;
    // End of variables declaration//GEN-END:variables
}
