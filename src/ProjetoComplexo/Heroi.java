package ProjetoComplexo;

import java.util.Random;

public class Heroi {

    private String nome;
    private int vida;
    private int pocoes;

    private boolean defesaEstaAtiva = false;
    private boolean ataqueEspecialEstaAtivo = true;
    private int xp;

    public Heroi(String nome, int vida, int pocoes) {
        this.nome = nome;
        this.vida = vida;
        this.pocoes = pocoes;
    }

    public int atacar(Random random, int vidaDoInimigo) {
        int dano = random.nextInt(4) + 8;
        boolean critico = random.nextInt(100) <= 20;
        if(critico) {
            dano *= 2;
            System.out.println(this.nome + " fez um ataque crítico que causou -" +  dano + " PV ❤️");
        } else {
            System.out.println(this.nome + " fez um ataque que causou -" +  dano + " PV ❤️");
        }
        vidaDoInimigo -= dano;
        System.out.println("🐉 Vida atual do Monstro: " + vidaDoInimigo);
        return vidaDoInimigo;
    }

    public void usarPocao() {
        if(this.pocoes > 0) {
            System.out.println(this.nome + " usou uma poção! 🎒");
            this.vida += 15;
            this.pocoes--;
        } else {
            System.out.println(this.nome + " está sem poções!");
        }
    }
    public void defender() {
        System.out.println(this.nome + " se defendeu e consegiu -50% de dano! 🛡️");
        setDefesaEstaAtiva(true);
    }

    public int ataqueEspecial(int vidaDoInimigo) {
        if(ataqueEspecialEstaAtivo) {
            System.out.println(this.nome + " usou o ataque especial! 🪬");
            setAtaqueEspecialEstaAtivo(false);
            return vidaDoInimigo - 25;
        } else {
            System.out.println("O poder especial já foi usado! ❌");
            return vidaDoInimigo;
        }
    }

    public void fugir() {
        System.out.println(this.nome + " fugiu da batalha e correu para as montanhas");
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

    public int getPocoes() {
        return pocoes;
    }

    public void setPocoes(int pocoes) {
        this.pocoes = pocoes;
    }

    public boolean isDefesaEstaAtiva() {
        return defesaEstaAtiva;
    }

    public void setDefesaEstaAtiva(boolean defesaEstaAtiva) {
        this.defesaEstaAtiva = defesaEstaAtiva;
    }

    public boolean isAtaqueEspecialEstaAtivo() {
        return ataqueEspecialEstaAtivo;
    }

    public void setAtaqueEspecialEstaAtivo(boolean ataqueEspecialEstaAtivo) {
        this.ataqueEspecialEstaAtivo = ataqueEspecialEstaAtivo;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
