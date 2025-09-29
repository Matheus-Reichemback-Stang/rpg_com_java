package ProjetoComplexo;

import java.util.Random;

/**
 * @author Matheus Reichemback Stang
 */
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

    /**
     * Método que faz um ataque a vida de algum inimigo
     *
     * @param random - Define o <b>dano de ataque</b> a ser causado e se foi um <b>dano crítico</b>.
     * @param vidaDoInimigo - <b>Vida atual do inimigo</b> que vai sofrer o ataque.
     * @return A nova vida do inimigo após o ataque.
     */
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

    /**
     * Método que usa uma poção do estoque de poções. Se haver um poção, ele usa ela e <b>acrescenta mais
     * 15 de vida no heroi</b> e <b>diminui -1 poção do estoque</b>, senão houver poções, ele passa uma mensagem
     * informando o usuário que não há poções no estoque.
     */
    public void usarPocao() {
        if(this.pocoes > 0) {
            System.out.println(this.nome + " usou uma poção! 🎒");
            this.vida += 15;
            this.pocoes--;
        } else {
            System.out.println(this.nome + " está sem poções!");
        }
    }

    /**
     * Método que ativa a defesa do herói e faz com que ele sofra -50% do dano
     * que ele ia receber no round onde a defesa foi acionada.
     */
    public void defender() {
        System.out.println(this.nome + " se defendeu e consegiu -50% de dano! 🛡️");
        setDefesaEstaAtiva(true);
    }

    /**
     * Método que faz um ataque especial que causa <b>-25 de vida no inimigo</b>. Vale lembrar que o
     * Ataque Especial só pode ser usado 1 vez por partida, sendo assim, o método verifica se o Ataque
     * Especial está ativo para ser usado, caso contrário, apenas é exibido uma mensagem informando que
     * o ataque especial já foi usado.
     *
     * @param vidaDoInimigo - <b>Vida atual do inimigo</b> que vai sofrer o ataque especial.
     * @return A nova vida do inimigo após o ataque.
     */
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

    /**
     * Método que passa uma mensagem informando a fuga do herói na batalha.
     */
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
