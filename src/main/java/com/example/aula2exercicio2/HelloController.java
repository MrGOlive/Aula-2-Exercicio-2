package com.example.aula2exercicio2;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField idNome;
    @FXML
    private ComboBox<String> idServico;
    @FXML
    private Spinner<Double> idQtdHoras;
    @FXML
    private Spinner<Double> idValorHora;
    @FXML
    private Spinner<Double> idDesconto;
    @FXML
    private TextField idDescricao;
    @FXML
    private TextArea idResultado;

    private Double valorBruto = null;
    private Double valorFinal = null;
    private Double valorDesconto = null;

    @FXML
    public void initialize(){
        idServico.getItems().addAll("Instalação", "Manutenção", "Suporte técnico");
        idQtdHoras.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 500, 1.0, 1));
        idValorHora.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 5000, 1, 1));
        idDesconto.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 100, 1, 1));

    }

    @FXML
    public void CalcularOrcamento(){
        String nome = idNome.getText();
        String servico = idServico.getValue();
        String descricao = idDescricao.getText();
        Double qtdHoras = idQtdHoras.getValue();
        Double valorHora = idValorHora.getValue();
        Double desconto = idDesconto.getValue();

        // TRATAMENTO DE ERRO EM CASO DE CAMPOS EM BRANCO
        if (nome == null || nome.isBlank() || servico == null || descricao == null || descricao.isBlank() || qtdHoras == null || valorHora == null || desconto == null){
            idResultado.setText("Todos os campos são obrigatórios.");
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }

        // CALCULO VALOR BRUTO
        valorBruto = qtdHoras * valorHora;

        // CALCULO VALOR DO DESCONTO
        valorDesconto = (valorBruto * desconto) / 100;

        // CALCULO VALOR FINAL
        valorFinal = valorBruto - valorDesconto;

        String Resultado = """
                Nome do cliente: %s
                Tipo de serviço: %s
                Descrição do serviço: %s
                Quantidade de horas: %.2f
                Valor por hora: %.2f
                Percentual de desconto: %.2f
                Valor bruto: %.2f
                Valor do desconto: %.2f
                Valor final do orçamento: %.2f
                """.formatted(nome, servico, descricao, qtdHoras, valorHora, desconto, valorBruto, valorDesconto, valorFinal);

        idResultado.setText(Resultado);
    }



}