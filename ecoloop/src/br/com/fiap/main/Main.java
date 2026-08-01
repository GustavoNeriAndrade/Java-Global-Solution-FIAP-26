package br.com.fiap.main;

import br.com.fiap.bean.Alerta;
import br.com.fiap.bean.Analista;
import br.com.fiap.bean.Coleta;
import br.com.fiap.bean.RelatorioCarbono;
import br.com.fiap.bean.Regiao;
import br.com.fiap.bean.Satelite;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,
                "Bem-vindo ao EcoLoop!\nSistema de Monitoramento de Desmatamento e Emissões de Carbono.",
                "EcoLoop", JOptionPane.INFORMATION_MESSAGE);

        boolean executando = true;

        while (executando) {

            String[] opcoes = {"Cadastrar Região", "Cadastrar Satélite", "Registrar Coleta",
                    "Cadastrar Analista", "Registrar Alerta", "Sair"};

            int escolha = JOptionPane.showOptionDialog(null,
                    "O que deseja fazer?",
                    "EcoLoop — Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, opcoes[0]);

            // Usuário fechou a janela ou clicou Sair
            if (escolha == 5 || escolha == JOptionPane.CLOSED_OPTION) {
                executando = false;
                continue;
            }

            switch (escolha) {

                // CADASTRO DE REGIÃO
                case 0: {
                    boolean sucesso = false;
                    while (!sucesso) {
                        try {
                            String input = JOptionPane.showInputDialog(null,
                                    "CADASTRO DE REGIÃO\n\n" +
                                            "Preencha os dados separados por vírgula:\n" +
                                            "Nome, Bioma, Estado (sigla), Latitude, Longitude, Área total (km²)\n\n",
                                    "EcoLoop - Região", JOptionPane.QUESTION_MESSAGE);

                            if (input == null) break;

                            String[] dados = input.split(",");
                            if (dados.length != 6)
                                throw new IllegalArgumentException("Informe exatamente 6 campos separados por vírgula.");

                            String nomeRegiao   = dados[0].trim();
                            String bioma        = dados[1].trim();
                            String estado       = dados[2].trim();
                            double latitude     = Double.parseDouble(dados[3].trim());
                            double longitude    = Double.parseDouble(dados[4].trim());
                            double areaTotalKm2 = Double.parseDouble(dados[5].trim());

                            Regiao regiao = new Regiao(1, nomeRegiao, bioma, estado, latitude, longitude, areaTotalKm2);

                            JOptionPane.showMessageDialog(null,
                                    "Região cadastrada com sucesso!\n\n",
                                    "EcoLoop - Região", JOptionPane.INFORMATION_MESSAGE);

                            sucesso = true;

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: Latitude, Longitude e Área devem ser números válidos.\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: " + e.getMessage() + "\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                }

                // CADASTRO DE SATÉLITE
                case 1: {
                    boolean sucesso = false;
                    while (!sucesso) {
                        try {
                            String input = JOptionPane.showInputDialog(null,
                                    "CADASTRO DE SATÉLITE\n\n" +
                                            "Preencha os dados separados por vírgula:\n" +
                                            "Nome, Agência, Altitude (km), Data de lançamento (AAAA-MM-DD)\n\n" +
                                            "Exemplo: Landsat 8, NASA, 705.00, 2013-02-11",
                                    "EcoLoop - Satélite", JOptionPane.QUESTION_MESSAGE);

                            if (input == null) break;

                            String[] dados = input.split(",");
                            if (dados.length != 4)
                                throw new IllegalArgumentException("Informe exatamente 4 campos separados por vírgula.");

                            String nomeSatelite = dados[0].trim();
                            String agencia      = dados[1].trim();
                            double altitude     = Double.parseDouble(dados[2].trim());
                            LocalDate dataLanc  = LocalDate.parse(dados[3].trim());

                            Satelite satelite = new Satelite(1, nomeSatelite, agencia, altitude, dataLanc);

                            JOptionPane.showMessageDialog(null,
                                    "Satélite cadastrado com sucesso!\n\n",
                                    "EcoLoop - Satélite", JOptionPane.INFORMATION_MESSAGE);

                            sucesso = true;

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: A altitude deve ser um número válido.\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (DateTimeParseException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: Data inválida. Use o formato AAAA-MM-DD.\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: " + e.getMessage() + "\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                }

                // REGISTRO DE COLETA
                case 2: {
                    boolean sucesso = false;
                    while (!sucesso) {
                        try {
                            String input = JOptionPane.showInputDialog(null,
                                    "REGISTRO DE COLETA\n\n" +
                                            "Preencha os dados separados por vírgula:\n" +
                                            "Data (AAAA-MM-DD), Hora (HH:MM:SS), Tipo de dado\n\n" +
                                            "Exemplo: 2026-05-20, 08:30:00, Imagem Óptica",
                                    "EcoLoop - Coleta", JOptionPane.QUESTION_MESSAGE);

                            if (input == null) break;

                            String[] dados = input.split(",");
                            if (dados.length != 3)
                                throw new IllegalArgumentException("Informe exatamente 3 campos separados por vírgula.");

                            LocalDate dataColeta = LocalDate.parse(dados[0].trim());
                            String horaColeta    = dados[1].trim();
                            String tipoDado      = dados[2].trim();

                            // Objetos fixos para demonstração
                            Regiao regiao = new Regiao(1, "Amazônia Sul", "Amazônia", "AM",
                                    -3.10, -60.02, 4196943.00);
                            Satelite satelite = new Satelite(1, "Landsat 8", "NASA",
                                    705.00, LocalDate.parse("2013-02-11"));

                            Coleta coleta = new Coleta(1, dataColeta, horaColeta, tipoDado,
                                    "Processado", regiao, satelite);

                            JOptionPane.showMessageDialog(null,
                                    "Coleta registrada com sucesso!\n\n",
                                    "EcoLoop - Coleta", JOptionPane.INFORMATION_MESSAGE);

                            sucesso = true;

                        } catch (DateTimeParseException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: Data inválida. Use o formato AAAA-MM-DD.\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: " + e.getMessage() + "\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                }

                // CADASTRO DE ANALISTA
                case 3: {
                    boolean sucesso = false;
                    while (!sucesso) {
                        try {
                            String input = JOptionPane.showInputDialog(null,
                                    "CADASTRO DE ANALISTA\n\n" +
                                            "Preencha os dados separados por vírgula:\n" +
                                            "Nome, E-mail, Órgão, Nível de acesso\n\n" +
                                            "Exemplo: João Silva, joao@ibama.gov.br, IBAMA, Administrador",
                                    "EcoLoop - Analista", JOptionPane.QUESTION_MESSAGE);

                            if (input == null) break;

                            String[] dados = input.split(",");
                            if (dados.length != 4)
                                throw new IllegalArgumentException("Informe exatamente 4 campos separados por vírgula.");

                            String nomeAnalista = dados[0].trim();
                            String email        = dados[1].trim();
                            String orgao        = dados[2].trim();
                            String nivelAcesso  = dados[3].trim();

                            Analista analista = new Analista(1, nomeAnalista, email, orgao, nivelAcesso);

                            JOptionPane.showMessageDialog(null,
                                    "Analista cadastrado com sucesso!\n\n",
                                    "EcoLoop - Analista", JOptionPane.INFORMATION_MESSAGE);

                            sucesso = true;

                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: " + e.getMessage() + "\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                }

                // REGISTRO DE ALERTA + MÉTODOS FUNCIONAIS
                case 4: {
                    boolean sucesso = false;
                    while (!sucesso) {
                        try {
                            String input = JOptionPane.showInputDialog(null,
                                    "REGISTRO DE ALERTA\n\n" +
                                            "Preencha os dados separados por vírgula:\n" +
                                            "Área desmatada (ha), Metodologia de carbono\n\n" +
                                            "Exemplo: 350.50, IPCC",
                                    "EcoLoop - Alerta", JOptionPane.QUESTION_MESSAGE);

                            if (input == null) break;

                            String[] dados = input.split(",");
                            if (dados.length != 2)
                                throw new IllegalArgumentException("Informe exatamente 2 campos separados por vírgula.");

                            double areaDesmatada = Double.parseDouble(dados[0].trim());
                            String metodologia   = dados[1].trim();

                            if (areaDesmatada <= 0)
                                throw new IllegalArgumentException("A área desmatada deve ser maior que zero.");

                            // Objetos fixos para demonstração
                            Regiao regiao = new Regiao(1, "Amazônia Sul", "Amazônia", "AM",
                                    -3.10, -60.02, 4196943.00);
                            Satelite satelite = new Satelite(1, "Landsat 8", "NASA",
                                    705.00, LocalDate.parse("2013-02-11"));
                            Coleta coleta = new Coleta(1, LocalDate.now(), "08:00:00",
                                    "Imagem Óptica", "Processado", regiao, satelite);
                            Analista analista = new Analista(1, "João Silva",
                                    "joao@ibama.gov.br", "IBAMA", "Administrador");

                            Alerta alerta = new Alerta(1, areaDesmatada, "Pendente",
                                    LocalDate.now(), analista, coleta);

                            // classificarSeveridade
                            JOptionPane.showMessageDialog(null,
                                    "RESULTADO: CLASSIFICAÇÃO DE SEVERIDADE\n\n" +
                                            "Área desmatada      : " + String.format("%.2f", areaDesmatada) + " ha\n" +
                                            "Nível de severidade : " + alerta.classificarSeveridade(),
                                    "EcoLoop - Severidade", JOptionPane.INFORMATION_MESSAGE);

                            // confirmarAlerta
                            RelatorioCarbono relatorio = alerta.confirmarAlerta(1, metodologia);

                            if (relatorio != null) {

                                // calcularCarbono
                                double co2 = relatorio.calcularCarbono();

                                JOptionPane.showMessageDialog(null,
                                        "RESULTADO: CÁLCULO DE CO2\n\n" +
                                                "Fator utilizado : 200 ton de CO2 por hectare\n" +
                                                "Área desmatada  : " + String.format("%.2f", areaDesmatada) + " ha\n" +
                                                "CO2 estimado    : " + String.format("%.2f", co2) + " toneladas métricas",
                                        "EcoLoop - Cálculo de CO2", JOptionPane.INFORMATION_MESSAGE);

                                // exibirResumoRelatorio
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

                                // TESTE: confirmar alerta já confirmado
                                RelatorioCarbono tentativa = alerta.confirmarAlerta(2, metodologia);

                                JOptionPane.showMessageDialog(null,
                                        "TESTE: Tentativa de confirmar alerta já confirmado\n\n" +
                                                "Status atual : " + alerta.getStatusAlerta() + "\n" +
                                                "Resultado    : " + (tentativa == null
                                                ? "Bloqueado — alerta já está Confirmado."
                                                : "Novo relatório gerado."),
                                        "EcoLoop - Teste", JOptionPane.WARNING_MESSAGE);
                            }

                            sucesso = true;

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: A área desmatada deve ser um número válido.\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Erro: " + e.getMessage() + "\nTente novamente.",
                                    "EcoLoop - Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                }
            }
        }

        JOptionPane.showMessageDialog(null,
                "Programa encerrado.\nObrigado por usar o EcoLoop!",
                "EcoLoop", JOptionPane.INFORMATION_MESSAGE);
    }
}