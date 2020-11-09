/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidade.FormulacaoTableGraf;
import Entidade.FormulacaoTableGraf1;
import Entidade.UsuarioLogado;
import static Util.HibernateUtil.sessionFactory;
import Util.Log;
import java.awt.Color;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Klein
 */
public class GraphDAO {

    //public static void main(String[] args) throws Exception {
    public JFreeChart criargraficoBarras() {
        String sql = "";
        Session sessao = null;
        Transaction transacao = null;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        sql = "SELECT a.produto_id, p.descricao, a.custo_elaborado\n"
                + "FROM formulacao a\n "
                + "JOIN produto p ON a.produto_id=p.id\n"
                + "ORDER BY custo_elaborado ASC";
        try {
            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            transacao = sessao.beginTransaction();

            List<FormulacaoTableGraf> mt = (List<FormulacaoTableGraf>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(FormulacaoTableGraf.class))
                    .list();

            for (int i = 0; i < mt.size(); i++) {

                dataset.setValue(mt.get(i).getCusto_elaborado(), mt.get(i).getDescricao(), "");
            }

        } catch (HibernateException hibEx) {
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }

        JFreeChart barChart = ChartFactory.createBarChart("Custo Elaborado por Formulação", //titulo
                "Formulação", //legenda do grafico
                "Custo Elaborado R$", //unidade de medida
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        
        //barChart.getPlot().setBackgroundPaint(Color.cyan);

        return barChart;
    }

    public JFreeChart criargraficoPizza() {
        String sql = "";
        Session sessao = null;
        Transaction transacao = null;
        DefaultPieDataset dataset = new DefaultPieDataset();
        sql = "SELECT m.descricao, (SELECT DISTINCT COUNT (m.descricao)) "
                + "AS numero FROM item_formulacao i JOIN material m\n"
                + "ON i.material_id=m.id JOIN produto p on i.formulacao_produto_id=p.id\n"
                + "GROUP BY m.descricao";
        try {
            sessao = Util.HibernateUtil.getSessionFactory().getCurrentSession();
            transacao = sessao.beginTransaction();

            List<FormulacaoTableGraf1> mt = (List<FormulacaoTableGraf1>) sessionFactory
                    .getCurrentSession()
                    .createSQLQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(FormulacaoTableGraf1.class))
                    .list();

            for (int i = 0; i < mt.size(); i++) {

                dataset.setValue(mt.get(i).getDescricao(), mt.get(i).getNumero());
            }

        } catch (HibernateException hibEx) {
            transacao.rollback();
            Log.geraLogBD(UsuarioLogado.getUsuarioLogadoEmail(), "Query", hibEx.toString());
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Material por Formulação", // chart title           
                dataset, // data           
                true, // include legend          
                true,
                false);
        //chart.getPlot().setBackgroundPaint(Color.cyan);

        return chart;
    }
}
