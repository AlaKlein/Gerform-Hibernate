/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Dao.GraphDAO;
import Dao.ReportDAO;
import Entidade.UsuarioLogado;
import Util.Formatacao;
import Util.MoveFile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
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

    /**
     * Creates new form FrmPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        operador(UsuarioLogado.getUsuarioLogadoPermissao());
        analista(UsuarioLogado.getUsuarioLogadoPermissao());
        this.setExtendedState(MAXIMIZED_BOTH);
        checkBoxAuditoria.setSelected(true);
        jDesktopPane1.remove(dashPrincipal);
        CentralizarJpanel(dashPrincipal);
        chamaGrafEsquerda();
        chamaGrafDireita();
        jLabel1.setText("Bem-Vindo ao Gerform " + UsuarioLogado.getUsuarioLogadoEmail());
        jLabel1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
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
        frame.toFront();
    }

    private void CentralizarJpanel(JPanel jpanel) {
        dashPrincipal = new JPanel();
        dashPrincipal.revalidate();
        dashPrincipal.repaint();
        jDesktopPane1.add(jpanel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - jpanel.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - jpanel.getHeight()) / 2);
        jpanel.setLocation(x, y - 50);
    }

    public void chamaGrafEsquerda() {
        Dimension d = new Dimension(dashEsquerda.getWidth(), dashEsquerda.getHeight());
        JFreeChart g = new GraphDAO().criargraficoBarras();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dashEsquerda.setLayout(new BorderLayout());
        dashEsquerda.add(chartPanel, null);
    }

    public void chamaGrafDireita() {
        Dimension d = new Dimension(dashDireita.getWidth(), dashDireita.getHeight());
        JFreeChart g = new GraphDAO().criargraficoPizza();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dashDireita.setLayout(new BorderLayout());
        dashDireita.add(chartPanel, null);
    }

    public void atualizaGrafEsquerda() {
        dashEsquerda.removeAll();
        dashEsquerda.revalidate();
        Dimension d = new Dimension(dashEsquerda.getWidth(), dashEsquerda.getHeight());
        JFreeChart g = new GraphDAO().criargraficoBarras();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dashEsquerda.setLayout(new BorderLayout());
        dashEsquerda.add(chartPanel);
        dashEsquerda.repaint();
    }

    public void atualizaGrafDireita() {
        dashDireita.removeAll();
        dashDireita.revalidate();
        Dimension d = new Dimension(dashDireita.getWidth(), dashDireita.getHeight());
        JFreeChart g = new GraphDAO().criargraficoPizza();
        ChartPanel chartPanel = new ChartPanel(g);
        chartPanel.setPreferredSize(d);
        dashDireita.setLayout(new BorderLayout());
        dashDireita.add(chartPanel);
        dashDireita.repaint();
    }

    public void operador(String permissao) {
        if (permissao.equals("Operador")) {
            jMenu2.setEnabled(false);
            checkBoxAuditoria.setEnabled(false);
            jMenuItem14.setEnabled(false);
        }
    }

    public void analista(String permissao) {
        if (permissao.equals("Analista")) {
            jMenu2.setEnabled(false);
            checkBoxAuditoria.setEnabled(false);
            jMenuItem14.setEnabled(false);
        }
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
        dashPrincipal = new javax.swing.JPanel();
        dashEsquerda = new javax.swing.JPanel();
        dashDireita = new javax.swing.JPanel();
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
        jMenuItem14 = new javax.swing.JMenuItem();
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

        dashPrincipal.setBackground(new java.awt.Color(0, 204, 204));
        dashPrincipal.setPreferredSize(new java.awt.Dimension(1260, 670));
        dashPrincipal.setBackground(Color.WHITE);

        javax.swing.GroupLayout dashEsquerdaLayout = new javax.swing.GroupLayout(dashEsquerda);
        dashEsquerda.setLayout(dashEsquerdaLayout);
        dashEsquerdaLayout.setHorizontalGroup(
            dashEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        dashEsquerdaLayout.setVerticalGroup(
            dashEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dashDireitaLayout = new javax.swing.GroupLayout(dashDireita);
        dashDireita.setLayout(dashDireitaLayout);
        dashDireitaLayout.setHorizontalGroup(
            dashDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        dashDireitaLayout.setVerticalGroup(
            dashDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setBackground(Color.WHITE);

        javax.swing.GroupLayout dashPrincipalLayout = new javax.swing.GroupLayout(dashPrincipal);
        dashPrincipal.setLayout(dashPrincipalLayout);
        dashPrincipalLayout.setHorizontalGroup(
            dashPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashPrincipalLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(dashEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(dashDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(dashPrincipalLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashPrincipalLayout.setVerticalGroup(
            dashPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(dashPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        jDesktopPane1.setLayer(checkBoxAuditoria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(dashPrincipal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(checkBoxAuditoria))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(dashPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(dashPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkBoxAuditoria))
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

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clipboard-Paste-icon.png"))); // NOI18N
        jMenuItem14.setText("Limites");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

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
        IfrUsuario ifrUsuario = IfrUsuario.getInstance();
        centralizarJInternalFrame(ifrUsuario);
        if (ifrUsuario.isVisible()) {
        } else {
            jDesktopPane1.add(ifrUsuario);
            ifrUsuario.setVisible(true);
        }
        
        
//        IfrUsuario ifrUsuario = IfrUsuario.getInstance();
//        centralizarJInternalFrame(ifrUsuario);
//        if (ifrUsuario.isVisible()) {
//        } else {
//            jDesktopPane1.add(ifrUsuario);
//            ifrUsuario.setVisible(true);
//        }

//        IfrUsuario ifrUsuario = new IfrUsuario();
//        jDesktopPane1.add(ifrUsuario);
//        centralizarJInternalFrame(ifrUsuario);
//        ifrUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        IfrFornecedor ifrFornecedor = IfrFornecedor.getInstance();
        centralizarJInternalFrame(ifrFornecedor);
        if (ifrFornecedor.isVisible()) {
        } else {
            jDesktopPane1.add(ifrFornecedor);
            ifrFornecedor.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IfrMaterial ifrMaterial = IfrMaterial.getInstance();
        centralizarJInternalFrame(ifrMaterial);
        if (ifrMaterial.isVisible()) {
        } else {
            jDesktopPane1.add(ifrMaterial);
            ifrMaterial.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        IfrPropriedadesMaterial ifrPropriedadesMaterial = IfrPropriedadesMaterial.getInstance();
        centralizarJInternalFrame(ifrPropriedadesMaterial);
        if (ifrPropriedadesMaterial.isVisible()) {
        } else {
            jDesktopPane1.add(ifrPropriedadesMaterial);
            ifrPropriedadesMaterial.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        IfrAudit ifrAudit = IfrAudit.getInstance();
        centralizarJInternalFrame(ifrAudit);
        if (ifrAudit.isVisible()) {
        } else {
            jDesktopPane1.add(ifrAudit);
            ifrAudit.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void checkBoxAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAuditoriaActionPerformed
        ligaAuditoria = !ligaAuditoria;
    }//GEN-LAST:event_checkBoxAuditoriaActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        IfrProduto ifrProduto = IfrProduto.getInstance();
        centralizarJInternalFrame(ifrProduto);
        if (ifrProduto.isVisible()) {
        } else {
            jDesktopPane1.add(ifrProduto);
            ifrProduto.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new Thread() {
            @Override
            public void run() {
                try {
                    // Compila o relatorio
                    File target = new java.io.File("RelatorioFornecedor.jrxml");
                    JasperReport relatorio = JasperCompileManager.compileReport(target.toString());
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
                    File target = new java.io.File("RelatorioMaterial.jrxml");
                    JasperReport relatorio = JasperCompileManager.compileReport(target.toString());
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
        IfrRelLoginData ld = IfrRelLoginData.getInstance();
        centralizarJInternalFrame(ld);
        if (ld.isVisible()) {
        } else {
            jDesktopPane1.add(ld);
            ld.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        IfrFormulacao tf = IfrFormulacao.getInstance();
        tf.setSize(1260, 670);
        centralizarJInternalFrame(tf);
        if (tf.isVisible()) {
        } else {
            jDesktopPane1.add(tf);
            tf.setVisible(true);
        }
        
//        IfrFormulacao tf = new IfrFormulacao();
//        tf.setSize(1260, 670);
//        centralizarJInternalFrame(tf);
//        jDesktopPane1.add(tf);
//        tf.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        IfrEmail ifrEmail = IfrEmail.getInstance();
        centralizarJInternalFrame(ifrEmail);
        if (ifrEmail.isVisible()) {
        } else {
            jDesktopPane1.add(ifrEmail);
            ifrEmail.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        JFileChooser jfc;
        Formatacao.traduzirJfc();
        String URL = "";
        String retorno;
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setMultiSelectionEnabled(false);
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("PDF (*.PDF)", "pdf");
        jfc.addChoosableFileFilter(restrict);
        jfc.setDialogTitle("Selecione o arquivo desejado:");
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            URL = selectedFile.getAbsolutePath();
        }
        if (!URL.equals("")) {
            retorno = MoveFile.move(URL);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Arquivo movido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao mover o arquivo: " + retorno);
            }
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxAuditoria;
    private javax.swing.JPanel dashDireita;
    private javax.swing.JPanel dashEsquerda;
    private javax.swing.JPanel dashPrincipal;
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
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
