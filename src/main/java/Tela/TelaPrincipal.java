/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import Dao.GraphDAO;
import Dao.ReportDAO;
import Entidade.UsuarioLogado;
import Tela.IfrUsuario;
import Tela.IfrFornecedor;
import Tela.IfrMaterial;
import Tela.IfrAudit;
import Tela.IfrEmail;
import Tela.IfrPropriedadesMaterial;
import Tela.IfrProduto;
import Tela.IfrRelLoginData;
import Tela.IfrFormulacao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author klein
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public static boolean ligaAuditoria = true;
    private static TelaPrincipal instance;

    ;

    /**
     * Creates new form FrmPrincipal
     */
    
    public TelaPrincipal() {
        initComponents();
        operador(UsuarioLogado.getUsuarioLogadoPermissao());
        analista(UsuarioLogado.getUsuarioLogadoPermissao());
        //this.setExtendedState(MAXIMIZED_BOTH);
        checkBoxAuditoria.setSelected(true);

        chamaGraf();
        chamaGraf2();
        jLabel1.setText("Bem-Vindo ao Gerform " + UsuarioLogado.getUsuarioLogadoEmail());
        jLabel1.setAlignmentX(CENTER_ALIGNMENT);
        jLabel1.setAlignmentY(CENTER_ALIGNMENT);
    }
        
    public static TelaPrincipal getInstance() {
        if (instance == null) {
            instance = new TelaPrincipal();
        }
        return instance;
    }

    private void centralizarJInternalFrame(JInternalFrame frame) {
        int lDesk = jDesktopPane1.getWidth();
        int aDesk = jDesktopPane1.getHeight();
        int lIFrame = frame.getWidth();
        int aIFrame = frame.getHeight();

        frame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
    }

    private void centralizarJPanelEsquerda(JPanel jPanel) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (((dimension.getWidth() / 2) - jPanel.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - jPanel.getHeight()) / 2);
        jPanel.setLocation(400, y);
        jPanel.validate();
        this.validateTree();
    }

    private void centralizarJPanelDireita(JPanel jPanel) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (((dimension.getWidth()) + (dimension.getWidth() / 2)) - jPanel.getWidth()) / 2;
        int y = (int) ((dimension.getHeight() - jPanel.getHeight()) / 2);
        jPanel.setLocation(900, y);
        jPanel.validate();
    }

    public void operador(String permissao) {
        if (permissao.equals("Operador")) {
            jMenu2.setEnabled(false);
            checkBoxAuditoria.setEnabled(false);
        }
    }

    public void analista(String permissao) {
        if (permissao.equals("Analista")) {
            jMenu2.setEnabled(false);
            checkBoxAuditoria.setEnabled(false);
        }
    }

    public void chamaGraf() {
        Dimension d = new Dimension(dash.getWidth(), dash.getHeight());
        JFreeChart g = new GraphDAO().criargraficoBarras();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dash.setLayout(new BorderLayout());
        dash.add(chartPanel, null);
    }

    public void chamaGraf2() {
        Dimension d = new Dimension(dash.getWidth(), dash.getHeight());
        JFreeChart g = new GraphDAO().criargraficoPizza();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dash1.setLayout(new BorderLayout());
        dash1.add(chartPanel, null);

    }

    public void atualizaGraf() {
        dash.removeAll();
        dash.revalidate();
        Dimension d = new Dimension(dash.getWidth(), dash.getHeight());
        JFreeChart g = new GraphDAO().criargraficoBarras();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dash.setLayout(new BorderLayout());
        dash.add(chartPanel);
        dash.repaint();
    }

    public void atualizaGraf2() {
        dash1.removeAll();
        dash1.revalidate();
        Dimension d = new Dimension(dash1.getWidth(), dash1.getHeight());
        JFreeChart g = new GraphDAO().criargraficoPizza();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dash1.setLayout(new BorderLayout());
        dash1.add(chartPanel);
        dash1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        checkBoxAuditoria = new javax.swing.JCheckBox();
        dash = new javax.swing.JPanel();
        dash1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GerForm");

        jDesktopPane1.setBackground(Color.WHITE);

        checkBoxAuditoria.setText("Auditoria");
        checkBoxAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashLayout = new javax.swing.GroupLayout(dash);
        dash.setLayout(dashLayout);
        dashLayout.setHorizontalGroup(
            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        dashLayout.setVerticalGroup(
            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dash1Layout = new javax.swing.GroupLayout(dash1);
        dash1.setLayout(dash1Layout);
        dash1Layout.setHorizontalGroup(
            dash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        dash1Layout.setVerticalGroup(
            dash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jDesktopPane1.setLayer(checkBoxAuditoria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(dash, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(dash1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkBoxAuditoria))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(dash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(dash1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 435, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(450, 450, 450))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dash1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(checkBoxAuditoria)
                .addContainerGap())
        );

        jMenu1.setText("Cadastros");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/person-icon.png"))); // NOI18N
        jMenuItem4.setText("Usuário");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/truck-icon.png"))); // NOI18N
        jMenuItem1.setText("Fornecedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32381-bacon-icon.png"))); // NOI18N
        jMenuItem2.setText("Material");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Atom-icon.png"))); // NOI18N
        jMenuItem3.setText("Propriedades");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32378-meat-on-bone-icon.png"))); // NOI18N
        jMenuItem5.setText("Produto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Formulação");

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3d-material-eyedropper-tool-icon.png"))); // NOI18N
        jMenuItem12.setText("Inserir");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Relatórios");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transport-Truck-icon.png"))); // NOI18N
        jMenuItem9.setText("Fornecedores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Food-Steak-icon.png"))); // NOI18N
        jMenuItem10.setText("Material");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Document-Copy-icon.png"))); // NOI18N
        jMenuItem11.setText("Login por Data");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Auditoria");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SEO-icon.png"))); // NOI18N
        jMenuItem8.setText("Auditar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("E-mail");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mail-icon.png"))); // NOI18N
        jMenuItem13.setText("Enviar");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        IfrUsuario ifrUsuario = new IfrUsuario();
        jDesktopPane1.add(ifrUsuario);
        centralizarJInternalFrame(ifrUsuario);
        ifrUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        IfrFornecedor ifrFornecedor = new IfrFornecedor();
        jDesktopPane1.add(ifrFornecedor);
        centralizarJInternalFrame(ifrFornecedor);
        ifrFornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IfrMaterial ifrMaterial = new IfrMaterial();
        jDesktopPane1.add(ifrMaterial);
        centralizarJInternalFrame(ifrMaterial);
        ifrMaterial.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        IfrPropriedadesMaterial ifrPropriedadesMaterial = new IfrPropriedadesMaterial();
        jDesktopPane1.add(ifrPropriedadesMaterial);
        centralizarJInternalFrame(ifrPropriedadesMaterial);
        ifrPropriedadesMaterial.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        IfrAudit ifrAudit = new IfrAudit();
        jDesktopPane1.add(ifrAudit);
        centralizarJInternalFrame(ifrAudit);
        ifrAudit.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void checkBoxAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAuditoriaActionPerformed
        ligaAuditoria = !ligaAuditoria;
    }//GEN-LAST:event_checkBoxAuditoriaActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        IfrProduto ifrProduto = new IfrProduto();
        jDesktopPane1.add(ifrProduto);
        centralizarJInternalFrame(ifrProduto);
        ifrProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new Thread() {
            @Override
            public void run() {
                try {
                    // Compila o relatorio
                    JasperReport relatorio = JasperCompileManager.compileReport("src/main/java/Relatorio/RelatorioFornecedor.jrxml");
                    // Executa relatoio
                    JasperPrint impressao = JasperFillManager.fillReport(relatorio, null, ReportDAO.getInstance().getConnection());

                    // Exibe resultado em video
                    JasperViewer.viewReport(impressao, false);

                } catch (Exception e) {
                    System.out.println("Erro ao gerar relatório: " + e);
                }
            }
        }.start();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new Thread() {
            @Override
            public void run() {
                try {
                    // Compila o relatorio
                    JasperReport relatorio = JasperCompileManager.compileReport("src/main/java/Relatorio/RelatorioMaterial.jrxml");
                    // Executa relatoio
                    JasperPrint impressao = JasperFillManager.fillReport(relatorio, null, ReportDAO.getInstance().getConnection());

                    // Exibe resultado em video
                    JasperViewer.viewReport(impressao, false);

                } catch (Exception e) {
                    System.out.println("Erro ao gerar relatório: " + e);
                }
            }
        }.start();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        IfrRelLoginData ld = new IfrRelLoginData();
        centralizarJInternalFrame(ld);
        jDesktopPane1.add(ld);
        ld.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        IfrFormulacao tf = new IfrFormulacao();
        tf.setSize(1260, 670);
        centralizarJInternalFrame(tf);
        jDesktopPane1.add(tf);
        tf.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        IfrEmail ifrEmail = new IfrEmail();
        centralizarJInternalFrame(ifrEmail);
        jDesktopPane1.add(ifrEmail);
        ifrEmail.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxAuditoria;
    private javax.swing.JPanel dash;
    private javax.swing.JPanel dash1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
