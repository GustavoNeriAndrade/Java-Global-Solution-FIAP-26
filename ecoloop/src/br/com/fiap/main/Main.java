package br.com.fiap.main;

import br.com.fiap.bean.Alerta;
import br.com.fiap.bean.Analista;
import br.com.fiap.bean.Coleta;
import br.com.fiap.bean.RelatorioCarbono;
import br.com.fiap.bean.Regiao;
import br.com.fiap.bean.Satelite;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,
                "Bem-vindo ao EcoLoop!\nSistema de Monitoramento de Desmatamento e Emissões de Carbono.",
                "EcoLoop", JOptionPane.INFORMATION_MESSAGE);

        // INSTANCIAÇÃO: Regiao
        String nomeRegiao = JOptionPane.showInputDialog(null,
                "CADASTRO DE REGIÃO\nNome da região:", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        String bioma = JOptionPane.showInputDialog(null,
                "Bioma da região:", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        String estado = JOptionPane.showInputDialog(null,
                "Estado da região (sigla):", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        double latitude = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Latitude da região (ex: -3.10):", "EcoLoop", JOptionPane.QUESTION_MESSAGE));

        double longitude = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Longitude da região (ex: -60.02):", "EcoLoop", JOptionPane.QUESTION_MESSAGE));

        double areaTotalKm2 = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Área total da região em km²:", "EcoLoop", JOptionPane.QUESTION_MESSAGE));

        Regiao regiao = new Regiao(1, nomeRegiao, bioma, estado, latitude, longitude, areaTotalKm2);

        JOptionPane.showMessageDialog(null,
                "Região cadastrada com sucesso!", "EcoLoop - Região", JOptionPane.INFORMATION_MESSAGE);

        // INSTANCIAÇÃO: Satelite
        String nomeSatelite = JOptionPane.showInputDialog(null,
                "CADASTRO DE SATÉLITE\nNome do satélite:", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        String agencia = JOptionPane.showInputDialog(null,
                "Agência operadora (ex: NASA, ESA, INPE):", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        double altitude = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Altitude orbital em km (ex: 705.50):", "EcoLoop", JOptionPane.QUESTION_MESSAGE));

        LocalDate dataLancamento = LocalDate.parse(JOptionPane.showInputDialog(null,
                "Data de lançamento (AAAA-MM-DD):", "EcoLoop", JOptionPane.QUESTION_MESSAGE));

        Satelite satelite = new Satelite(1, nomeSatelite, agencia, altitude, dataLancamento);

        JOptionPane.showMessageDialog(null,
                "Satélite cadastrado com sucesso!",
                "EcoLoop - Satélite", JOptionPane.INFORMATION_MESSAGE);

        // INSTANCIAÇÃO: Coleta
        LocalDate dataColeta = LocalDate.parse(JOptionPane.showInputDialog(null,
                "REGISTRO DE COLETA\nData da coleta (AAAA-MM-DD):", "EcoLoop", JOptionPane.QUESTION_MESSAGE));

        String horaColeta = JOptionPane.showInputDialog(null,
                "Hora da coleta (HH:MM:SS):", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        String tipoDado = JOptionPane.showInputDialog(null,
                "Tipo de dado coletado (ex: Imagem Óptica, Radar):", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        Coleta coleta = new Coleta(1, dataColeta, horaColeta, tipoDado, "Processado", regiao, satelite);

        JOptionPane.showMessageDialog(null,
                "Coleta registrada com sucesso!",
                "EcoLoop - Coleta", JOptionPane.INFORMATION_MESSAGE);

        // INSTANCIAÇÃO: Analista
        String nomeAnalista = JOptionPane.showInputDialog(null,
                "CADASTRO DE ANALISTA\nNome do analista:", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        String emailAnalista = JOptionPane.showInputDialog(null,
                "E-mail do analista:", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        String orgao = JOptionPane.showInputDialog(null,
                "Órgão vinculado (ex: IBAMA, INPE):", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        String nivelAcesso = JOptionPane.showInputDialog(null,
                "Nível de acesso (ex: Administrador, Operador):", "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        Analista analista = new Analista(1, nomeAnalista, emailAnalista, orgao, nivelAcesso);

        JOptionPane.showMessageDialog(null,
                "Analista cadastrado com sucesso!",
                "EcoLoop - Analista", JOptionPane.INFORMATION_MESSAGE);

        // INSTANCIAÇÃO: Alerta
        double areaDesmatada = Double.parseDouble(JOptionPane.showInputDialog(null,
                "REGISTRO DE ALERTA\nÁrea desmatada em hectares (ex: 350.50):", "EcoLoop", JOptionPane.QUESTION_MESSAGE));

        Alerta alerta = new Alerta(1, areaDesmatada, "Pendente", LocalDate.now(), analista, coleta);

        JOptionPane.showMessageDialog(null,
                "Alerta registrado com sucesso!",
                "EcoLoop - Alerta", JOptionPane.INFORMATION_MESSAGE);

        //classificarSeveridade
        String severidade = alerta.classificarSeveridade();

        JOptionPane.showMessageDialog(null,
                "RESULTADO: CLASSIFICAÇÃO DE SEVERIDADE\n\n" +
                        "Área desmatada      : " + areaDesmatada + " ha\n" +
                        "Nível de severidade : " + severidade,
                "EcoLoop - Severidade", JOptionPane.INFORMATION_MESSAGE);

        //confirmarAlerta
        String metodologia = JOptionPane.showInputDialog(null,
                "CONFIRMAÇÃO DE ALERTA\nMetodologia de cálculo de carbono (ex: IPCC, SEEG):",
                "EcoLoop", JOptionPane.QUESTION_MESSAGE);

        RelatorioCarbono relatorio = alerta.confirmarAlerta(1, metodologia);

        if (relatorio != null) {
            JOptionPane.showMessageDialog(null,
                    "Alerta #" + alerta.getIdAlerta() + " confirmado com sucesso!\n" +
                            "Relatório de carbono gerado automaticamente.\n\n" +
                            relatorio.toString(),
                    "EcoLoop - Alerta Confirmado", JOptionPane.INFORMATION_MESSAGE);
        }

        //calcularCarbono
        if (relatorio != null) {
            double co2 = relatorio.calcularCarbono();

            JOptionPane.showMessageDialog(null,
                    "RESULTADO: CÁLCULO DE CO2\n\n" +
                            "Fator utilizado : 200 ton de CO2 por hectare (floresta tropical)\n" +
                            "Área desmatada  : " + String.format("%.2f", areaDesmatada) + " ha\n" +
                            "CO2 estimado    : " + String.format("%.2f", co2) + " toneladas métricas",
                    "EcoLoop - Cálculo de CO2", JOptionPane.INFORMATION_MESSAGE);
        }

        //exibirResumoRelatorio
        if (relatorio != null) {
            JOptionPane.showMessageDialog(null,
                    "RELATÓRIO DE CARBONO - EcoLoop\n\n" +
                            "Relatório ID    : " + relatorio.getIdRelatorio() + "\n" +
                            "Data de Geração : " + relatorio.getDataGeracao() + "\n" +
                            "Metodologia     : " + relatorio.getMetodologia() + "\n" +
                            "----------------------------------------\n" +
                            "Alerta ID       : " + alerta.getIdAlerta() + "\n" +
                            "Status Alerta   : " + alerta.getStatusAlerta() + "\n" +
                            "Área Desmatada  : " + String.format("%.2f", alerta.getAreaDesmatadaHa()) + " ha\n" +
                            "Severidade      : " + alerta.getNivelSeveridade() + "\n" +
                            "Região          : " + coleta.getRegiao().getNomeRegiao() + "\n" +
                            "Bioma           : " + coleta.getRegiao().getBiomaRegiao() + "\n" +
                            "Estado          : " + coleta.getRegiao().getEstadoRegiao() + "\n" +
                            "Analista        : " + analista.getNomeAnalista() + "\n" +
                            "Órgão           : " + analista.getOrgaoVinculado() + "\n" +
                            "----------------------------------------\n" +
                            "CO2 Estimado    : " + String.format("%.2f", relatorio.getCo2EstimadoTonelada()) + " toneladas métricas",
                    "EcoLoop - Resumo do Relatório", JOptionPane.INFORMATION_MESSAGE);
        }

        // teste: tentar confirmar o mesmo alerta novamente
        RelatorioCarbono tentativa = alerta.confirmarAlerta(2, metodologia);

        JOptionPane.showMessageDialog(null,
                "TESTE: Tentativa de confirmar alerta já confirmado\n\n" +
                        "Status atual do alerta : " + alerta.getStatusAlerta() + "\n" +
                        "Resultado              : " + (tentativa == null ? "Bloqueado — alerta já está Confirmado." : "Novo relatório gerado."),
                "EcoLoop - Teste", JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Programa encerrado.\nObrigado por usar o EcoLoop!",
                "EcoLoop", JOptionPane.INFORMATION_MESSAGE);
    }
}