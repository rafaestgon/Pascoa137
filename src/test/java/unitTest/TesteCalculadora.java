package unitTest;

// Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe
public class TesteCalculadora {
    // Atributos


    // Funções e Métodos
    @Test
    public void testeSomarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 12;

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println("O resultado da soma é: " + resultadoAtual);
    }

    // Este é um teste de unidade data driven - direcionado por dados
    @ParameterizedTest
    @CsvSource(value = {"7,5,12", "56,44,100", "10,0,10", "15,-5,10", "-8,-6,-14"}, delimiter = ',')
    public void testeSomarDoisNumerosLendoLista(String num1, String num2, String resultadoEsperado){
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(num1), Integer.valueOf(num2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
        System.out.println("O resultado da soma é: " + resultadoAtual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumerosLendoArquivo(String num1, String num2, String resultadoEsperado){
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(num1), Integer.valueOf(num2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
        System.out.println("O resultado da soma é: " + resultadoAtual);
    }

    @Test
    public void testeSubtrairDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 10;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 5;

        // Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println("O resultado da subtração é: " + resultadoAtual);
    }

    @Test
    public void testeMultiplicarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 5;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 25;

        // Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println("O resultado da multiplicação é: " + resultadoAtual);
    }

    @Test
    public void testeDividirDoisNumerosInteiros(){
        // Configura
        // Valores de entrada
        int numA = 50;
        int numB = 0;
        // Valores de saída
        String resultadoEsperado = "Não é possível dividir por zero!";

        // Executa
        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + "Não é possível dividir por zero!");
    }

    @Test
    public void testeDividirDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 100;
        double num2 = 10;
        // Valores de saída
        double resultadoEsperado = 10;

        // Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println("O resultado da divisão é: " + resultadoAtual);
    }

}
