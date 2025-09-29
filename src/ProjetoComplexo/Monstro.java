package ProjetoComplexo;

import java.util.Random;

/**
 * @author Matheus Reichemback Stang
 */
public class Monstro {

    private String nome;
    private int vida;
    private int xp;

    public Monstro(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    /**
     * Método que faz um ataque a vida de algum Heroi.
     *
     * @param random - Define o <b>dano de ataque</b> a ser causado e se foi um <b>dano crítico</b>.
     * @param heroi - Instância da classe Heroi que é usada para manipulação da vida do herói.
     *
     * @see Heroi para mais informações.
     */
    public void atacar(Random random, Heroi heroi) {
        int ataqueMonstro = random.nextInt(10) + 5; // dano entre 5 e 15
        boolean critico = random.nextInt(100) <= 15; // 15% de chance crítico
        if (critico) {
            ataqueMonstro *= 2;
            System.out.println("O " + this.nome + " acertou um CRÍTICO! 💥");
        }
        if(heroi.isDefesaEstaAtiva()) {
            ataqueMonstro = ataqueMonstro / 2;
            heroi.setDefesaEstaAtiva(false);
        }
        heroi.setVida(heroi.getVida() - ataqueMonstro);
        System.out.println("🐉 O " + this.nome +" atacou e causou " + ataqueMonstro + " de dano!");
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
