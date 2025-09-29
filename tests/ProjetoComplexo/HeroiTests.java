package ProjetoComplexo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class HeroiTests {


    @Test
    public void sucessoAtacarTest() {
        // Criando instâncias
        Monstro monstroExemplo = new Monstro("Insectoid", 100);
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 3);
        Random random = new Random();

        // Retorna a nova vida do monstro;
        int novaVidaDoMonstro = heroiExemplo.atacar(random, monstroExemplo.getVida());

        // Verifica se a nova vida do monstro é diferente a vida do monstro antes de alterar
        Assert.assertTrue(monstroExemplo.getVida() > novaVidaDoMonstro);
        monstroExemplo.setVida(novaVidaDoMonstro);
        Assert.assertEquals(monstroExemplo.getVida(), novaVidaDoMonstro);
    }

    @Test
    public void sucessoUsarPocaoTest() {
        // Criando instância
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 1);

        // Testes antes de usar a poção
        Assert.assertNotEquals(0, heroiExemplo.getPocoes());
        Assert.assertEquals(100, heroiExemplo.getVida());

        // Adicionar +15 de vida e -1 poção no estoque
        heroiExemplo.usarPocao();

        // Testes após usar a poção
        Assert.assertEquals(0, heroiExemplo.getPocoes());
        Assert.assertEquals(115, heroiExemplo.getVida());
    }

    @Test
    public void falhaUsarPocaoTest() {
        // Criando instância
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 1);
        heroiExemplo.setPocoes(0);

        // Testes antes de usar a poção
        Assert.assertEquals(0, heroiExemplo.getPocoes());
        Assert.assertEquals(100, heroiExemplo.getVida());

        // Adicionar +15 de vida e -1 poção no estoque - NESSE CASO NÃO DEVE FUNCIONAR DEVIDO AO ESTOQUE
        heroiExemplo.usarPocao();

        // Testes após usar a poção
        Assert.assertEquals(0, heroiExemplo.getPocoes());
        Assert.assertNotEquals(115, heroiExemplo.getVida());
    }

    @Test
    public void sucessoDefenderTest() {
        // Criando instância
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 1);

        // Verifica se a defesa está inativa (false)
        Assert.assertFalse(heroiExemplo.isDefesaEstaAtiva());

        // Método que ativa a defesa
        heroiExemplo.defender();

        // Verifica se a defesa está ativa (true)
        Assert.assertTrue(heroiExemplo.isDefesaEstaAtiva());
    }

    @Test
    public void sucessoDefenderNaoAtivoTest() {
        // Criando instância
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 1);

        // Verifica se a defesa está inativa (false)
        Assert.assertFalse(heroiExemplo.isDefesaEstaAtiva());

        // Método que ativa a defesa
        heroiExemplo.defender();

        // Editando dado para retornar a ser inativa
        heroiExemplo.setDefesaEstaAtiva(false);

        // Verifica se a defesa está inativa (false)
        Assert.assertFalse(heroiExemplo.isDefesaEstaAtiva());
    }

    @Test
    public void sucessoAtaqueEspecialTest() {
        // Criando instâncias
        Monstro monstroExemplo = new Monstro("Insectoid", 100);
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 1);

        // Verifica se o Ataque Especial está ativo (true) por padrão
        Assert.assertTrue(heroiExemplo.isAtaqueEspecialEstaAtivo());

        // Método que ativa o ataque especial
        int novaVidaDoMonstro = heroiExemplo.ataqueEspecial(monstroExemplo.getVida());

        // Testes da vida do monstro
        Assert.assertTrue(monstroExemplo.getVida() > novaVidaDoMonstro);
        monstroExemplo.setVida(novaVidaDoMonstro);
        Assert.assertEquals(monstroExemplo.getVida(), novaVidaDoMonstro);

        // Verifica se o Ataque Especial está inativo (false)
        Assert.assertFalse(heroiExemplo.isAtaqueEspecialEstaAtivo());

    }

    @Test
    public void falhaAtaqueEspecialTest() {
        // Criando instâncias
        Monstro monstroExemplo = new Monstro("Insectoid", 100);
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 1);

        // Verifica se o Ataque Especial está ativo (true) por padrão
        Assert.assertTrue(heroiExemplo.isAtaqueEspecialEstaAtivo());

        // Altera o Ataque Especial para inativo (false) e verifica
        heroiExemplo.setAtaqueEspecialEstaAtivo(false);
        Assert.assertFalse(heroiExemplo.isAtaqueEspecialEstaAtivo());

        // Método que ativa o ataque especial
        int novaVidaDoMonstro = heroiExemplo.ataqueEspecial(monstroExemplo.getVida());

        // Verfica se a vida do Monstro não alterou nada
        Assert.assertEquals(monstroExemplo.getVida(), novaVidaDoMonstro);

        // Verifica se o Ataque Especial continua inativo (false)
        Assert.assertFalse(heroiExemplo.isAtaqueEspecialEstaAtivo());
    }


    @Test
    public void sucessoFugirTest() {
        Heroi heroiExemplo = new Heroi("Aric Stormblade", 100, 1);

        heroiExemplo.fugir();
    }
}
