package ProjetoComplexo;

import java.util.Random;

public class Monstro {

    private String nome;
    private int vida;
    private int xp;

    public Monstro(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

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
